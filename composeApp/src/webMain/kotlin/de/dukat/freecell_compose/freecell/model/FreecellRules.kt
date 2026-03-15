package de.dukat.freecell_compose.freecell.model

import kotlin.math.max
import kotlin.random.Random

enum class MoveError {
    InvalidSource,
    InvalidDestination,
    NothingToMove,
    InvalidCount,
    NotTopCard,
    RunNotValid,
    DestinationNotCompatible,
    FreeCellNotEmpty,
    FoundationNotCompatible,
    MoveTooLargeForCapacity,
}

data class Analysis(
    val legalMoves: List<Move>,
    val movableStarts: Set<CardRef>,
    val movesFrom: Map<CardRef, List<Move>>,
)

fun newGame(seed: Int? = null): GameState {
    val deck = buildDeck()
    val shuffled = shuffle(deck, seed)

    val cols = List(8) { mutableListOf<Card>() }
    for (i in shuffled.indices) {
        cols[i % 8].add(shuffled[i])
    }

    return GameState(
        tableau = cols.map { it.toList() },
        freeCells = List(4) { null },
        foundations = Suit.entries.associateWith { emptyList() },
    )
}

fun analyze(state: GameState): Analysis {
    val moves = mutableListOf<Move>()
    val movesFrom = linkedMapOf<CardRef, MutableList<Move>>()

    fun addMove(start: CardRef, move: Move) {
        moves.add(move)
        movesFrom.getOrPut(start) { mutableListOf() }.add(move)
    }

    // Tableau sources (allow run starts anywhere that form a valid alternating descending run).
    for (fromCol in 0 until 8) {
        val col = state.tableau[fromCol]
        for (startIndex in col.indices) {
            val segment = col.subList(startIndex, col.size)
            if (!isValidTableauRun(segment)) continue

            val startRef = CardRef(PileId.Tableau(fromCol), startIndex)
            val count = segment.size
            val bottom = segment.first()

            // To tableau
            for (toCol in 0 until 8) {
                if (toCol == fromCol) continue
                val dest = state.tableau[toCol]
                if (!canPlaceOnTableau(bottom, dest.lastOrNull())) continue
                if (count > 1 && !capacityAllows(state, fromCol, startIndex, toCol, count)) continue
                addMove(
                    startRef,
                    Move(
                        from = PileId.Tableau(fromCol),
                        fromIndex = startIndex,
                        to = PileId.Tableau(toCol),
                        count = count,
                    )
                )
            }

            // Only single top card can go to freecell/foundation.
            if (count == 1 && startIndex == col.lastIndex) {
                // To freecell
                for (slot in 0 until 4) {
                    if (state.freeCells[slot] != null) continue
                    addMove(startRef, Move(from = PileId.Tableau(fromCol), fromIndex = startIndex, to = PileId.FreeCell(slot), count = 1))
                }
                // To foundation
                val suit = bottom.suit
                if (canPlaceOnFoundation(bottom, state.foundations.getValue(suit).lastOrNull())) {
                    addMove(startRef, Move(from = PileId.Tableau(fromCol), fromIndex = startIndex, to = PileId.Foundation(suit), count = 1))
                }
            }
        }
    }

    // Freecell sources
    for (slot in 0 until 4) {
        val card = state.freeCells[slot] ?: continue
        val startRef = CardRef(PileId.FreeCell(slot), 0)

        // To tableau
        for (toCol in 0 until 8) {
            val dest = state.tableau[toCol]
            if (!canPlaceOnTableau(card, dest.lastOrNull())) continue
            addMove(startRef, Move(from = PileId.FreeCell(slot), to = PileId.Tableau(toCol), count = 1))
        }

        // To foundation
        if (canPlaceOnFoundation(card, state.foundations.getValue(card.suit).lastOrNull())) {
            addMove(startRef, Move(from = PileId.FreeCell(slot), to = PileId.Foundation(card.suit), count = 1))
        }
    }

    // Foundation sources (allow moving top card back out)
    for (suit in Suit.entries) {
        val pile = state.foundations.getValue(suit)
        val card = pile.lastOrNull() ?: continue
        val startRef = CardRef(PileId.Foundation(suit), 0)

        // To tableau
        for (toCol in 0 until 8) {
            val dest = state.tableau[toCol]
            if (!canPlaceOnTableau(card, dest.lastOrNull())) continue
            addMove(startRef, Move(from = PileId.Foundation(suit), to = PileId.Tableau(toCol), count = 1))
        }
        // To freecell
        for (slot in 0 until 4) {
            if (state.freeCells[slot] != null) continue
            addMove(startRef, Move(from = PileId.Foundation(suit), to = PileId.FreeCell(slot), count = 1))
        }
    }

    val movableStarts = movesFrom.keys.toSet()
    return Analysis(
        legalMoves = moves,
        movableStarts = movableStarts,
        movesFrom = movesFrom.mapValues { it.value.toList() },
    )
}

