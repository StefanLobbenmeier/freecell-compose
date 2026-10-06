package de.dukat.freecell_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.dukat.freecell_compose.freecell.model.Card

internal val CardPaper = Color(0xFFFFFDF7)
internal fun Card.ink() = if (isRed) Color(0xFFB22435) else Color(0xFF18252B)

@Composable
internal fun CardSurface(
    card: Card,
    width: Dp,
    height: Dp,
    corner: Dp,
    borderW: Dp,
    dim: Boolean,
    modifier: Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    val shape = RoundedCornerShape(corner)
    Box(
        modifier.size(width, height)
            .shadow(1.dp, shape)
            .clip(shape)
            // Keep the ink at full contrast even when a card cannot be moved.
            .background(if (dim) Color(0xFFECEAE3) else CardPaper)
            .border(borderW, Color(0xFFCEC9BC), shape)
            .semantics { contentDescription = "${rankLabel(card.rank)} of ${card.suit.name}" },
        content = content,
    )
}

@Composable
internal fun CardRank(card: Card, size: Dp, modifier: Modifier = Modifier, classic: Boolean = false) {
    val fontSize = with(LocalDensity.current) { size.toSp() }
    Text(
        text = rankLabel(card.rank),
        color = card.ink(),
        style = TextStyle(
            fontFamily = if (classic) FontFamily.Serif else FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = fontSize,
            lineHeight = fontSize,
            lineHeightStyle = LineHeightStyle(LineHeightStyle.Alignment.Center, LineHeightStyle.Trim.Both),
        ),
        maxLines = 1,
        softWrap = false,
        modifier = modifier,
    )
}

@Composable
fun SimplifiedCardFace(
    card: Card,
    width: Dp,
    height: Dp,
    corner: Dp,
    borderW: Dp,
    headerH: Dp,
    showLargePip: Boolean,
    dim: Boolean,
    modifier: Modifier = Modifier,
) {
    val inset = width * 0.045f
    val header = headerH.coerceAtMost(height)
    // Reserve explicit, non-overlapping areas for the rank (including 10) and suit.
    val rankSize = (width * if (card.rank == 10) 0.44f else 0.66f).coerceAtMost(header * 0.9f)
    val pipSize = (width * 0.43f).coerceAtMost(header * 0.72f)
    CardSurface(card, width, height, corner, borderW, dim, modifier) {
        Box(Modifier.offset(x = inset).size(width * 0.51f, header), contentAlignment = Alignment.CenterStart) {
            CardRank(card, rankSize)
        }
        Box(Modifier.offset(x = width - inset - pipSize).size(pipSize, header), contentAlignment = Alignment.Center) {
            SuitPip(card.suit, card.ink(), pipSize)
        }
        if (showLargePip) {
            val bodyH = (height - header).coerceAtLeast(0.dp)
            val pip = (width * 0.68f).coerceAtMost(bodyH * 0.9f)
            Box(Modifier.offset(y = header).size(width, bodyH), contentAlignment = Alignment.Center) {
                SuitPip(card.suit, card.ink(), pip)
            }
        }
    }
}
