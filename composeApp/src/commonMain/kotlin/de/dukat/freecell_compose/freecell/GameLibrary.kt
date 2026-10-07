package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.GameState
import de.dukat.freecell_compose.freecell.model.newGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class SavedGame(val id: Int, val startingPosition: GameState, val currentState: GameState) {
    val shared: SharedGame get() = SharedGame(startingPosition, currentState)
}

data class LibraryState(val games: List<SavedGame> = emptyList(), val automaticSafeMoves: Boolean = true) {
    val played: Int get() = games.size
    val won: Int get() = games.count { it.currentState.isWon }
    val abandoned: List<SavedGame> get() = games.filterNot { it.currentState.isWon }
}

/** An unfinished record is always saved, including when the app closes unexpectedly. */
class GameLibrary(private val persistence: GameStatePersistence = createPlatformGameStatePersistence()) {
    private val mutableState = MutableStateFlow(load())
    val state: StateFlow<LibraryState> = mutableState
    var activeId: Int? = null
        private set

    private fun load(): LibraryState {
        val archive = persistence.loadArchive()
        if (archive != null) {
            val lines = archive.lines()
            if (lines.firstOrNull() == "library1") {
                val games = lines.drop(2).mapNotNull { line ->
                    val id = line.substringBefore(':').toIntOrNull() ?: return@mapNotNull null
                    val game = decodeGame(line.substringAfter(':')) ?: return@mapNotNull null
                    SavedGame(id, game.startingPosition, game.currentState)
                }.distinctBy { it.id }
                return LibraryState(games, lines.getOrNull(1) != "manual")
            }
        }
        // Old saves have no opening position; use the restore point as their restart baseline.
        val legacy = persistence.load() ?: return LibraryState()
        return LibraryState(listOf(SavedGame(1, legacy, legacy)))
    }

    fun start(seed: Int? = null): FreecellStore {
        val position = newGame(seed)
        return importGame(SharedGame(position, position))
    }

    fun importGame(game: SharedGame): FreecellStore {
        val id = (state.value.games.maxOfOrNull { it.id } ?: 0) + 1
        update(state.value.copy(games = state.value.games + SavedGame(id, game.startingPosition, game.currentState)))
        return retry(id)
    }

    fun retry(id: Int): FreecellStore {
        val game = state.value.games.first { it.id == id }
        activeId = id
        return FreecellStore(game.currentState, object : GameStatePersistence {
            override fun load(): GameState? = null
            override fun save(state: GameState) {
                update(this@GameLibrary.state.value.copy(games = this@GameLibrary.state.value.games.map {
                    if (it.id == id) it.copy(currentState = state) else it
                }))
            }
        })
    }

    fun restart(): FreecellStore {
        val game = activeGame() ?: error("No active game")
        update(state.value.copy(games = state.value.games.map {
            if (it.id == game.id) it.copy(currentState = game.startingPosition) else it
        }))
        return retry(game.id)
    }

    fun activeGame(): SavedGame? = state.value.games.firstOrNull { it.id == activeId }
    fun leaveGame() { activeId = null }
    fun setAutomaticSafeMoves(enabled: Boolean) = update(state.value.copy(automaticSafeMoves = enabled))

    private fun update(next: LibraryState) {
        persistence.saveArchive(buildString {
            appendLine("library1")
            appendLine(if (next.automaticSafeMoves) "auto" else "manual")
            next.games.forEach { appendLine("${it.id}:${encodeGame(it.shared)}") }
        })
        mutableState.value = next
    }
}