fun applyMove(state: GameState, move: Move): Result<GameState> {
    if (move.count <= 0) return Result.failure(IllegalArgumentException(MoveError.InvalidCount.name))
    val extracted = extractFrom(state, move.from, move.fromIndex, move.count)
        ?: return Result.failure(IllegalArgumentException(MoveError.InvalidSource.name))
    val moving = extracted.moving
    val afterRemove = extracted.afterRemove
    if (moving.isEmpty()) return Result.failure(IllegalArgumentException(MoveError.NothingToMove.name))

    if (moving.size > 1 && !isValidTableauRun(moving)) {
        return Result.failure(IllegalArgumentException(MoveError.RunNotValid.name))
    }

    // Validate destination compatibility and capacity
    val destOk = when (val to = move.to) {
        is PileId.Tableau -> {
            val dest = afterRemove.tableau[to.index]
            val bottom = moving.first()
            if (!canPlaceOnTableau(bottom, dest.lastOrNull())) return Result.failure(IllegalArgumentException(MoveError.DestinationNotCompatible.name))
            if (moving.size > 1) {
                val fromCol = (move.from as? PileId.Tableau)?.index
                    ?: return Result.failure(IllegalArgumentException(MoveError.InvalidSource.name))
                if (!capacityAllows(state, fromCol, move.fromIndex, to.index, moving.size)) {
                    return Result.failure(IllegalArgumentException(MoveError.MoveTooLargeForCapacity.name))
                }
            }
            true
        }

        is PileId.FreeCell -> {
            if (moving.size != 1) return Result.failure(IllegalArgumentException(MoveError.InvalidCount.name))
            if (afterRemove.freeCells[to.index] != null) return Result.failure(IllegalArgumentException(MoveError.FreeCellNotEmpty.name))
            true
        }

        is PileId.Foundation -> {
            if (moving.size != 1) return Result.failure(IllegalArgumentException(MoveError.InvalidCount.name))
            val card = moving.single()
            if (card.suit != to.suit) return Result.failure(IllegalArgumentException(MoveError.FoundationNotCompatible.name))
            val top = afterRemove.foundations.getValue(to.suit).lastOrNull()
            if (!canPlaceOnFoundation(card, top)) return Result.failure(IllegalArgumentException(MoveError.FoundationNotCompatible.name))
            true
        }
    }
    if (!destOk) return Result.failure(IllegalArgumentException(MoveError.InvalidDestination.name))

    val placed = placeTo(afterRemove, move.to, moving)
        ?: return Result.failure(IllegalArgumentException(MoveError.InvalidDestination.name))
    return Result.success(placed)
}

private data class ExtractResult(
    val moving: List<Card>,
    val afterRemove: GameState,
)

