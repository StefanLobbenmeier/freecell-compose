package de.dukat.freecell_compose.freecell.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class FreecellRulesTest {
    private fun emptyFoundations(): Map<Suit, List<Card>> = Suit.entries.associateWith { emptyList() }

    @Test
    fun isSafeToMoveToFoundation_allowsAcesAndTwos() {
        val state = GameState(
            tableau = List(8) { emptyList() },
            freeCells = List(4) { null },
            foundations = emptyFoundations(),
        )

        assertTrue(isSafeToMoveToFoundation(state, Card(Suit.Clubs, 1)))
        assertTrue(isSafeToMoveToFoundation(state, Card(Suit.Diamonds, 2)))
    }

    @Test
    fun isSafeToMoveToFoundation_requiresOppositeColorProgressForHigherRanks() {
        val state = GameState(
            tableau = List(8) { emptyList() },
            freeCells = List(4) { null },
            foundations = mapOf(
                Suit.Clubs to listOf(Card(Suit.Clubs, 1)),
                Suit.Spades to listOf(Card(Suit.Spades, 1)),
                Suit.Diamonds to listOf(Card(Suit.Diamonds, 1)),
                Suit.Hearts to listOf(Card(Suit.Hearts, 1)),
            ),
        )

        // 3 of clubs is only safe when both red foundations reached at least 1 (>= 3-2)
        assertTrue(isSafeToMoveToFoundation(state, Card(Suit.Clubs, 3)))

        val blocked = state.copy(
            foundations = state.foundations + (Suit.Hearts to emptyList())
        )
        assertTrue(!isSafeToMoveToFoundation(blocked, Card(Suit.Clubs, 3)))
    }

    @Test
    fun analyze_recalculatesMultiCardMoveWhenCapacityChanges() {
        val stateBefore = GameState(
            tableau = listOf(
                listOf(
                    Card(Suit.Clubs, 7),
                    Card(Suit.Diamonds, 6),
                ), // fromCol (2-card valid run)
                listOf(Card(Suit.Hearts, 8)), // toCol (compatible with 7C)
                listOf(
                    Card(Suit.Spades, 13),
                    Card(Suit.Hearts, 12),
                ), // used to fill last freecell without creating an empty column
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
                null, // exactly one empty freecell -> max movable = 2
            ),
            foundations = Suit.entries.associateWith { emptyList<Card>() },
        )

        val analysisBefore = analyze(stateBefore)
        val startRef = CardRef(PileId.Tableau(0), 0)
        val toCol = PileId.Tableau(1)
        val beforeMove = analysisBefore.movesFrom[startRef]?.firstOrNull { it.to == toCol }
        assertNotNull(beforeMove, "expected a multi-card move to be available before capacity is reduced")

        val stateAfter = applyMove(stateBefore, Move(from = PileId.Tableau(2), fromIndex = 1, to = PileId.FreeCell(3), count = 1)).getOrNull()
        assertNotNull(stateAfter)

        val analysisAfter = analyze(stateAfter)
        val afterMove = analysisAfter.movesFrom[startRef]?.firstOrNull { it.to == toCol }
        assertNull(afterMove, "expected multi-card move to be unavailable after capacity is reduced")
    }

    @Test
    fun applyMove_rejectsMultiCardMoveWhenNoCapacity() {
        val state = GameState(
            tableau = listOf(
                listOf(
                    Card(Suit.Clubs, 7),
                    Card(Suit.Diamonds, 6),
                ),
                listOf(Card(Suit.Hearts, 8)),
                listOf(Card(Suit.Clubs, 9)),
                listOf(Card(Suit.Diamonds, 9)),
                listOf(Card(Suit.Spades, 9)),
                listOf(Card(Suit.Hearts, 9)),
                listOf(Card(Suit.Clubs, 10)),
                listOf(Card(Suit.Diamonds, 10)),
            ),
            freeCells = listOf(
                Card(Suit.Hearts, 2),
                Card(Suit.Spades, 3),
                Card(Suit.Diamonds, 4),
                Card(Suit.Clubs, 5),
            ),
            foundations = emptyFoundations(),
        )

        val r = applyMove(state, Move(from = PileId.Tableau(0), fromIndex = 0, to = PileId.Tableau(1), count = 2))
        val ex = r.exceptionOrNull()
        assertNotNull(ex)
        assertEquals(MoveError.MoveTooLargeForCapacity.name, ex.message)
    }

    @Test
    fun analyze_excludesDestinationEmptyColumnFromCapacity() {
        val state = GameState(
            tableau = listOf(
                listOf(
                    Card(Suit.Clubs, 7),
                    Card(Suit.Diamonds, 6),
                ),
                emptyList(), // destination is empty
                listOf(Card(Suit.Spades, 9)),
                listOf(Card(Suit.Hearts, 9)),
                listOf(Card(Suit.Clubs, 10)),
                listOf(Card(Suit.Diamonds, 10)),
                listOf(Card(Suit.Spades, 10)),
                listOf(Card(Suit.Hearts, 10)),
            ),
            freeCells = listOf(
                Card(Suit.Hearts, 2),
                Card(Suit.Spades, 3),
                Card(Suit.Diamonds, 4),
                Card(Suit.Clubs, 5),
            ),
            foundations = emptyFoundations(),
        )

        val a = analyze(state)
        val startRef = CardRef(PileId.Tableau(0), 0)
        val moves = a.movesFrom[startRef].orEmpty()

        // With no empty freecells, only the destination column is empty. Since destination emptiness
        // is excluded from capacity, moving 2 cards should not be offered.
        assertTrue(moves.none { it.to == PileId.Tableau(1) && it.count == 2 })
    }

    @Test
    fun analyze_allowsBiggerMovesWithMoreFreeCellsAndEmptyColumns() {
        val state = GameState(
            tableau = listOf(
                listOf(
                    Card(Suit.Clubs, 7),
                    Card(Suit.Diamonds, 6),
                    Card(Suit.Spades, 5),
                ),
                listOf(Card(Suit.Hearts, 8)),
                emptyList(),
                emptyList(),
                listOf(Card(Suit.Clubs, 9)),
                listOf(Card(Suit.Diamonds, 9)),
                listOf(Card(Suit.Spades, 9)),
                listOf(Card(Suit.Hearts, 9)),
            ),
            freeCells = listOf(
                null,
                null,
                null,
                null,
            ),
            foundations = emptyFoundations(),
        )

        // emptyFree=4 -> (4+1)=5
        // empty columns excluding destination (toCol=1 is non-empty): two empty columns -> 2^2 = 4
        // maxMovable = 5*4 = 20, so a 3-card move should be offered.
        val a = analyze(state)
        val startRef = CardRef(PileId.Tableau(0), 0)
        val move = a.movesFrom[startRef]?.firstOrNull { it.to == PileId.Tableau(1) }
        assertNotNull(move)
        assertEquals(3, move.count)
    }
}
