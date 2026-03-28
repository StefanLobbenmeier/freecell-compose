package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.Analysis
import de.dukat.freecell_compose.freecell.model.GameState
import de.dukat.freecell_compose.freecell.model.Move
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

class FreecellStore(initial: GameState = newModelGame()) {
    private data class HistoryEntry(
        val state: GameState,
        val move: Move,
        val movedCard: de.dukat.freecell_compose.freecell.model.Card,
    )

    private val history = ArrayDeque<HistoryEntry>()

    val uiState : StateFlow<UiState> field =  MutableStateFlow(
        UiState(
            state = initial,
            analysis = analyze(initial),
            message = null,
            canUndo = false,
        )
    )

    fun newGame(seed: Int? = null) {
        history.clear()
        val s = newModelGame(seed)
        uiState.value = UiState(state = s, analysis = analyze(s), message = null, canUndo = false)
    }

    fun undo() {
        val prev = history.removeLastOrNull() ?: return
        uiState.value = UiState(state = prev.state, analysis = analyze(prev.state), message = null, canUndo = history.isNotEmpty())
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
            uiState.value = UiState(state = next, analysis = analyze(next), message = null, canUndo = history.isNotEmpty())
        } else {
            uiState.value = uiState.value.copy(message = r.exceptionOrNull()?.message ?: "Illegal move")
        }
    }

    fun tryClickMove(start: de.dukat.freecell_compose.freecell.model.CardRef) {
        val cur = uiState.value.state
        val moves = uiState.value.analysis.movesFrom[start].orEmpty()
        if (moves.isEmpty()) return

        val movedCard = cardAt(cur, start) ?: return
        val prioritizedMoves = prioritizeClickMoves(cur, moves)
        val visitedPiles = recentVisitedPiles(movedCard, start.pile)
        val move = prioritizedMoves.firstOrNull { it.to !in visitedPiles } ?: prioritizedMoves.firstOrNull() ?: return
        tryMove(move)
    }

    fun tryAutoSolveStep(): Move? {
        val cur = uiState.value.state
        val a = uiState.value.analysis
        val move = a.safeFoundationMoves.firstOrNull() ?: return null
        val movedCard = movedCardFor(cur, move) ?: return null
        val next = applyMove(cur, move).getOrNull() ?: return null
        history.addLast(HistoryEntry(state = cur, move = move, movedCard = movedCard))
        uiState.value = UiState(state = next, analysis = analyze(next), message = null, canUndo = history.isNotEmpty())
        return move
    }

    private fun recentVisitedPiles(card: de.dukat.freecell_compose.freecell.model.Card, currentPile: de.dukat.freecell_compose.freecell.model.PileId): Set<de.dukat.freecell_compose.freecell.model.PileId> {
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
                to is de.dukat.freecell_compose.freecell.model.PileId.Tableau && state.tableau[to.index].isNotEmpty()
            }
            .sortedBy { (it.to as de.dukat.freecell_compose.freecell.model.PileId.Tableau).index }

        val foundations = moves
            .filter { it.to is de.dukat.freecell_compose.freecell.model.PileId.Foundation }
            .sortedBy { (it.to as de.dukat.freecell_compose.freecell.model.PileId.Foundation).suit.ordinal }

        val tableauToEmpty = moves
            .filter { move ->
                val to = move.to
                to is de.dukat.freecell_compose.freecell.model.PileId.Tableau && state.tableau[to.index].isEmpty()
            }
            .sortedBy { (it.to as de.dukat.freecell_compose.freecell.model.PileId.Tableau).index }

        val leftmostFreeCell = moves
            .filter { it.to is de.dukat.freecell_compose.freecell.model.PileId.FreeCell }
            .minByOrNull { (it.to as de.dukat.freecell_compose.freecell.model.PileId.FreeCell).index }

        return buildList {
            addAll(tableauToNonEmpty)
            addAll(foundations)
            addAll(tableauToEmpty)
            if (leftmostFreeCell != null) add(leftmostFreeCell)
        }
    }

    private fun movedCardFor(state: GameState, move: Move): de.dukat.freecell_compose.freecell.model.Card? {
        return when (val from = move.from) {
            is de.dukat.freecell_compose.freecell.model.PileId.Tableau -> state.tableau[from.index].getOrNull(move.fromIndex)
            is de.dukat.freecell_compose.freecell.model.PileId.FreeCell -> state.freeCells[from.index]
            is de.dukat.freecell_compose.freecell.model.PileId.Foundation -> state.foundations.getValue(from.suit).lastOrNull()
        }
    }

    private fun cardAt(state: GameState, start: de.dukat.freecell_compose.freecell.model.CardRef): de.dukat.freecell_compose.freecell.model.Card? {
        return when (val pile = start.pile) {
            is de.dukat.freecell_compose.freecell.model.PileId.Tableau -> state.tableau[pile.index].getOrNull(start.index)
            is de.dukat.freecell_compose.freecell.model.PileId.FreeCell -> state.freeCells[pile.index]
            is de.dukat.freecell_compose.freecell.model.PileId.Foundation -> state.foundations.getValue(pile.suit).lastOrNull()
        }
    }
}
