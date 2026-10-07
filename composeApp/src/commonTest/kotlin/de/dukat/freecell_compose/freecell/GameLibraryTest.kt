package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.*
import kotlin.test.*

class GameLibraryTest {
    private class MemoryPersistence : GameStatePersistence {
        var archive: String? = null
        var legacy: GameState? = null
        override fun load() = legacy
        override fun save(state: GameState) { legacy = state }
        override fun loadArchive() = archive
        override fun saveArchive(serialized: String) { archive = serialized }
    }

    @Test
    fun unfinishedGameSurvivesReopeningAndRetryKeepsItsIdentity() {
        val persistence = MemoryPersistence()
        val library = GameLibrary(persistence)
        val store = library.start(42)
        val initial = store.uiState.value.state
        store.tryMove(Move(PileId.Tableau(0), initial.tableau[0].lastIndex, PileId.FreeCell(0)))
        val saved = store.uiState.value.state
        library.leaveGame()

        val reopened = GameLibrary(persistence)
        assertEquals(1, reopened.state.value.played)
        assertEquals(1, reopened.state.value.abandoned.size)
        assertEquals(saved, reopened.retry(1).uiState.value.state)
        assertEquals(initial, reopened.activeGame()?.startingPosition)
        assertEquals(initial, reopened.restart().uiState.value.state)
        assertEquals(1, reopened.state.value.played)
    }

    @Test
    fun winningARetriedGameRemovesItFromAbandonedAndCountsOnce() {
        val persistence = MemoryPersistence()
        val almostWon = GameState(
            tableau = listOf(listOf(Card(Suit.Spades, 13))) + List(7) { emptyList() },
            freeCells = List(4) { null },
            foundations = Suit.entries.associateWith { suit -> (1..if (suit == Suit.Spades) 12 else 13).map { Card(suit, it) } },
        )
        GameLibrary(persistence).importGame(SharedGame(newGame(42), almostWon))
        val library = GameLibrary(persistence)
        val store = library.retry(1)
        store.tryMove(Move(PileId.Tableau(0), 0, PileId.Foundation(Suit.Spades)))
        assertEquals(1, library.state.value.won)
        assertEquals(1, library.state.value.played)
        assertTrue(library.state.value.abandoned.isEmpty())
        assertEquals(1, GameLibrary(persistence).state.value.won)
        library.retry(1)
        assertEquals(1, library.state.value.won)
        store.undo()
        assertEquals(0, library.state.value.won)
        assertEquals(1, library.state.value.abandoned.size)
    }

    @Test
    fun settingsSurviveReopeningAndStartingAnotherGamePreservesTheFirst() {
        val persistence = MemoryPersistence()
        val library = GameLibrary(persistence)
        library.start(1)
        library.setAutomaticSafeMoves(false)
        library.start(2)
        val reopened = GameLibrary(persistence)
        assertFalse(reopened.state.value.automaticSafeMoves)
        assertEquals(2, reopened.state.value.played)
        assertEquals(2, reopened.state.value.abandoned.size)
    }

    @Test
    fun shareLinkRoundTripsBothPositionsAndRejectsMalformedGames() {
        val initial = newGame(3)
        val store = FreecellStore(initial, NoOpGameStatePersistence)
        store.tryMove(Move(PileId.Tableau(0), initial.tableau[0].lastIndex, PileId.FreeCell(0)))
        val shared = SharedGame(initial, store.uiState.value.state)
        val link = gameShareLink("https://example.com/freecell/#old", shared)
        assertEquals(shared, decodeGameLink(link))
        val encoded = link.substringAfter("#game=")
        assertTrue(encoded.length < 150)
        assertTrue(encoded.all { it.isLetterOrDigit() || it in "-_.~" })
        assertFalse('=' in encoded)
        assertNull(decodeGameLink("https://example.com/#game=bad"))
        assertNull(decodeGame("x".repeat(8193)))
        val duplicate = initial.copy(tableau = initial.tableau.mapIndexed { index, cards ->
            if (index == 0) cards.dropLast(1) + initial.tableau[1].first() else cards
        })
        assertNull(decodeGame(encodeGame(SharedGame(initial, duplicate))))
        val invalidFoundation = initial.copy(
            tableau = initial.tableau.map { cards -> cards.filterNot { it == Card(Suit.Clubs, 2) } },
            foundations = initial.foundations + (Suit.Clubs to listOf(Card(Suit.Clubs, 2))),
        )
        assertNull(decodeGame(encodeGame(SharedGame(initial, invalidFoundation))))
    }

    @Test
    fun legacyRestorePointIsMigratedWithoutLosingTheBoard() {
        val persistence = MemoryPersistence().also { it.legacy = newGame(9) }
        val library = GameLibrary(persistence)
        val original = library.retry(1).uiState.value.state
        assertEquals(persistence.legacy, original)
        library.leaveGame()
        assertEquals(original, GameLibrary(persistence).state.value.games.single().currentState)
    }
}
