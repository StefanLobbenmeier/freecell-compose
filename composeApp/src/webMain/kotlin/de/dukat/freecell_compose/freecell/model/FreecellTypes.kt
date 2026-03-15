package de.dukat.freecell_compose.freecell.model

enum class Suit {
    Clubs,
    Diamonds,
    Hearts,
    Spades,
    ;

    val isRed: Boolean
        get() = this == Diamonds || this == Hearts
}

data class Card(
    val suit: Suit,
    val rank: Int,
) {
    init {
        require(rank in 1..13) { "rank must be 1..13" }
    }

    val isRed: Boolean
        get() = suit.isRed
}

sealed interface PileId {
    data class Tableau(val index: Int) : PileId {
        init {
            require(index in 0..7) { "tableau index must be 0..7" }
        }
    }

    data class FreeCell(val index: Int) : PileId {
        init {
            require(index in 0..3) { "freecell index must be 0..3" }
        }
    }

    data class Foundation(val suit: Suit) : PileId
}

data class CardRef(
    val pile: PileId,
    val index: Int,
)

data class Move(
    val from: PileId,
    val fromIndex: Int = 0,
    val to: PileId,
    val count: Int = 1,
)

data class GameState(
    val tableau: List<List<Card>>,
    val freeCells: List<Card?>,
    val foundations: Map<Suit, List<Card>>,
) {
    init {
        require(tableau.size == 8) { "tableau must have 8 columns" }
        require(freeCells.size == 4) { "freeCells must have 4 slots" }
        require(foundations.keys.containsAll(Suit.entries)) { "foundations must contain all suits" }
    }

    val isWon: Boolean
        get() = foundations.values.sumOf { it.size } == 52
}
