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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    dim: Boolean = false,
    modifier: Modifier = Modifier,
) {
    val corner = RoundedCornerShape(12.dp)
    val alpha = if (dim) 0.72f else 1f

    val pipColor = if (card.isRed) Color(0xFFDF0000) else Color.Black
    val bg = Color.White
    val headerH = (height * 0.18f).coerceIn(10.dp, 22.dp)
    val density = LocalDensity.current
    val headerSp = with(density) { headerH.toSp() }
    val fontSize = (headerSp.value * 0.78f).coerceIn(8f, 14f).sp

    Box(
        modifier = modifier
            .alpha(alpha)
            .clip(corner)
            .background(bg)
            .border(1.dp, Color(0x26000000), corner)
            .size(width, height)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 6.dp, top = 3.dp, end = 8.dp),
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
                modifier = Modifier.padding(start = 3.dp)
            )
        }

        // Keep body subtle so header pops.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = headerH)
                .background(Color(0x00000000))
        )
    }
}
