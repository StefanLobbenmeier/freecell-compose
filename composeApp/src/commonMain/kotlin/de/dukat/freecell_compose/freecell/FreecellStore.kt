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
    private val history = ArrayDeque<GameState>()

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
        uiState.value = UiState(state = prev, analysis = analyze(prev), message = null, canUndo = history.isNotEmpty())
    }

    fun tryMove(move: Move) {
        val cur = uiState.value.state
        val r = applyMove(cur, move)
        val next = r.getOrNull()
        if (next != null) {
            history.addLast(cur)
            uiState.value = UiState(state = next, analysis = analyze(next), message = null, canUndo = true)
        } else {
            uiState.value = uiState.value.copy(message = r.exceptionOrNull()?.message ?: "Illegal move")
        }
    }

    fun tryAutoSolveStep(): Move? {
        val cur = uiState.value.state
        val a = uiState.value.analysis
        val move = a.safeFoundationMoves.firstOrNull() ?: return null
        val next = applyMove(cur, move).getOrNull() ?: return null
        history.addLast(cur)
        uiState.value = UiState(state = next, analysis = analyze(next), message = null, canUndo = true)
        return move
    }
}
