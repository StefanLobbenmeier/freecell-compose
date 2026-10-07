package de.dukat.freecell_compose.ui

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.dukat.freecell_compose.freecell.model.Card
import freecell_compose.composeapp.generated.resources.Res
import freecell_compose.composeapp.generated.resources.barlow_condensed_semibold
import org.jetbrains.compose.resources.Font

internal fun cardPaperColor(dim: Boolean) = if (dim) Color(0xFFD8D5CC) else Color(0xFFFFFDF7)
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
    val description = localizedCardDescription(card)
    val shape = RoundedCornerShape(corner)
    Box(
        modifier.size(width, height)
            .shadow(1.dp, shape)
            .clip(shape)
            // Keep the ink at full contrast even when a card cannot be moved.
            .background(cardPaperColor(dim))
            .border(borderW, Color(0xFFCEC9BC), shape)
            .semantics { contentDescription = description },
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
    val inset = width * 0.04f
    val header = headerH.coerceAtMost(height)
    // Barlow Condensed fits "10" at the same font size as every other rank.
    // Its cap height is 0.7 em: match the suit to visible ink, not the font's em box.
    val rankSize = (width * 0.62f).coerceAtMost(header * 0.9f)
    val capHeight = rankSize * 0.7f
    val font = FontFamily(Font(Res.font.barlow_condensed_semibold, FontWeight.SemiBold))
    val density = LocalDensity.current
    val rankLayout = rememberTextMeasurer().measure(
        rankLabel(card.rank),
        style = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.SemiBold,
            fontSize = with(density) { rankSize.toSp() },
            color = card.ink(),
        ),
        softWrap = false,
        maxLines = 1,
    )
    CardSurface(card, width, height, corner, borderW, dim, modifier) {
        Canvas(Modifier.size(width, header)) {
            // Align the cap-height center with the suit, allowing Q its natural descender.
            drawText(rankLayout, topLeft = Offset(
                x = inset.toPx(),
                y = (size.height + capHeight.toPx()) / 2f - rankLayout.firstBaseline,
            ))
        }
        Box(Modifier.offset(x = width - inset - capHeight).size(capHeight, header), contentAlignment = Alignment.Center) {
            SuitPip(card.suit, card.ink(), capHeight)
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
