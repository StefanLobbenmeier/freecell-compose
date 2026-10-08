const { defineConfig, devices } = require('@playwright/test');

// Serve the actual Pages artifact under a subdirectory, as on GitHub Pages.
// A .localhost host enables the app's service worker while staying on loopback.
const baseURL = process.env.WEB_TEST_URL || 'http://freecell.localhost:4173/productionExecutable/';

module.exports = defineConfig({
  testDir: './tests/web',
  timeout: 60_000,
  expect: { timeout: 30_000 },
  workers: 1,
  use: {
    baseURL,
    locale: 'en-US',
    screenshot: 'only-on-failure',
    trace: 'retain-on-failure',
  },
  projects: [
    { name: 'chromium', use: { ...devices['Desktop Chrome'] } },
    { name: 'mobile-chromium', use: { ...devices['Pixel 7'] } },
  ],
  webServer: process.env.WEB_TEST_URL ? undefined : {
    command: 'python3 -m http.server 4173 --bind 127.0.0.1 --directory composeApp/build/dist/wasmJs',
    url: 'http://127.0.0.1:4173/productionExecutable/',
    reuseExistingServer: !process.env.CI,
  },
});
