package de.dukat.freecell_compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.dukat.freecell_compose.freecell.model.Card
import de.dukat.freecell_compose.freecell.model.Suit
import freecell_compose.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ClassicCardFace(
    card: Card,
    width: Dp,
    height: Dp,
    corner: Dp,
    borderW: Dp,
    headerH: Dp,
    showArtwork: Boolean,
    dim: Boolean,
    modifier: Modifier = Modifier,
) {
    CardSurface(card, width, height, corner, borderW, dim, modifier) {
        // Identical indices on covered and exposed cards avoid a style change during moves.
        ClassicIndex(card, width, headerH)
        if (showArtwork) {
            ClassicIndex(card, width, headerH, Modifier.align(Alignment.BottomEnd).rotate(180f))
            val bodyTop = headerH + height * 0.02f
            val bodyH = (height - bodyTop * 2f).coerceAtLeast(0.dp)
            val bodyW = width * 0.66f
            Box(
                Modifier.offset(x = (width - bodyW) / 2f, y = bodyTop).size(bodyW, bodyH),
                contentAlignment = Alignment.Center,
            ) {
                if (card.rank >= 11) {
                    Image(
                        painterResource(courtArt(card)),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(bodyW, bodyH).border(0.5.dp, Color(0xFFC3AC76)),
                    )
                } else {
                    val pipSize = if (card.rank == 1) width * 0.43f else (bodyW * 0.29f).coerceAtMost(bodyH * 0.23f)
                    for ((x, y) in pipPositions(card.rank)) {
                        SuitPip(
                            card.suit, card.ink(), pipSize,
                            Modifier.offset(
                                x = (bodyW - pipSize) * (x - 0.5f),
                                y = (bodyH - pipSize) * (y - 0.5f),
                            ).rotate(if (y > 0.5f) 180f else 0f),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ClassicIndex(card: Card, width: Dp, height: Dp, modifier: Modifier = Modifier) {
    val inset = width * 0.07f
    val rankW = width * 0.26f
    val pip = height * 0.59f
    Box(modifier.size(width, height)) {
        Box(Modifier.offset(x = inset).size(rankW, height), contentAlignment = Alignment.Center) {
            CardRank(card, height * if (card.rank == 10) 0.8f else 0.92f, classic = true)
        }
        Box(Modifier.offset(x = inset + rankW + width * 0.025f).size(pip, height), contentAlignment = Alignment.Center) {
            SuitPip(card.suit, card.ink(), pip)
        }
    }
}

// Standard symmetric pip arrangements; lower-half pips face the opposite end.
internal fun pipPositions(rank: Int): List<Pair<Float, Float>> {
    val corners = listOf(0f to 0f, 1f to 0f, 0f to 1f, 1f to 1f)
    val six = corners + listOf(0f to 0.5f, 1f to 0.5f)
    val eight = listOf(0f, 1f).flatMap { x -> listOf(0f, 1f / 3f, 2f / 3f, 1f).map { y -> x to y } }
    return when (rank) {
        1 -> listOf(0.5f to 0.5f)
        2 -> listOf(0.5f to 0f, 0.5f to 1f)
        3 -> listOf(0.5f to 0f, 0.5f to 0.5f, 0.5f to 1f)
        4 -> corners
        5 -> corners + (0.5f to 0.5f)
        6 -> six
        7 -> six + (0.5f to 0.25f)
        8 -> six + listOf(0.5f to 0.25f, 0.5f to 0.75f)
        9 -> eight + (0.5f to 0.5f)
        10 -> eight + listOf(0.5f to (1f / 6f), 0.5f to (5f / 6f))
        else -> emptyList()
    }
}

private fun courtArt(card: Card): DrawableResource = when (card.rank) {
    11 -> when (card.suit) {
        Suit.Clubs -> Res.drawable.court_jack_clubs
        Suit.Diamonds -> Res.drawable.court_jack_diamonds
        Suit.Hearts -> Res.drawable.court_jack_hearts
        Suit.Spades -> Res.drawable.court_jack_spades
    }
    12 -> when (card.suit) {
        Suit.Clubs -> Res.drawable.court_queen_clubs
        Suit.Diamonds -> Res.drawable.court_queen_diamonds
        Suit.Hearts -> Res.drawable.court_queen_hearts
        Suit.Spades -> Res.drawable.court_queen_spades
    }
    else -> when (card.suit) {
        Suit.Clubs -> Res.drawable.court_king_clubs
        Suit.Diamonds -> Res.drawable.court_king_diamonds
        Suit.Hearts -> Res.drawable.court_king_hearts
        Suit.Spades -> Res.drawable.court_king_spades
    }
}
