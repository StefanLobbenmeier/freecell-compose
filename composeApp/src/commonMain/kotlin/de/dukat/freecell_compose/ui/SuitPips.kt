package de.dukat.freecell_compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.dukat.freecell_compose.freecell.model.Suit

@Composable
fun SuitPip(
    suit: Suit,
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier,
) {
    val vector = remember(suit) { suitPipVector(suit) }
    Image(
        painter = rememberVectorPainter(vector),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        colorFilter = ColorFilter.tint(color),
        modifier = modifier.size(size),
    )
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

private fun suitPipVector(suit: Suit): ImageVector {
    val bounds = when (suit) {
        Suit.Hearts -> Rect(3.78f, 32.28f, 30.57f, 60.49f)
        Suit.Diamonds -> Rect(5.15f, 28.73f, 28.78f, 59.74f)
        Suit.Clubs -> Rect(3.04f, 30.91f, 31.11f, 59.55f)
        Suit.Spades -> Rect(4.88f, 30.58f, 28.98f, 59.55f)
    }

    val vw = bounds.width
    val vh = bounds.height

    return ImageVector.Builder(
        name = "SuitPip_${suit.name}",
        defaultWidth = 100.dp,
        defaultHeight = 100.dp,
        viewportWidth = vw,
        viewportHeight = vh,
    ).apply {
        // Keep the viewport tight by translating the path data into 0..vw/vh.
        // Some targets have had issues with group translation; do it numerically instead.
        val l = bounds.left
        val t = bounds.top

        when (suit) {
            Suit.Hearts -> {
                path(fill = SolidColor(Color.Black)) {
                    moveTo(23.33f - l, 32.28f - t)
                    curveTo(17.9f - l, 32.28f - t, 17.18f - l, 37.73f - t, 17.18f - l, 37.73f - t)
                    curveTo(17.18f - l, 37.73f - t, 16.45f - l, 32.28f - t, 11.02f - l, 32.28f - t)
                    curveTo(7.22f - l, 32.28f - t, 3.78f - l, 34.73f - t, 3.78f - l, 39.33f - t)
                    curveTo(3.78f - l, 45.42f - t, 14.8f - l, 51.55f - t, 17.18f - l, 60.49f - t)
                    curveTo(19.44f - l, 51.55f - t, 30.57f - l, 45.42f - t, 30.57f - l, 39.33f - t)
                    curveTo(30.57f - l, 34.73f - t, 27.13f - l, 32.28f - t, 23.33f - l, 32.28f - t)
                    close()
                }
            }

            Suit.Diamonds -> {
                path(fill = SolidColor(Color.Black)) {
                    moveTo(21.76f - l, 37.26f - t)
                    curveTo(18.63f - l, 33.03f - t, 16.97f - l, 28.73f - t, 16.97f - l, 28.73f - t)
                    curveToRelative(0f, 0f, -1.66f, 4.3f, -4.79f, 8.53f)
                    curveTo(9.05f - l, 41.49f - t, 5.15f - l, 44.24f - t, 5.15f - l, 44.24f - t)
                    curveTo(5.15f - l, 44.24f - t, 9.05f - l, 46.99f - t, 12.18f - l, 51.22f - t)
                    curveTo(15.3f - l, 55.44f - t, 16.97f - l, 59.74f - t, 16.97f - l, 59.74f - t)
                    curveTo(16.97f - l, 59.74f - t, 18.63f - l, 55.44f - t, 21.76f - l, 51.22f - t)
                    curveTo(24.89f - l, 46.99f - t, 28.78f - l, 44.24f - t, 28.78f - l, 44.24f - t)
                    curveTo(28.78f - l, 44.24f - t, 24.89f - l, 41.49f - t, 21.76f - l, 37.26f - t)
                    close()
                }
            }

            Suit.Clubs -> {
                path(fill = SolidColor(Color.Black)) {
                    moveTo(20.69f - l, 43.74f - t)
                    curveTo(20.69f - l, 43.74f - t, 24.22f - l, 40.92f - t, 24.22f - l, 37.0f - t)
                    curveTo(24.22f - l, 34.71f - t, 22.19f - l, 30.91f - t, 17.48f - l, 30.91f - t)
                    curveTo(12.78f - l, 30.91f - t, 10.74f - l, 34.71f - t, 10.74f - l, 37.0f - t)
                    curveTo(10.74f - l, 40.91f - t, 14.27f - l, 43.74f - t, 14.27f - l, 43.74f - t)
                    curveTo(10.35f - l, 40.69f - t, 3.36f - l, 42.77f - t, 3.36f - l, 48.87f - t)
                    curveTo(3.36f - l, 51.92f - t, 5.86f - l, 55.29f - t, 9.78f - l, 55.29f - t)
                    curveTo(14.48f - l, 55.29f - t, 16.52f - l, 50.16f - t, 16.52f - l, 50.16f - t)
                    curveTo(16.52f - l, 50.16f - t, 17.12f - l, 56.01f - t, 13.63f - l, 59.14f - t)
                    horizontalLineTo(21.33f - l)
                    curveTo(17.85f - l, 56.01f - t, 18.44f - l, 50.16f - t, 18.44f - l, 50.16f - t)
                    curveTo(18.44f - l, 50.16f - t, 20.47f - l, 55.29f - t, 25.18f - l, 55.29f - t)
                    curveTo(29.1f - l, 55.29f - t, 31.6f - l, 51.93f - t, 31.6f - l, 48.87f - t)
                    curveTo(31.6f - l, 42.77f - t, 24.61f - l, 40.68f - t, 20.69f - l, 43.74f - t)
                    close()
                }
            }

            Suit.Spades -> {
                path(fill = SolidColor(Color.Black)) {
                    moveTo(28.98f - l, 49.35f - t)
                    curveTo(28.62f - l, 43.75f - t, 17.29f - l, 33.22f - t, 16.93f - l, 30.58f - t)
                    curveTo(16.56f - l, 33.21f - t, 5.24f - l, 43.75f - t, 4.88f - l, 49.34f - t)
                    curveTo(4.63f - l, 53.3f - t, 7.44f - l, 54.94f - t, 9.99f - l, 54.94f - t)
                    curveTo(12.76f - l, 54.91f - t, 15.05f - l, 51.08f - t, 15.83f - l, 50.33f - t)
                    curveTo(16.2f - l, 51.32f - t, 13.41f - l, 59.55f - t, 12.54f - l, 59.55f - t)
                    horizontalLineTo(21.31f - l)
                    curveTo(20.44f - l, 59.55f - t, 17.66f - l, 51.32f - t, 18.03f - l, 50.33f - t)
                    curveTo(18.72f - l, 51.02f - t, 20.74f - l, 54.83f - t, 23.87f - l, 54.94f - t)
                    curveTo(26.43f - l, 54.94f - t, 29.24f - l, 53.3f - t, 28.98f - l, 49.35f - t)
                    close()
                }
            }
        }
    }.build()
}
