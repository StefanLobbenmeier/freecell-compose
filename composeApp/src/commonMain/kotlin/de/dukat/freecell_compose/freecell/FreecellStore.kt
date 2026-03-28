package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.Analysis
import de.dukat.freecell_compose.freecell.model.Card
import de.dukat.freecell_compose.freecell.model.CardRef
import de.dukat.freecell_compose.freecell.model.GameState
import de.dukat.freecell_compose.freecell.model.Move
import de.dukat.freecell_compose.freecell.model.PileId
import de.dukat.freecell_compose.freecell.model.analyze
import de.dukat.freecell_compose.freecell.model.applyMove
import de.dukat.freecell_compose.freecell.model.newGame as newModelGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class UiState(
    val state: GameState,
    val analysis: Analysis,
    val message: String? = null,
    val canUndo: Boolean = false,
)

class FreecellStore(
    initial: GameState? = null,
    private val persistence: GameStatePersistence = createPlatformGameStatePersistence(),
) {
    private data class HistoryEntry(
        val state: GameState,
        val move: Move,
        val movedCard: Card,
    )

    private val history = ArrayDeque<HistoryEntry>()
    private val initialState = initial ?: persistence.load() ?: newModelGame()

    val uiState : StateFlow<UiState> field =  MutableStateFlow(
        UiState(
            state = initialState,
            analysis = analyze(initialState),
            message = null,
            canUndo = false,
        )
    )

    init {
        persistence.save(initialState)
    }

    fun newGame(seed: Int? = null) {
        history.clear()
        val s = newModelGame(seed)
        publish(s)
    }

    fun undo() {
        val prev = history.removeLastOrNull() ?: return
        publish(prev.state)
    }

    fun tryMove(move: Move) {
        val cur = uiState.value.state
        val movedCard = movedCardFor(cur, move)
        val r = applyMove(cur, move)
        val next = r.getOrNull()
        if (next != null) {
            if (movedCard != null) {
                history.addLast(HistoryEntry(state = cur, move = move, movedCard = movedCard))
            }
            publish(next)
        } else {
            uiState.value = uiState.value.copy(message = r.exceptionOrNull()?.message ?: "Illegal move")
        }
    }

    fun pickClickMove(start: CardRef): Move? {
        val cur = uiState.value.state
        val moves = uiState.value.analysis.movesFrom[start].orEmpty()
        if (moves.isEmpty()) return null

        val movedCard = cardAt(cur, start) ?: return null
        val prioritizedMoves = prioritizeClickMoves(cur, moves)
        val visitedPiles = recentVisitedPiles(movedCard, start.pile)
        return prioritizedMoves.firstOrNull { it.to !in visitedPiles } ?: prioritizedMoves.firstOrNull()
    }

    fun tryClickMove(start: CardRef) {
        val move = pickClickMove(start) ?: return
        tryMove(move)
    }

    fun tryAutoSolveStep(): Move? {
        val cur = uiState.value.state
        val a = uiState.value.analysis
        val move = a.safeFoundationMoves.firstOrNull() ?: return null
        val movedCard = movedCardFor(cur, move) ?: return null
        val next = applyMove(cur, move).getOrNull() ?: return null
        history.addLast(HistoryEntry(state = cur, move = move, movedCard = movedCard))
        publish(next)
        return move
    }

    private fun publish(state: GameState) {
        persistence.save(state)
        uiState.value = UiState(state = state, analysis = analyze(state), message = null, canUndo = history.isNotEmpty())
    }

    private fun recentVisitedPiles(card: Card, currentPile: PileId): Set<PileId> {
        val visited = linkedSetOf(currentPile)
        for (entry in history.asReversed()) {
            if (entry.movedCard != card) break
            visited += entry.move.from
            visited += entry.move.to
        }
        return visited
    }

    private fun prioritizeClickMoves(state: GameState, moves: List<Move>): List<Move> {
        val tableauToNonEmpty = moves
            .filter { move ->
                val to = move.to
                to is PileId.Tableau && state.tableau[to.index].isNotEmpty()
            }
            .sortedBy { (it.to as PileId.Tableau).index }

        val foundations = moves
            .filter { it.to is PileId.Foundation }
            .sortedBy { (it.to as PileId.Foundation).suit.ordinal }

        val tableauToEmpty = moves
            .filter { move ->
                val to = move.to
                to is PileId.Tableau && state.tableau[to.index].isEmpty()
            }
            .sortedBy { (it.to as PileId.Tableau).index }

        val leftmostFreeCell = moves
            .filter { it.to is PileId.FreeCell }
            .minByOrNull { (it.to as PileId.FreeCell).index }

        return buildList {
            addAll(tableauToNonEmpty)
            addAll(foundations)
            addAll(tableauToEmpty)
            if (leftmostFreeCell != null) add(leftmostFreeCell)
        }
    }

    private fun movedCardFor(state: GameState, move: Move): Card? {
        return when (val from = move.from) {
            is PileId.Tableau -> state.tableau[from.index].getOrNull(move.fromIndex)
            is PileId.FreeCell -> state.freeCells[from.index]
            is PileId.Foundation -> state.foundations.getValue(from.suit).lastOrNull()
        }
    }

    private fun cardAt(state: GameState, start: CardRef): Card? {
        return when (val pile = start.pile) {
            is PileId.Tableau -> state.tableau[pile.index].getOrNull(start.index)
            is PileId.FreeCell -> state.freeCells[pile.index]
            is PileId.Foundation -> state.foundations.getValue(pile.suit).lastOrNull()
        }
    }
}
