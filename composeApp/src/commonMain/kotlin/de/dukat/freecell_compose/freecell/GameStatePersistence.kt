package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.Card
import de.dukat.freecell_compose.freecell.model.GameState
import de.dukat.freecell_compose.freecell.model.Suit

interface GameStatePersistence {
    fun load(): GameState?

    fun save(state: GameState)
}

object NoOpGameStatePersistence : GameStatePersistence {
    override fun load(): GameState? = null

    override fun save(state: GameState) = Unit
}

expect object PlatformGameStatePersistence : GameStatePersistence

internal const val GAME_STATE_STORAGE_KEY = "freecell-compose.game-state"

internal fun encodeGameState(state: GameState): String {
    val tableau = state.tableau.joinToString(";") { column -> column.joinToString(",", transform = ::encodeCard) }
    val freeCells = state.freeCells.joinToString(",") { card -> card?.let(::encodeCard) ?: "_" }
    val foundations = Suit.entries.joinToString(";") { suit ->
        state.foundations.getValue(suit).joinToString(",", transform = ::encodeCard)
    }
    return listOf("v1", tableau, freeCells, foundations).joinToString("|")
}

internal fun decodeGameState(serialized: String): GameState? {
    val parts = serialized.split("|")
    if (parts.size != 4 || parts[0] != "v1") return null

    val tableauParts = parts[1].split(";")
    val freeCellParts = parts[2].split(",")
    val foundationParts = parts[3].split(";")

    if (tableauParts.size != 8 || freeCellParts.size != 4 || foundationParts.size != Suit.entries.size) return null

    val tableau = tableauParts.map(::decodeCardList)
    if (tableau.any { it == null }) return null
    val freeCells = buildList {
        for (token in freeCellParts) {
            if (token == "_") {
                add(null)
            } else {
                add(decodeCard(token) ?: return null)
            }
        }
    }

    val foundations = Suit.entries.mapIndexed { index, suit ->
        val cards = decodeCardList(foundationParts[index]) ?: return null
        suit to cards
    }.toMap()

    return GameState(
        tableau = tableau.map { it!! },
        freeCells = freeCells,
        foundations = foundations,
    )
}

private fun encodeCard(card: Card): String = "${card.suit.name.first()}${card.rank}"

private fun decodeCardList(serialized: String): List<Card>? {
    if (serialized.isEmpty()) return emptyList()
    return serialized.split(",").map(::decodeCard).takeIf { it.all { card -> card != null } }?.map { it!! }
}

private fun decodeCard(serialized: String): Card? {
    if (serialized.length < 2) return null
    val suit = when (serialized.first()) {
        'C' -> Suit.Clubs
        'D' -> Suit.Diamonds
        'H' -> Suit.Hearts
        'S' -> Suit.Spades
        else -> return null
    }
    val rank = serialized.drop(1).toIntOrNull() ?: return null
    return runCatching { Card(suit, rank) }.getOrNull()
}
