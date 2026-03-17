package de.dukat.freecell_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.dukat.freecell_compose.freecell.model.Card

@Composable
fun StackedHiddenCardFace(
    card: Card,
    width: Dp,
    height: Dp,
    borderW: Dp = 1.dp,
    dim: Boolean = false,
    modifier: Modifier = Modifier,
) {
    val minDim = if (width < height) width else height
    val corner = RoundedCornerShape((minDim * 0.15f).coerceIn(4.dp, 12.dp))

    val pipColor = if (card.isRed) Color(0xFFDF0000) else Color.Black
    val bg = Color.White
    val headerH = (height * 0.18f).coerceIn(10.dp, 22.dp)

    val padStart = (width * 0.08f).coerceIn(3.dp, 8.dp)
    val padTop = (height * 0.012f).coerceIn(0.dp, 2.dp)
    val padEnd = (width * 0.10f).coerceIn(3.dp, 10.dp)
    val pipGap = (width * 0.035f).coerceIn(1.dp, 5.dp)

    val density = LocalDensity.current
    val headerSp = with(density) { headerH.toSp() }
    val fontSize = (headerSp.value * 0.78f).coerceIn(8f, 14f).sp

    // Match the same dimming used by CardFace (color matrix scaling).
    val dimFilter: ColorFilter? = if (dim) {
        ColorFilter.colorMatrix(
            ColorMatrix().apply { setToScale(0.72f, 0.72f, 0.72f, 1f) }
        )
    } else {
        null
    }

    Box(
        modifier = modifier
            .clip(corner)
            .border(borderW, Color(0x26000000), corner)
            .size(width, height)
    ) {
        // Inner layer: draw the card's white background here so the dim color matrix
        // affects it (matching the behavior of the vector cards).
        Box(
            modifier = Modifier
                .fillMaxSize()
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
            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = padStart, top = padTop, end = padEnd),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = rankLabel(card.rank),
                    color = pipColor,
                    fontSize = fontSize,
                    fontWeight = FontWeight.Black,
                )
                SuitPip(
                    suit = card.suit,
                    color = pipColor,
                    size = headerH * 0.62f,
                    modifier = Modifier.padding(start = pipGap)
                )
            }
        }
    }
}
