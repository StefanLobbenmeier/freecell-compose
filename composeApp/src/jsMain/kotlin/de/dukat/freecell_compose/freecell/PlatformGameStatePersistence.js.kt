package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.GameState
import kotlinx.browser.window

actual object PlatformGameStatePersistence : GameStatePersistence {
    override fun load(): GameState? = runCatching {
        window.localStorage.getItem(GAME_STATE_STORAGE_KEY)?.let(::decodeGameState)
    }.getOrNull()

    override fun save(state: GameState) {
        runCatching {
            window.localStorage.setItem(GAME_STATE_STORAGE_KEY, encodeGameState(state))
        }
    }
}
