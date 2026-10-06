package de.dukat.freecell_compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.dukat.freecell_compose.freecell.model.Card

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
            val artwork = remember(card, dim) { card.toPlayingCardArtwork(cardPaperColor(dim)) }
            Image(
                painter = rememberVectorPainter(artwork),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.offset(y = bodyTop).size(width, bodyH),
            )
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
