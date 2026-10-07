package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.GameState

interface GameStatePersistence {
    fun load(): GameState?
    fun save(state: GameState)
    fun loadArchive(): String? = null
    fun saveArchive(serialized: String) = Unit
}

object NoOpGameStatePersistence : GameStatePersistence {
    override fun load(): GameState? = null
    override fun save(state: GameState) = Unit
}

expect fun createPlatformGameStatePersistence(): GameStatePersistence
internal const val GAME_STATE_STORAGE_KEY = "freecell-compose.game-state"
internal const val GAME_ARCHIVE_STORAGE_KEY = "freecell-compose.game-archive"
