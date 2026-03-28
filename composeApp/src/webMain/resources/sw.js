/* Simple app-shell service worker.
 * - Caches core assets on install
 * - Serves cached content when offline
 * - Updates in the background and prompts via page logic
 */

const VERSION = 'SET_DURING_CI';
const CACHE_NAME = `freecell-${VERSION}`;

const CORE_ASSETS = [
  './',
  './index.html',
  './styles.css',
  './composeApp.js',
  './manifest.webmanifest',
  './icons/icon-192.png',
  './icons/icon-512.png',
  './icons/maskable-192.png',
  './icons/maskable-512.png',
  './icons/apple-touch-icon.png',
  './icons/favicon-32.png',
  './offline.html'
];

const INSTALL_CODE_ASSET_LIMIT = 64;

function uniq(arr) {
  return Array.from(new Set(arr));
}

function urlInScope(urlStr) {
  try {
    const u = new URL(urlStr);
    return u.origin === self.location.origin && u.pathname.startsWith(new URL(self.registration.scope).pathname);
  } catch (_) {
    return false;
  }
}

function extractExtraAssetsFromBundleText(text) {
  // Kotlin/Wasm + webpack-like bundles embed asset filenames as string literals.
  // We only extract root-level chunk files and hashed wasm names.
  const out = [];

  const wasmRe = /\b[0-9a-f]{8,}\.wasm\b/g;
  const jsChunkRe = /\b\d+\.js\b/g;
  const chunkIdRe = /\b[\w$]+\.e\((\d+)\)/g;

  const wasm = text.match(wasmRe) || [];
  const chunks = text.match(jsChunkRe) || [];
  const chunkIds = [];
  for (const m of text.matchAll(chunkIdRe)) {
    if (m && m[1]) chunkIds.push(m[1]);
  }

  for (const w of wasm) out.push(`./${w}`);
  for (const c of chunks) out.push(`./${c}`);
  for (const id of chunkIds) out.push(`./${id}.js`);

  return uniq(out);
}

async function fetchOk(request) {
  const response = await fetch(request);
  if (!response || !response.ok) {
    const status = response ? response.status : 'no-response';
    throw new Error(`SW precache failed: ${request.url} (${status})`);
  }
  return response;
}

async function precacheRequest(cache, request) {
  const response = await fetchOk(request);
  await cache.put(request, response);
}

async function precacheExtraCodeAssets(cache) {
  const compose = await cache.match('./composeApp.js', { ignoreSearch: true });
  if (!compose) return;

  let text = '';
  try {
    text = await compose.clone().text();
  } catch (_) {
    return;
  }

  const discovered = extractExtraAssetsFromBundleText(text).slice(0, INSTALL_CODE_ASSET_LIMIT);
  if (discovered.length === 0) return;

  const scope = self.registration.scope;
  const requests = discovered
    .map((p) => new Request(new URL(p, scope).toString(), { cache: 'no-cache' }))
    .filter((r) => urlInScope(r.url));

  for (const req of requests) {
    // If any of these fail (e.g. a missing .wasm during a non-atomic deploy),
    // the install fails and the old service worker stays active.
    await precacheRequest(cache, req);

    // Some bundles may reference additional .wasm files only from chunk JS.
    if (req.url.endsWith('.js')) {
      try {
        const res = await cache.match(req, { ignoreSearch: true });
        if (!res) continue;
        const chunkText = await res.clone().text();
        const extra = extractExtraAssetsFromBundleText(chunkText);
        for (const p of extra) {
          const wasmReq = new Request(new URL(p, scope).toString(), { cache: 'no-cache' });
          if (!wasmReq.url.endsWith('.wasm')) continue;
          if (!urlInScope(wasmReq.url)) continue;
          await precacheRequest(cache, wasmReq);
        }
      } catch (_) {
        // If parsing fails, keep going; we already precached the chunk itself.
      }
    }
  }
}

self.addEventListener('install', (event) => {
  event.waitUntil(
    (async () => {
      const cache = await caches.open(CACHE_NAME);
      await cache.addAll(CORE_ASSETS);
      await precacheExtraCodeAssets(cache);
    })()
  );
});

self.addEventListener('activate', (event) => {
  event.waitUntil(
    (async () => {
      const keys = await caches.keys();
      await Promise.all(
        keys
          .filter((k) => k.startsWith('freecell-') && k !== CACHE_NAME)
          .map((k) => caches.delete(k))
      );
      await self.clients.claim();
    })()
  );
});

self.addEventListener('message', (event) => {
  if (event && event.data && event.data.type === 'SKIP_WAITING') {
    event.waitUntil(self.skipWaiting());
  }
});

function isNavigation(request) {
  return request.mode === 'navigate' || (request.destination === 'document');
}

function isCodeAsset(url) {
  const p = url.pathname;
  return p.endsWith('.js') || p.endsWith('.mjs') || p.endsWith('.wasm');
}

self.addEventListener('fetch', (event) => {
  const request = event.request;
  if (request.method !== 'GET') return;

  event.respondWith(
    (async () => {
      const cache = await caches.open(CACHE_NAME);

      const url = new URL(request.url);

      if (isNavigation(request)) {
        // Always try to load a fresh HTML shell when online.
        const indexUrl = new URL('index.html', self.registration.scope);
        const indexRequest = new Request(indexUrl.toString(), { cache: 'no-cache' });
        try {
          const response = await fetch(indexRequest);
          if (response && response.ok) {
            cache.put('./', response.clone());
            cache.put('./index.html', response.clone());
            return response;
          }
          throw new Error('bad-index-response');
        } catch (_) {
          return (
            (await cache.match('./index.html', { ignoreSearch: true })) ||
            (await cache.match('./', { ignoreSearch: true })) ||
            (await cache.match('./offline.html'))
          );
        }
      }

      // JS/WASM files are content-addressed by filename in our bundles.
      // Prefer cache to avoid unnecessary network requests.
      if (isCodeAsset(url)) {
        const cached = await cache.match(request, { ignoreSearch: true });
        if (cached) return cached;

        try {
          const response = await fetch(request);
          if (response && response.ok) cache.put(request, response.clone());
          return response;
        } catch (_) {
          return Response.error();
        }
      }

      const cached = await cache.match(request, { ignoreSearch: true });
      if (cached) return cached;

      try {
        const response = await fetch(request);
        if (response && response.ok) {
          cache.put(request, response.clone());
        }
        return response;
      } catch (_) {
        return cached || Response.error();
      }
    })()
  );
});
