package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.Card
import de.dukat.freecell_compose.freecell.model.CardRef
import de.dukat.freecell_compose.freecell.model.GameState
import de.dukat.freecell_compose.freecell.model.Move
import de.dukat.freecell_compose.freecell.model.PileId
import de.dukat.freecell_compose.freecell.model.Suit
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class FreecellStoreTest {
    private fun undoState(vararg cards: Card) = GameState(
        tableau = listOf(cards.toList()) + List(7) { emptyList<Card>() },
        freeCells = List(4) { null },
        foundations = Suit.entries.associateWith { emptyList<Card>() },
    )

    @Test
    fun undo_restoresManualMoveAndFollowingAutoMoves() {
        val initial = undoState(Card(Suit.Clubs, 2), Card(Suit.Clubs, 1), Card(Suit.Hearts, 7))
        val persistence = InMemoryPersistence()
        val store = FreecellStore(initial, persistence)

        store.tryMove(Move(PileId.Tableau(0), 2, PileId.FreeCell(0)))
        assertNotNull(store.tryAutoSolveStep())
        assertNotNull(store.tryAutoSolveStep())
        assertTrue(store.uiState.value.canUndo)

        store.undo()

        assertEquals(initial, store.uiState.value.state)
        assertEquals(initial, persistence.saved)
        assertFalse(store.uiState.value.canUndo)
    }

    @Test
    fun undo_revertsOnlyLastManualMoveWhenThereAreNoAutoMoves() {
        val initial = undoState(Card(Suit.Hearts, 7))
        val store = FreecellStore(initial, NoOpGameStatePersistence)
        store.tryMove(Move(PileId.Tableau(0), 0, PileId.FreeCell(0)))
        val afterFirstMove = store.uiState.value.state
        store.tryMove(Move(PileId.FreeCell(0), 0, PileId.Tableau(1)))

        store.undo()
        assertEquals(afterFirstMove, store.uiState.value.state)
        assertTrue(store.uiState.value.canUndo)

        store.undo()
        assertEquals(initial, store.uiState.value.state)
        assertFalse(store.uiState.value.canUndo)
    }

    @Test
    fun openingAutoMoves_stayAsBaselineAndDoNotEnableUndo() {
        val store = FreecellStore(
            undoState(Card(Suit.Hearts, 7), Card(Suit.Clubs, 2), Card(Suit.Clubs, 1)),
            NoOpGameStatePersistence,
        )

        assertNotNull(store.tryAutoSolveStep())
        assertFalse(store.uiState.value.canUndo)
        assertNotNull(store.tryAutoSolveStep())
        assertNull(store.tryAutoSolveStep())
        val baseline = store.uiState.value.state
        assertEquals(listOf(Card(Suit.Clubs, 1), Card(Suit.Clubs, 2)), baseline.foundations.getValue(Suit.Clubs))
        assertFalse(store.uiState.value.canUndo)

        store.undo()
        assertEquals(baseline, store.uiState.value.state)

        store.tryMove(Move(PileId.Tableau(0), 0, PileId.FreeCell(0)))
        assertTrue(store.uiState.value.canUndo)
        store.undo()
        assertEquals(baseline, store.uiState.value.state)
        assertFalse(store.uiState.value.canUndo)
    }

    private class InMemoryPersistence(initial: GameState? = null) : GameStatePersistence {
        var saved: GameState? = initial

        override fun load(): GameState? = saved

        override fun save(state: GameState) {
            saved = state
        }
    }

    @Test
    fun tryMove_updatesAnalysisInUiState() {
        val stateBefore = GameState(
            tableau = listOf(
                listOf(
                    Card(Suit.Clubs, 7),
                    Card(Suit.Diamonds, 6),
                ),
                listOf(Card(Suit.Hearts, 8)),
                listOf(
                    Card(Suit.Spades, 13),
                    Card(Suit.Hearts, 12),
                ),
                listOf(Card(Suit.Clubs, 9)),
                listOf(Card(Suit.Diamonds, 9)),
                listOf(Card(Suit.Spades, 9)),
                listOf(Card(Suit.Hearts, 9)),
                listOf(Card(Suit.Clubs, 10)),
            ),
            freeCells = listOf(
                Card(Suit.Hearts, 2),
                Card(Suit.Spades, 3),
                Card(Suit.Diamonds, 4),
                null,
            ),
            foundations = Suit.entries.associateWith { emptyList<Card>() },
        )

        val store = FreecellStore(stateBefore, NoOpGameStatePersistence)

        val startRef = CardRef(PileId.Tableau(0), 0)
        val toCol = PileId.Tableau(1)
        assertNotNull(store.uiState.value.analysis.movesFrom[startRef]?.firstOrNull { it.to == toCol })

        // Fill the last freecell to reduce capacity; this should make the 2-card move unavailable.
        store.tryMove(Move(from = PileId.Tableau(2), fromIndex = 1, to = PileId.FreeCell(3), count = 1))

        assertNull(store.uiState.value.analysis.movesFrom[startRef]?.firstOrNull { it.to == toCol })
    }

    @Test
    fun tryClickMove_cyclesThroughDestinationsForSameCard() {
        val state = GameState(
            tableau = listOf(
                listOf(Card(Suit.Spades, 6)),
                listOf(Card(Suit.Hearts, 7)),
                listOf(Card(Suit.Diamonds, 7)),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
            ),
            freeCells = List(4) { null },
            foundations = Suit.entries.associateWith { emptyList<Card>() },
        )

        val store = FreecellStore(state, NoOpGameStatePersistence)

        store.tryClickMove(CardRef(PileId.Tableau(0), 0))
        assertEquals(listOf(Card(Suit.Hearts, 7), Card(Suit.Spades, 6)), store.uiState.value.state.tableau[1])

        store.tryClickMove(CardRef(PileId.Tableau(1), 1))
        assertEquals(listOf(Card(Suit.Diamonds, 7), Card(Suit.Spades, 6)), store.uiState.value.state.tableau[2])
    }

    @Test
    fun pickClickMove_matchesTryClickMoveSelection() {
        val state = GameState(
            tableau = listOf(
                listOf(Card(Suit.Spades, 6)),
                listOf(Card(Suit.Hearts, 7)),
                listOf(Card(Suit.Diamonds, 7)),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
            ),
            freeCells = List(4) { null },
            foundations = Suit.entries.associateWith { emptyList<Card>() },
        )

        val store = FreecellStore(state, NoOpGameStatePersistence)

        assertEquals(
            Move(from = PileId.Tableau(0), fromIndex = 0, to = PileId.Tableau(1), count = 1),
            store.pickClickMove(CardRef(PileId.Tableau(0), 0))
        )

        store.tryClickMove(CardRef(PileId.Tableau(0), 0))

        assertEquals(
            Move(from = PileId.Tableau(1), fromIndex = 1, to = PileId.Tableau(2), count = 1),
            store.pickClickMove(CardRef(PileId.Tableau(1), 1))
        )
    }

    @Test
    fun tryClickMove_prefersFoundationThenFreeCellBeforeEmptyColumn() {
        val state = GameState(
            tableau = listOf(
                listOf(Card(Suit.Clubs, 1)),
                emptyList(),
                listOf(Card(Suit.Diamonds, 5)),
                listOf(Card(Suit.Hearts, 5)),
                listOf(Card(Suit.Spades, 5)),
                listOf(Card(Suit.Clubs, 5)),
                listOf(Card(Suit.Diamonds, 6)),
                listOf(Card(Suit.Hearts, 6)),
            ),
            freeCells = List(4) { null },
            foundations = Suit.entries.associateWith { emptyList<Card>() },
        )

        val store = FreecellStore(state, NoOpGameStatePersistence)

        store.tryClickMove(CardRef(PileId.Tableau(0), 0))
        assertEquals(listOf(Card(Suit.Clubs, 1)), store.uiState.value.state.foundations.getValue(Suit.Clubs))

        store.tryClickMove(CardRef(PileId.Foundation(Suit.Clubs), 0))
        assertEquals(Card(Suit.Clubs, 1), store.uiState.value.state.freeCells[0])
        assertTrue(store.uiState.value.state.tableau[1].isEmpty())
    }

    @Test
    fun tryClickMove_usesLeftmostFreeCellWhenNoOtherOptionExists() {
        val state = GameState(
            tableau = listOf(
                listOf(Card(Suit.Clubs, 1)),
                listOf(Card(Suit.Diamonds, 5)),
                listOf(Card(Suit.Hearts, 5)),
                listOf(Card(Suit.Spades, 5)),
                listOf(Card(Suit.Clubs, 5)),
                listOf(Card(Suit.Diamonds, 6)),
                listOf(Card(Suit.Hearts, 6)),
                listOf(Card(Suit.Spades, 6)),
            ),
            freeCells = List(4) { null },
            foundations = Suit.entries.associateWith { emptyList<Card>() },
        )

        val store = FreecellStore(state, NoOpGameStatePersistence)

        store.tryClickMove(CardRef(PileId.Tableau(0), 0))
        assertEquals(listOf(Card(Suit.Clubs, 1)), store.uiState.value.state.foundations.getValue(Suit.Clubs))

        store.tryClickMove(CardRef(PileId.Foundation(Suit.Clubs), 0))
        assertEquals(Card(Suit.Clubs, 1), store.uiState.value.state.freeCells[0])
    }

    @Test
    fun store_restoresSavedGameWhenNoInitialStateIsProvided() {
        val savedState = GameState(
            tableau = listOf(
                listOf(Card(Suit.Clubs, 13)),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
            ),
            freeCells = List(4) { null },
            foundations = Suit.entries.associateWith { emptyList<Card>() },
        )
        val persistence = InMemoryPersistence(savedState)

        val store = FreecellStore(persistence = persistence)

        assertEquals(savedState, store.uiState.value.state)
    }

    @Test
    fun tryMove_savesUpdatedState() {
        val state = GameState(
            tableau = listOf(
                listOf(Card(Suit.Clubs, 7)),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
            ),
            freeCells = List(4) { null },
            foundations = Suit.entries.associateWith { emptyList<Card>() },
        )
        val persistence = InMemoryPersistence()
        val store = FreecellStore(state, persistence)

        store.tryMove(Move(from = PileId.Tableau(0), fromIndex = 0, to = PileId.FreeCell(0), count = 1))

        assertEquals(store.uiState.value.state, persistence.saved)
    }

    @Test
    fun gameStateCodec_roundTripsState() {
        val state = GameState(
            tableau = listOf(
                listOf(Card(Suit.Clubs, 1), Card(Suit.Diamonds, 10)),
                listOf(Card(Suit.Hearts, 2)),
                listOf(Card(Suit.Spades, 3)),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
            ),
            freeCells = listOf(Card(Suit.Clubs, 4), null, Card(Suit.Spades, 5), null),
            foundations = mapOf(
                Suit.Clubs to listOf(Card(Suit.Clubs, 1)),
                Suit.Diamonds to emptyList(),
                Suit.Hearts to listOf(Card(Suit.Hearts, 1), Card(Suit.Hearts, 2)),
                Suit.Spades to emptyList(),
            ),
        )

        val encoded = encodeGameState(state)

        assertEquals("v1-aw.B.P.....-d_R_-a..AB.", encoded)
        assertEquals(state, decodeGameState(encoded))
    }
}
