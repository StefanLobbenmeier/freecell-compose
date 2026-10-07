This is a Kotlin Multiplatform project targeting Web.

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
    - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
    - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
      For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
      the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
      Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
      folder is the appropriate location.

### Games, statistics, and sharing

The main menu starts new random games and lists unfinished games under Abandoned games.
Retry resumes the saved position. Played counts distinct games; retries and restarts keep the same
record. Winning removes the game from Abandoned and adds it to Won. Undoing a win or restarting a
finished game returns that record to unfinished status.
After the final winning animation, a dialog shows overall statistics and offers a new random game
sharing, or a return to the finished board.

Settings are available via the gear icon on the menu and game screen. They include language, restart from the original deal, automatic safe foundation moves, and sharing.
Share links include both the original deal and the current position. Open them in the web app or
paste them into the main menu, including on desktop. Sharing attempts to copy the link immediately.
The link remains visible in a read-only input; clicking it selects the full link and retries copying,
with confirmation after a successful clipboard write. Browser links use the current app URL;
desktop links point to the project's GitHub Pages deployment.

Game and share payload encoding lives in
`composeApp/src/commonMain/kotlin/de/dukat/freecell_compose/freecell/GameCodec.kt`.
The versioned URL-safe payload contains both complete boards and validates incoming cards and
foundations. Browser history is stored in localStorage; desktop history is stored in
`~/.freecell-compose/game-archive.txt`. Existing single-board saves are migrated with their saved
position as the restart baseline because the original deal was not previously stored.

### Localization

The app uses [Compose Multiplatform string resources](https://kotlinlang.org/docs/multiplatform/compose-localize-strings.html)
in `composeApp/src/commonMain/composeResources`: English in `values`, German in `values-de`,
Brazilian Portuguese in `values-pt`, and Spanish in `values-es`. The Portuguese translation also
serves as the fallback for other Portuguese locales. Unsupported device languages fall back to English.
Parameterized strings keep sentence ordering in the translation files; card descriptions and move
errors are localized too. Card face rank symbols retain their standard A/J/Q/K notation.

Language defaults to the system/browser locale. Settings offers System default, English, Deutsch,
Português (Brasil), and Español. The choice updates the UI immediately and persists in browser
localStorage or desktop Java Preferences. Returning to System default clears the override.
Locale overrides follow the platform adapters in the official
[resource environment guide](https://kotlinlang.org/docs/multiplatform/compose-resource-environment.html).
The game library, navigation, board position, and undo history live outside the locale key so changing
language preserves the current game. The browser adapter runs before Compose starts, restores the
saved choice, and updates the document language. The offline page and update prompt share that choice.

### Build and Run Web Application

To build and run the development version of the web app, use the run configuration from the run widget
in your IDE's toolbar or run it directly from the terminal:

- for the Wasm target (faster, modern browsers):
    - on macOS/Linux
      ```shell
      ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
      ```
    - on Windows
      ```shell
      .\gradlew.bat :composeApp:wasmJsBrowserDevelopmentRun
      ```
- for the JS target (slower, supports older browsers):
    - on macOS/Linux
      ```shell
      ./gradlew :composeApp:jsBrowserDevelopmentRun
      ```
    - on Windows
      ```shell
      .\gradlew.bat :composeApp:jsBrowserDevelopmentRun
      ```

### Offline (iPhone Home Screen / PWA)

The web build includes a simple service worker (`sw.js`) that caches the app shell so it keeps working when added to the iPhone Home Screen and the device goes offline.

- Install on iPhone: open the app in Safari -> Share -> Add to Home Screen.
- First run must be online (so the service worker can cache the assets).
- Updates: when the phone is online and a new release is deployed, the app will download it in the background and prompt to reload.

To produce the distributable folder (includes `sw.js` and `offline.html`):

```shell
./gradlew :composeApp:wasmJsBrowserDistribution
```

Output folder:
- `composeApp/build/dist/wasmJs/productionExecutable/`

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack
channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [YouTrack](https://youtrack.jetbrains.com/newIssue?project=CMP).
