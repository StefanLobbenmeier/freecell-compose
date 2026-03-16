package de.dukat.playingcards

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.QueenOfHearts: ImageVector
    get() {
        if (_QueenOfHearts != null) {
            return _QueenOfHearts!!
        }
        _QueenOfHearts = ImageVector.Builder(
            name = "QueenOfHearts",
            defaultWidth = 167.09.dp,
            defaultHeight = 242.67.dp,
            viewportWidth = 167.09f,
            viewportHeight = 242.67f
        ).apply {
            path(
                fill = SolidColor(Color.White),
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 0.5f
            ) {
                moveTo(166.84f, 235.55f)
                curveToRelative(0f, 3.78f, -3.09f, 6.87f, -6.87f, 6.87f)
                horizontalLineTo(7.11f)
                curveToRelative(-3.77f, 0f, -6.86f, -3.09f, -6.86f, -6.87f)
                verticalLineTo(7.12f)
                curveTo(0.25f, 3.34f, 3.34f, 0.25f, 7.11f, 0.25f)
                horizontalLineToRelative(152.85f)
                curveToRelative(3.78f, 0f, 6.87f, 3.09f, 6.87f, 6.87f)
                verticalLineToRelative(228.43f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveToRelative(24.47f, 25.56f)
                quadToRelative(2.11f, 1.45f, 3.89f, 2.13f)
                lineToRelative(-0.89f, 2.11f)
                quadToRelative(-2.47f, -0.89f, -4.92f, -2.81f)
                quadToRelative(-2.55f, 1.42f, -5.63f, 1.42f)
                quadToRelative(-3.11f, 0f, -5.64f, -1.5f)
                quadToRelative(-2.53f, -1.5f, -3.91f, -4.22f)
                quadToRelative(-1.36f, -2.72f, -1.36f, -6.13f)
                quadToRelative(0f, -3.39f, 1.38f, -6.17f)
                quadToRelative(1.38f, -2.78f, 3.91f, -4.23f)
                quadToRelative(2.55f, -1.45f, 5.69f, -1.45f)
                quadToRelative(3.17f, 0f, 5.72f, 1.52f)
                quadToRelative(2.55f, 1.5f, 3.88f, 4.22f)
                quadToRelative(1.34f, 2.7f, 1.34f, 6.11f)
                quadToRelative(0f, 2.83f, -0.86f, 5.09f)
                quadToRelative(-0.86f, 2.25f, -2.59f, 3.92f)
                close()
                moveTo(17.8f, 21.69f)
                quadToRelative(2.63f, 0.73f, 4.33f, 2.19f)
                quadToRelative(2.67f, -2.44f, 2.67f, -7.33f)
                quadToRelative(0f, -2.78f, -0.95f, -4.86f)
                quadToRelative(-0.94f, -2.08f, -2.77f, -3.22f)
                quadToRelative(-1.81f, -1.16f, -4.08f, -1.16f)
                quadToRelative(-3.39f, 0f, -5.63f, 2.33f)
                quadToRelative(-2.23f, 2.31f, -2.23f, 6.92f)
                quadToRelative(0f, 4.47f, 2.2f, 6.86f)
                quadToRelative(2.22f, 2.39f, 5.66f, 2.39f)
                quadToRelative(1.63f, 0f, 3.06f, -0.61f)
                quadToRelative(-1.42f, -0.92f, -3f, -1.31f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDF0000),
                        1f to Color(0xABDF0000)
                    ),
                    center = Offset(81.74f, 89.37f),
                    radius = 54.6f
                )
            ) {
                moveTo(108.23f, 64.78f)
                curveTo(86.1f, 64.78f, 83.14f, 86.99f, 83.14f, 86.99f)
                curveTo(83.14f, 86.99f, 80.19f, 64.78f, 58.05f, 64.78f)
                curveTo(42.56f, 64.78f, 28.54f, 74.74f, 28.54f, 93.53f)
                curveTo(28.54f, 118.35f, 73.44f, 143.31f, 83.14f, 179.77f)
                curveTo(92.37f, 143.35f, 137.75f, 118.35f, 137.75f, 93.53f)
                curveTo(137.75f, 74.74f, 123.73f, 64.78f, 108.23f, 64.78f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0.30980393f)
                    ),
                    center = Offset(44.15f, 79.51f),
                    radius = 32.26f
                )
            ) {
                moveToRelative(29.94f, 111.02f)
                curveToRelative(0f, 0f, -2.36f, -28.73f, 6.68f, -37.18f)
                curveToRelative(10.16f, -9.49f, 40.91f, -3.46f, 40.91f, -3.46f)
                curveToRelative(0f, 0f, -20.9f, 7.52f, -29.22f, 14.7f)
                curveToRelative(-7.95f, 6.87f, -18.37f, 25.94f, -18.37f, 25.94f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0.28627452f)
                    ),
                    center = Offset(96.13f, 75.83f),
                    radius = 26.14f
                )
            ) {
                moveToRelative(82.27f, 102.45f)
                curveToRelative(0f, 0f, 4.32f, -26.74f, 13.15f, -32.38f)
                curveToRelative(9.93f, -6.34f, 32.53f, 6.16f, 32.53f, 6.16f)
                curveToRelative(0f, 0f, -16.73f, 6.03f, -24.73f, 10.69f)
                curveToRelative(-7.65f, 4.45f, -20.95f, 15.53f, -20.95f, 15.53f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(23.33f, 32.28f)
                curveTo(17.9f, 32.28f, 17.18f, 37.73f, 17.18f, 37.73f)
                curveTo(17.18f, 37.73f, 16.45f, 32.28f, 11.02f, 32.28f)
                curveTo(7.22f, 32.28f, 3.78f, 34.73f, 3.78f, 39.33f)
                curveTo(3.78f, 45.42f, 14.8f, 51.55f, 17.18f, 60.49f)
                curveTo(19.44f, 51.55f, 30.57f, 45.42f, 30.57f, 39.33f)
                curveTo(30.57f, 34.73f, 27.13f, 32.28f, 23.33f, 32.28f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveToRelative(142.86f, 215.97f)
                quadToRelative(-2.11f, -1.45f, -3.89f, -2.13f)
                lineToRelative(0.89f, -2.11f)
                quadToRelative(2.47f, 0.89f, 4.92f, 2.81f)
                quadToRelative(2.55f, -1.42f, 5.63f, -1.42f)
                quadToRelative(3.11f, -0f, 5.64f, 1.5f)
                quadToRelative(2.53f, 1.5f, 3.91f, 4.22f)
                quadToRelative(1.36f, 2.72f, 1.36f, 6.13f)
                quadToRelative(-0f, 3.39f, -1.38f, 6.17f)
                quadToRelative(-1.38f, 2.78f, -3.91f, 4.23f)
                quadToRelative(-2.55f, 1.45f, -5.69f, 1.45f)
                quadToRelative(-3.17f, -0f, -5.72f, -1.52f)
                quadToRelative(-2.55f, -1.5f, -3.88f, -4.22f)
                quadToRelative(-1.34f, -2.7f, -1.34f, -6.11f)
                quadToRelative(-0f, -2.83f, 0.86f, -5.09f)
                quadToRelative(0.86f, -2.25f, 2.59f, -3.92f)
                close()
                moveTo(149.53f, 219.84f)
                quadToRelative(-2.63f, -0.73f, -4.33f, -2.19f)
                quadToRelative(-2.67f, 2.44f, -2.67f, 7.33f)
                quadToRelative(-0f, 2.78f, 0.95f, 4.86f)
                quadToRelative(0.94f, 2.08f, 2.77f, 3.22f)
                quadToRelative(1.81f, 1.16f, 4.08f, 1.16f)
                quadToRelative(3.39f, -0f, 5.63f, -2.33f)
                quadToRelative(2.23f, -2.31f, 2.23f, -6.92f)
                quadToRelative(-0f, -4.47f, -2.2f, -6.86f)
                quadToRelative(-2.22f, -2.39f, -5.66f, -2.39f)
                quadToRelative(-1.63f, -0f, -3.06f, 0.61f)
                quadToRelative(1.42f, 0.92f, 3f, 1.31f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(144f, 209.25f)
                curveTo(149.43f, 209.25f, 150.16f, 203.8f, 150.16f, 203.8f)
                curveTo(150.16f, 203.8f, 150.88f, 209.25f, 156.31f, 209.25f)
                curveTo(160.11f, 209.25f, 163.55f, 206.8f, 163.55f, 202.19f)
                curveTo(163.55f, 196.11f, 152.53f, 189.98f, 150.16f, 181.04f)
                curveTo(147.89f, 189.97f, 136.76f, 196.11f, 136.76f, 202.19f)
                curveTo(136.76f, 206.8f, 140.2f, 209.25f, 144f, 209.25f)
                close()
            }
        }.build()

        return _QueenOfHearts!!
    }

@Suppress("ObjectPropertyName")
private var _QueenOfHearts: ImageVector? = null
