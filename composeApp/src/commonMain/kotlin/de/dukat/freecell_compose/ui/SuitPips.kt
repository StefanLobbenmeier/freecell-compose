package de.dukat.freecell_compose.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.Dp
import de.dukat.freecell_compose.freecell.model.Suit
import kotlin.math.min

@Composable
fun SuitPip(
    suit: Suit,
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier,
) {
    val base = remember(suit) {
        val p = when (suit) {
            Suit.Hearts -> heartPipPath()
            Suit.Diamonds -> diamondPipPath()
            Suit.Clubs -> clubPipPath()
            Suit.Spades -> spadePipPath()
        }
        p to p.getBounds()
    }

    Canvas(modifier = modifier.size(size)) {
        val (path, bounds) = base
        val s = this.size

        val scale = min(s.width / bounds.width, s.height / bounds.height)
        val dx = (s.width - (bounds.width * scale)) / 2f - (bounds.left * scale)
        val dy = (s.height - (bounds.height * scale)) / 2f - (bounds.top * scale)

        withTransform({
            translate(dx, dy)
            scale(scale, scale)
        }) {
            drawPath(path = path, color = color, style = Fill)
        }
    }
}

fun rankLabel(rank: Int): String = when (rank) {
    1 -> "A"
    11 -> "J"
    12 -> "Q"
    13 -> "K"
    else -> rank.toString()
}

// These suit marks use the exact path data from the existing card vectors
// (the small corner pips), so they match the card design.
private fun heartPipPath(): Path = Path().apply {
    moveTo(23.33f, 32.28f)
    cubicTo(17.9f, 32.28f, 17.18f, 37.73f, 17.18f, 37.73f)
    cubicTo(17.18f, 37.73f, 16.45f, 32.28f, 11.02f, 32.28f)
    cubicTo(7.22f, 32.28f, 3.78f, 34.73f, 3.78f, 39.33f)
    cubicTo(3.78f, 45.42f, 14.8f, 51.55f, 17.18f, 60.49f)
    cubicTo(19.44f, 51.55f, 30.57f, 45.42f, 30.57f, 39.33f)
    cubicTo(30.57f, 34.73f, 27.13f, 32.28f, 23.33f, 32.28f)
    close()
}

private fun diamondPipPath(): Path = Path().apply {
    moveTo(21.76f, 37.26f)
    cubicTo(18.63f, 33.03f, 16.97f, 28.73f, 16.97f, 28.73f)
    relativeCubicTo(0f, 0f, -1.66f, 4.3f, -4.79f, 8.53f)
    cubicTo(9.05f, 41.49f, 5.15f, 44.24f, 5.15f, 44.24f)
    cubicTo(5.15f, 44.24f, 9.05f, 46.99f, 12.18f, 51.22f)
    cubicTo(15.3f, 55.44f, 16.97f, 59.74f, 16.97f, 59.74f)
    cubicTo(16.97f, 59.74f, 18.63f, 55.44f, 21.76f, 51.22f)
    cubicTo(24.89f, 46.99f, 28.78f, 44.24f, 28.78f, 44.24f)
    cubicTo(28.78f, 44.24f, 24.89f, 41.49f, 21.76f, 37.26f)
    close()
}

private fun clubPipPath(): Path = Path().apply {
    relativeMoveTo(20.69f, 43.74f)
    relativeCubicTo(0f, 0f, 3.53f, -2.82f, 3.53f, -6.74f)
    relativeCubicTo(0f, -2.29f, -2.03f, -6.09f, -6.74f, -6.09f)
    relativeCubicTo(-4.7f, 0f, -6.74f, 3.8f, -6.74f, 6.09f)
    relativeCubicTo(0f, 3.91f, 3.53f, 6.74f, 3.53f, 6.74f)
    relativeCubicTo(-3.92f, -3.05f, -10.91f, -0.97f, -10.91f, 5.13f)
    relativeCubicTo(0f, 3.05f, 2.5f, 6.42f, 6.42f, 6.42f)
    relativeCubicTo(4.7f, 0f, 6.74f, -5.13f, 6.74f, -5.13f)
    relativeCubicTo(0f, 0f, 0.6f, 5.85f, -2.89f, 8.98f)
    relativeLineTo(7.7f, 0f)
    relativeCubicTo(-3.48f, -3.13f, -2.89f, -8.98f, -2.89f, -8.98f)
    relativeCubicTo(0f, 0f, 2.03f, 5.13f, 6.74f, 5.13f)
    relativeCubicTo(3.92f, 0f, 6.42f, -3.36f, 6.42f, -6.42f)
    relativeCubicTo(0f, -6.1f, -6.99f, -8.19f, -10.91f, -5.13f)
    close()
}

private fun spadePipPath(): Path = Path().apply {
    moveTo(28.98f, 49.35f)
    cubicTo(28.62f, 43.75f, 17.29f, 33.22f, 16.93f, 30.58f)
    relativeCubicTo(-0.37f, 2.63f, -11.69f, 13.17f, -12.05f, 18.76f)
    relativeCubicTo(-0.25f, 3.96f, 2.56f, 5.6f, 5.11f, 5.6f)
    relativeCubicTo(2.77f, -0.03f, 5.06f, -3.86f, 5.84f, -4.61f)
    relativeCubicTo(0.37f, 0.99f, -2.42f, 9.22f, -3.29f, 9.22f)
    relativeLineTo(8.77f, 0f)
    cubicTo(20.44f, 59.55f, 17.66f, 51.32f, 18.03f, 50.33f)
    relativeCubicTo(0.69f, 0.69f, 2.71f, 4.5f, 5.84f, 4.61f)
    relativeCubicTo(2.56f, 0f, 5.37f, -1.64f, 5.11f, -5.59f)
    close()
}
