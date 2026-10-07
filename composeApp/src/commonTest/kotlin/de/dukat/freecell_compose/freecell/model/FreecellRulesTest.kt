package de.dukat.freecell_compose.freecell.model

import de.dukat.freecell_compose.freecell.decodeGameLink
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class FreecellRulesTest {
    private fun emptyFoundations(): Map<Suit, List<Card>> = Suit.entries.associateWith { emptyList() }
    private fun foundation(suit: Suit, throughRank: Int): List<Card> =
        (1..throughRank).map { rank -> Card(suit, rank) }

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
    fun isSafeToMoveToFoundation_requiresSameColorProgressForHigherRanks() {
        val state = GameState(
            tableau = List(8) { emptyList() },
            freeCells = List(4) { null },
            foundations = mapOf(
                Suit.Clubs to foundation(Suit.Clubs, 5),
                Suit.Spades to foundation(Suit.Spades, 2),
                Suit.Diamonds to foundation(Suit.Diamonds, 4),
                Suit.Hearts to foundation(Suit.Hearts, 4),
            ),
        )

        assertTrue(!isSafeToMoveToFoundation(state, Card(Suit.Clubs, 6)))
        assertTrue(
            isSafeToMoveToFoundation(
                state.copy(foundations = state.foundations + (Suit.Spades to foundation(Suit.Spades, 3))),
                Card(Suit.Clubs, 6),
            )
        )
    }

    @Test
    fun analyze_allowsUnsafeCardThatDirectlyBlocksItsRestrainingCard() {
        val state = GameState(
            tableau = listOf(
                listOf(Card(Suit.Spades, 4), Card(Suit.Clubs, 7)),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
            ),
            freeCells = List(4) { null },
            foundations = mapOf(
                Suit.Clubs to foundation(Suit.Clubs, 6),
                Suit.Spades to foundation(Suit.Spades, 3),
                Suit.Diamonds to foundation(Suit.Diamonds, 5),
                Suit.Hearts to foundation(Suit.Hearts, 5),
            ),
        )

        val move = Move(
            from = PileId.Tableau(0),
            fromIndex = 1,
            to = PileId.Foundation(Suit.Clubs),
        )
        assertTrue(!isSafeToMoveToFoundation(state, Card(Suit.Clubs, 7)))
        assertTrue(move in analyze(state).safeFoundationMoves)
    }

    @Test
    fun analyze_allowsUnsafeCardWithSafeAutoMovesBeforeRestrainingCards() {
        val state = GameState(
            tableau = listOf(
                listOf(Card(Suit.Spades, 4), Card(Suit.Hearts, 5), Card(Suit.Clubs, 7)),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
            ),
            freeCells = List(4) { null },
            foundations = mapOf(
                Suit.Clubs to foundation(Suit.Clubs, 6),
                Suit.Spades to foundation(Suit.Spades, 3),
                Suit.Diamonds to foundation(Suit.Diamonds, 5),
                Suit.Hearts to foundation(Suit.Hearts, 4),
            ),
        )

        val move = Move(
            from = PileId.Tableau(0),
            fromIndex = 2,
            to = PileId.Foundation(Suit.Clubs),
        )
        assertTrue(move in analyze(state).safeFoundationMoves)
    }

    @Test
    fun analyze_autoMovesBothBlackThreesInSharedGame() {
        val game = assertNotNull(decodeGameLink(
            "https://stefanlobbenmeier.github.io/freecell-compose/#game=" +
                "v1~QFwoLkr.qvfbTIj.ZyCmxWH.agOSsih.XUBKzJ.udMVDl.YeGNpA.RncPtE-____-...~" +
                "QFwoLkJi..ZyCmxWHgseq.zYKjIhGSr..udMVDl.vUtfE.RncP-p_XT-ab..AB.NO",
        ))
        var state = game.currentState
        for (move in listOf(
            Move(PileId.Tableau(7), 3, PileId.Foundation(Suit.Spades)),
            Move(PileId.Tableau(7), 2, PileId.Foundation(Suit.Clubs)),
        )) {
            assertTrue(move in analyze(state).safeFoundationMoves)
            state = applyMove(state, move).getOrThrow()
        }

        assertEquals(Card(Suit.Diamonds, 1), state.tableau[7].last())
        val aceMove = Move(PileId.Tableau(7), 1, PileId.Foundation(Suit.Diamonds))
        assertTrue(aceMove in analyze(state).safeFoundationMoves)
        state = applyMove(state, aceMove).getOrThrow()
        assertTrue(isSafeToMoveToFoundation(state, Card(Suit.Spades, 3)))
        assertTrue(isSafeToMoveToFoundation(state, Card(Suit.Clubs, 3)))
    }

    @Test
    fun analyze_allowsMultipleUnsafeCardsWhenFoundationProgressMakesThemAllSafe() {
        var state = stackedUnsafeThrees()
        val clubsMove = Move(PileId.Tableau(0), 2, PileId.Foundation(Suit.Clubs))
        val spadesMove = Move(PileId.Tableau(0), 1, PileId.Foundation(Suit.Spades))
        val aceMove = Move(PileId.Tableau(0), 0, PileId.Foundation(Suit.Hearts))

        assertTrue(!isSafeToMoveToFoundation(state, Card(Suit.Clubs, 3)))
        assertTrue(!isSafeToMoveToFoundation(state, Card(Suit.Spades, 3)))
        for (move in listOf(clubsMove, spadesMove, aceMove)) {
            assertTrue(move in analyze(state).safeFoundationMoves)
            state = applyMove(state, move).getOrThrow()
        }

        assertTrue(state.tableau[0].isEmpty())
        assertEquals(foundation(Suit.Clubs, 3), state.foundations.getValue(Suit.Clubs))
        assertEquals(foundation(Suit.Spades, 3), state.foundations.getValue(Suit.Spades))
        assertEquals(foundation(Suit.Hearts, 1), state.foundations.getValue(Suit.Hearts))
    }

    @Test
    fun analyze_rejectsMultipleUnsafeCardsWhenRestrainingCardCannotMoveToFoundation() {
        val state = stackedUnsafeThrees().copy(
            tableau = listOf(listOf(Card(Suit.Hearts, 2), Card(Suit.Spades, 3), Card(Suit.Clubs, 3))) +
                List(7) { emptyList() },
        )
        val move = Move(PileId.Tableau(0), 2, PileId.Foundation(Suit.Clubs))

        assertTrue(move in analyze(state).legalMoves)
        assertTrue(move !in analyze(state).safeFoundationMoves)
    }

    @Test
    fun analyze_requiresAllSimulatedCardsToBecomeSafe() {
        val state = stackedUnsafeThrees().copy(
            tableau = listOf(listOf(Card(Suit.Hearts, 1), Card(Suit.Spades, 4), Card(Suit.Clubs, 3))) +
                List(7) { emptyList() },
            foundations = stackedUnsafeThrees().foundations + (Suit.Spades to foundation(Suit.Spades, 3)),
        )
        val move = Move(PileId.Tableau(0), 2, PileId.Foundation(Suit.Clubs))

        // The ace makes the clubs three safe, but the spades four still needs both red twos.
        assertTrue(move in analyze(state).legalMoves)
        assertTrue(move !in analyze(state).safeFoundationMoves)
    }

    private fun stackedUnsafeThrees(): GameState = GameState(
        tableau = listOf(listOf(Card(Suit.Hearts, 1), Card(Suit.Spades, 3), Card(Suit.Clubs, 3))) +
            List(7) { emptyList() },
        freeCells = List(4) { null },
        foundations = mapOf(
            Suit.Clubs to foundation(Suit.Clubs, 2),
            Suit.Spades to foundation(Suit.Spades, 2),
            Suit.Diamonds to foundation(Suit.Diamonds, 1),
            Suit.Hearts to emptyList(),
        ),
    )

    @Test
    fun analyze_doesNotIgnoreSafetyWhenRestrainingCardIsElsewhere() {
        val state = GameState(
            tableau = listOf(
                listOf(Card(Suit.Clubs, 7)),
                listOf(Card(Suit.Spades, 4)),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
            ),
            freeCells = List(4) { null },
            foundations = mapOf(
                Suit.Clubs to foundation(Suit.Clubs, 6),
                Suit.Spades to foundation(Suit.Spades, 3),
                Suit.Diamonds to foundation(Suit.Diamonds, 5),
                Suit.Hearts to foundation(Suit.Hearts, 5),
            ),
        )

        val move = Move(
            from = PileId.Tableau(0),
            fromIndex = 0,
            to = PileId.Foundation(Suit.Clubs),
        )
        assertTrue(move !in analyze(state).safeFoundationMoves)
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
