package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.GameState
import kotlinx.browser.window

private class BrowserGameStatePersistence : GameStatePersistence {
    override fun loadArchive(): String? = runCatching {
        window.localStorage.getItem(GAME_ARCHIVE_STORAGE_KEY)
    }.getOrNull()

    override fun saveArchive(serialized: String) {
        runCatching { window.localStorage.setItem(GAME_ARCHIVE_STORAGE_KEY, serialized) }
    }

    override fun load(): GameState? = runCatching {
        window.localStorage.getItem(GAME_STATE_STORAGE_KEY)?.let(::decodeGameState)
    }.getOrNull()

    override fun save(state: GameState) {
        runCatching {
            window.localStorage.setItem(GAME_STATE_STORAGE_KEY, encodeGameState(state))
        }
    }
}

actual fun createPlatformGameStatePersistence(): GameStatePersistence = BrowserGameStatePersistence()
