const { test: base, expect } = require('@playwright/test');

const test = base.extend({
  runtimeErrors: [async ({ page }, use) => {
    // A mixed Compose dependency upgrade built successfully but threw
    // "CompositionLocal LocalHostDefaultProvider not present" on startup.
    const errors = [];
    page.on('pageerror', error => errors.push(error.message));
    await use(errors);
    expect(errors, 'Production app must not throw during startup or navigation').toEqual([]);
  }, { auto: true }],
});

async function expectMenu(page) {
  // Compose renders to canvas, but exports accessible controls into its shadow
  // DOM. Checking a usable control catches crashes after the bundle loads;
  // checking only HTTP 200, the title, or a canvas element would miss them.
  await expect(page.getByRole('button', { name: 'Start', exact: true })).toBeVisible();
  await expect(page.getByRole('button', { name: 'Settings', exact: true })).toBeVisible();
}

async function clickButton(page, name) {
  const button = page.getByRole('button', { name, exact: true });
  await expect(button).toBeVisible();
  // Compose's canvas overlays the semantics DOM and handles real pointer
  // events. Click the control's bounds through that overlay.
  await button.click({ force: true });
}

test('production app renders and navigates between menu, settings, and game', async ({ page }) => {
  await page.goto('./');
  await expectMenu(page);

  await clickButton(page, 'Settings');
  await expect(page.getByRole('button', { name: 'System default', exact: true })).toBeVisible();
  await clickButton(page, 'Back');
  await expectMenu(page);

  await clickButton(page, 'Start');
  await expect(page.getByRole('button', { name: 'Menu', exact: true })).toBeVisible();
  await expect(page.getByRole('button', { name: 'Undo', exact: true })).toBeVisible();
  await clickButton(page, 'Menu');
  await expectMenu(page);
  await expect(page.getByRole('button', { name: 'Retry', exact: true })).toBeVisible();

  await page.reload();
  await expectMenu(page);
  await expect(page.getByRole('button', { name: 'Retry', exact: true })).toBeVisible();
});

test('installed production app boots and starts a game offline', async ({ page, context }) => {
  await page.goto('./');
  await expectMenu(page);
  await page.evaluate(() => navigator.serviceWorker.ready);
  await expect.poll(() => page.evaluate(() => Boolean(navigator.serviceWorker.controller))).toBe(true);

  // Load once through the installed worker so lazily loaded UI resources are
  // cached too, then prove that a fresh document can render without a network.
  await page.reload();
  await expectMenu(page);
  await context.setOffline(true);
  await page.reload();
  await expectMenu(page);
  await clickButton(page, 'Start');
  await expect(page.getByRole('button', { name: 'Menu', exact: true })).toBeVisible();
});
