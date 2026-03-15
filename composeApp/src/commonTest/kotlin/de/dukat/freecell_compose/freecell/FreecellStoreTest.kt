package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.Card
import de.dukat.freecell_compose.freecell.model.CardRef
import de.dukat.freecell_compose.freecell.model.GameState
import de.dukat.freecell_compose.freecell.model.Move
import de.dukat.freecell_compose.freecell.model.PileId
import de.dukat.freecell_compose.freecell.model.Suit
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class FreecellStoreTest {
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

        val store = FreecellStore(stateBefore)

        val startRef = CardRef(PileId.Tableau(0), 0)
        val toCol = PileId.Tableau(1)
        assertNotNull(store.uiState.value.analysis.movesFrom[startRef]?.firstOrNull { it.to == toCol })

        // Fill the last freecell to reduce capacity; this should make the 2-card move unavailable.
        store.tryMove(Move(from = PileId.Tableau(2), fromIndex = 1, to = PileId.FreeCell(3), count = 1))

        assertNull(store.uiState.value.analysis.movesFrom[startRef]?.firstOrNull { it.to == toCol })
    }
}