private fun extractFrom(state: GameState, from: PileId, fromIndex: Int, count: Int): ExtractResult? {
    return when (from) {
        is PileId.Tableau -> {
            val col = state.tableau[from.index]
            if (col.isEmpty()) return null
            if (count <= 0) return null
            if (fromIndex !in col.indices) return null
            if (fromIndex + count != col.size) return null // must take a suffix (top run)
            val moving = col.subList(fromIndex, col.size)
            if (moving.size > 1 && !isValidTableauRun(moving)) return null

            val newTableau = state.tableau.toMutableList()
            newTableau[from.index] = col.subList(0, fromIndex).toList()
            ExtractResult(moving.toList(), state.copy(tableau = newTableau.toList()))
        }

        is PileId.FreeCell -> {
            if (count != 1) return null
            val card = state.freeCells[from.index] ?: return null
            val newFree = state.freeCells.toMutableList()
            newFree[from.index] = null
            ExtractResult(listOf(card), state.copy(freeCells = newFree.toList()))
        }

        is PileId.Foundation -> {
            if (count != 1) return null
            val pile = state.foundations.getValue(from.suit)
            val card = pile.lastOrNull() ?: return null
            val newFound = state.foundations.toMutableMap()
            newFound[from.suit] = pile.dropLast(1)
            ExtractResult(listOf(card), state.copy(foundations = newFound.toMap()))
        }
    }
}

private fun placeTo(state: GameState, to: PileId, moving: List<Card>): GameState? {
    return when (to) {
        is PileId.Tableau -> {
            val dest = state.tableau[to.index]
            val newTableau = state.tableau.toMutableList()
            newTableau[to.index] = (dest + moving).toList()
            state.copy(tableau = newTableau.toList())
        }

        is PileId.FreeCell -> {
            if (moving.size != 1) return null
            val newFree = state.freeCells.toMutableList()
            if (newFree[to.index] != null) return null
            newFree[to.index] = moving.single()
            state.copy(freeCells = newFree.toList())
        }

        is PileId.Foundation -> {
            if (moving.size != 1) return null
            val card = moving.single()
            val pile = state.foundations.getValue(to.suit)
            val newFound = state.foundations.toMutableMap()
            newFound[to.suit] = (pile + card).toList()
            state.copy(foundations = newFound.toMap())
        }
    }
}

private fun canPlaceOnTableau(card: Card, destTop: Card?): Boolean {
    if (destTop == null) return true
    return destTop.rank == card.rank + 1 && destTop.isRed != card.isRed
}

private fun canPlaceOnFoundation(card: Card, destTop: Card?): Boolean {
    return if (destTop == null) {
        card.rank == 1
    } else {
        destTop.suit == card.suit && card.rank == destTop.rank + 1
    }
}

private fun isValidTableauRun(cards: List<Card>): Boolean {
    if (cards.size <= 1) return true
    for (i in 0 until cards.size - 1) {
        val a = cards[i]
        val b = cards[i + 1]
        if (a.rank != b.rank + 1) return false
        if (a.isRed == b.isRed) return false
    }
    return true
}

private fun capacityAllows(
    state: GameState,
    fromCol: Int,
    fromIndex: Int,
    toCol: Int,
    movingCount: Int,
): Boolean {
    val emptyFree = state.freeCells.count { it == null }
    val emptyTableauNow = state.tableau.count { it.isEmpty() }

    val destIsEmptyNow = state.tableau[toCol].isEmpty()
    var emptyColumnsExcludingDest = emptyTableauNow - (if (destIsEmptyNow) 1 else 0)

    // If the source becomes empty after lifting, you can use it as an extra empty column.
    val sourceBecomesEmpty = run {
        val col = state.tableau[fromCol]
        if (col.isEmpty()) false
        else {
            fromIndex == 0 && movingCount == col.size
        }
    }
    if (sourceBecomesEmpty && fromCol != toCol) {
        // If source was non-empty, it wasn't counted as empty yet.
        emptyColumnsExcludingDest += 1
    }

    emptyColumnsExcludingDest = max(0, emptyColumnsExcludingDest)
    val maxMovable = (emptyFree + 1) * (1 shl emptyColumnsExcludingDest)
    return movingCount <= maxMovable
}

private fun buildDeck(): List<Card> {
    val cards = ArrayList<Card>(52)
    for (suit in Suit.entries) {
        for (rank in 1..13) {
            cards.add(Card(suit, rank))
        }
    }
    return cards
}

private fun shuffle(deck: List<Card>, seed: Int?): List<Card> {
    val rng = if (seed == null) Random.Default else Random(seed)
    val a = deck.toMutableList()
    for (i in a.lastIndex downTo 1) {
        val j = rng.nextInt(i + 1)
        val tmp = a[i]
        a[i] = a[j]
        a[j] = tmp
    }
    return a.toList()
}
