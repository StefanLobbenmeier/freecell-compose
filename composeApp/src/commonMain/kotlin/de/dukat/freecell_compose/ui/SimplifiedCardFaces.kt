package de.dukat.freecell_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.dukat.freecell_compose.freecell.model.Card

@Composable
fun SimplifiedCardFace(
    card: Card,
    width: Dp,
    height: Dp,
    corner: Dp,
    borderW: Dp,
    headerH: Dp,
    headerMaxH: Dp? = null,
    showLargePip: Boolean,
    dim: Boolean,
    modifier: Modifier = Modifier,
) {
    val pipColor = if (card.isRed) Color(0xFFDF0000) else Color.Black
    val bg = Color.White
    val shape = RoundedCornerShape(corner)

    val actualHeaderH = (if (headerMaxH != null) headerH.coerceAtMost(headerMaxH) else headerH)
        .coerceAtMost(height)

    val padX = (width * 0.03f).coerceIn(1.dp, 4.dp)
    // Keep the header tight; we disable platform font padding below.
    val padTop = 0.dp

    val density = LocalDensity.current
    fun minDp(a: Dp, b: Dp): Dp = if (a < b) a else b
    val halfW = width / 2f
    val headerUnit = minDp(halfW, actualHeaderH)

    // Size text relative to the same unit as the suit icon so they scale together.
    // Slightly oversize the rank to compensate for font metrics looking smaller than the pip.
    val rankSize = with(density) { (headerUnit * 1.04f).toSp() }
    val rankStyle = TextStyle(
        fontSize = rankSize,
        lineHeight = rankSize,
        fontWeight = FontWeight.Black,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Top,
            trim = LineHeightStyle.Trim.Both,
        ),
    )

    // Nudge the text up a bit to counteract extra ascent space.
    val rankNudgeY = (-actualHeaderH * 0.08f).coerceIn((-3).dp, 0.dp)

    val dimFilter: ColorFilter? = if (dim) {
        ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.72f, 0.72f, 0.72f, 1f) })
    } else {
        null
    }

    val headerPipSize = headerUnit * 0.92f

    val bigPipTarget = headerPipSize * 2f
    val availableBelow = (height - actualHeaderH).coerceAtLeast(0.dp)
    val bigPipSize = minDp(minDp(bigPipTarget, width * 0.88f), availableBelow * 0.92f)

    Box(
        modifier = modifier
            .size(width, height)
            .clip(shape)
            .border(borderW, Color(0x26000000), shape)
            .drawWithContent {
                val f = dimFilter
                if (f == null) {
                    drawRect(bg)
                    drawContent()
                } else {
                    val paint = Paint().apply { colorFilter = f }
                    drawContext.canvas.saveLayer(Rect(Offset.Zero, size), paint)
                    drawRect(bg)
                    drawContent()
                    drawContext.canvas.restore()
                }
            }
    ) {
        // Header row: huge rank left, huge suit right; whitespace in the middle.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(actualHeaderH)
                .padding(start = padX, end = padX, top = padTop),
            verticalAlignment = Alignment.Top,
        ) {
            Box(
                modifier = Modifier
                    .width(halfW)
                    .fillMaxSize(),
                contentAlignment = Alignment.TopStart,
            ) {
                Text(
                    text = rankLabel(card.rank),
                    color = pipColor,
                    style = rankStyle,
                    maxLines = 1,
                    modifier = Modifier.offset(y = rankNudgeY),
                )
            }

            Box(
                modifier = Modifier
                    .width(halfW)
                    .fillMaxSize(),
                contentAlignment = Alignment.TopEnd,
            ) {
                SuitPip(
                    suit = card.suit,
                    color = pipColor,
                    size = headerPipSize,
                )
            }
        }

        if (showLargePip && bigPipSize > 0.dp) {
            SuitPip(
                suit = card.suit,
                color = pipColor,
                size = bigPipSize,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = actualHeaderH + padX)
            )
        }
    }
}
