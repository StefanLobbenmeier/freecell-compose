package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.Card
import de.dukat.freecell_compose.freecell.model.GameState
import de.dukat.freecell_compose.freecell.model.Suit

private const val VERSION = "v1"
private const val CARD_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

internal fun encodeGameState(state: GameState): String = "$VERSION-${encodeGameStateBody(state)}"

private fun encodeGameStateBody(state: GameState): String {
    val tableau = state.tableau.joinToString(".") { column -> column.joinToString("", transform = ::encodeCard) }
    val freeCells = state.freeCells.joinToString("") { card -> card?.let(::encodeCard) ?: "_" }
    val foundations = Suit.entries.joinToString(".") { suit ->
        state.foundations.getValue(suit).joinToString("", transform = ::encodeCard)
    }
    return listOf(tableau, freeCells, foundations).joinToString("-")
}

internal fun decodeGameState(serialized: String): GameState? {
    val prefix = "$VERSION-"
    if (!serialized.startsWith(prefix)) return null
    return decodeGameStateBody(serialized.removePrefix(prefix))
}

private fun decodeGameStateBody(serialized: String): GameState? {
    val parts = serialized.split('-')
    if (parts.size != 3) return null

    val tableauParts = parts[0].split('.')
    val freeCellParts = parts[1]
    val foundationParts = parts[2].split('.')

    if (tableauParts.size != 8 || freeCellParts.length != 4 || foundationParts.size != Suit.entries.size) return null

    val tableau = tableauParts.map(::decodeCardList)
    if (tableau.any { it == null }) return null
    val freeCells = buildList {
        for (token in freeCellParts) {
            if (token == '_') {
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

private fun encodeCard(card: Card): String =
    CARD_ALPHABET[card.suit.ordinal * 13 + card.rank - 1].toString()

private fun decodeCardList(serialized: String): List<Card>? {
    return serialized.map(::decodeCard).takeIf { it.all { card -> card != null } }?.map { it!! }
}

private fun decodeCard(encoded: Char): Card? {
    val index = CARD_ALPHABET.indexOf(encoded)
    if (index < 0) return null
    return Card(Suit.entries[index / 13], index % 13 + 1)
}

/** Versioned, URL-safe payload. Both positions are explicit, independent of shuffle algorithms. */
data class SharedGame(val startingPosition: GameState, val currentState: GameState)

fun encodeGame(game: SharedGame): String =
    "$VERSION~${encodeGameStateBody(game.startingPosition)}~${encodeGameStateBody(game.currentState)}"

fun decodeGame(encoded: String): SharedGame? = runCatching {
    if (encoded.length > 8192) return null
    val parts = encoded.split('~')
    if (parts.size != 3 || parts[0] != VERSION) return null
    val start = decodeGameStateBody(parts[1]) ?: return null
    val current = decodeGameStateBody(parts[2]) ?: return null
    if (!isCompleteDeck(start) || !isCompleteDeck(current)) return null
    SharedGame(start, current)
}.getOrNull()

private fun isCompleteDeck(state: GameState): Boolean {
    val cards = state.tableau.flatten() + state.freeCells.filterNotNull() + state.foundations.values.flatten()
    return cards.size == 52 && cards.toSet().size == 52 && Suit.entries.all { suit ->
        state.foundations.getValue(suit).map { it.rank } == (1..state.foundations.getValue(suit).size).toList() &&
            state.foundations.getValue(suit).all { it.suit == suit }
    }
}

fun gameShareLink(baseUrl: String, game: SharedGame): String =
    "${baseUrl.substringBefore('#')}#game=${encodeGame(game)}"

fun decodeGameLink(link: String): SharedGame? = decodeGame(link.trim().substringAfter("#game=", link.trim()))
