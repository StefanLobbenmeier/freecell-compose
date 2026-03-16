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

self.addEventListener('install', (event) => {
  event.waitUntil(
    (async () => {
      const cache = await caches.open(CACHE_NAME);
      await cache.addAll(CORE_ASSETS);
      await self.skipWaiting();
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
    self.skipWaiting();
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
          cache.put('./', response.clone());
          cache.put('./index.html', response.clone());
          return response;
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
