package de.dukat.playingcards

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.KingOfSpades: ImageVector
    get() {
        if (_KingOfSpades != null) {
            return _KingOfSpades!!
        }
        _KingOfSpades = ImageVector.Builder(
            name = "KingOfSpades",
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
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.Black,
                        1f to Color.Black.copy(alpha = 0.64705884f)
                    ),
                    center = Offset(82.21f, 92.24f),
                    radius = 79.94f
                )
            ) {
                moveTo(134.3f, 137.93f)
                curveTo(132.77f, 114.54f, 85.44f, 70.51f, 83.91f, 59.49f)
                curveToRelative(-1.53f, 11.01f, -48.86f, 55.04f, -50.38f, 78.44f)
                curveToRelative(-1.07f, 16.54f, 10.69f, 23.39f, 21.38f, 23.39f)
                curveToRelative(11.57f, -0.12f, 21.13f, -16.15f, 24.43f, -19.27f)
                curveToRelative(1.53f, 4.13f, -10.11f, 38.53f, -13.74f, 38.53f)
                lineToRelative(36.65f, 0f)
                curveTo(98.61f, 180.59f, 86.97f, 146.19f, 88.5f, 142.06f)
                curveTo(91.38f, 144.92f, 99.83f, 160.85f, 112.93f, 161.33f)
                curveTo(123.62f, 161.32f, 135.36f, 154.47f, 134.3f, 137.93f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0.43137255f)
                    ),
                    center = Offset(41.15f, 135.21f),
                    radius = 45.24f
                )
            ) {
                moveToRelative(47.8f, 166.39f)
                curveToRelative(0f, 0f, -21.66f, -17.59f, -19.03f, -32.99f)
                curveToRelative(2.96f, -17.31f, 29.95f, -54.6f, 29.95f, -54.6f)
                curveToRelative(0f, 0f, -4.04f, 44.09f, -6.98f, 57.66f)
                curveToRelative(-2.82f, 12.97f, -3.94f, 29.94f, -3.94f, 29.94f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0.4862745f)
                    ),
                    center = Offset(54.97f, 111.96f),
                    radius = 53.57f
                )
            ) {
                moveToRelative(51.92f, 154.63f)
                curveToRelative(0f, 0f, -21.07f, -37.05f, -12.04f, -53.84f)
                curveToRelative(10.16f, -18.87f, 58.27f, -44.59f, 58.27f, -44.59f)
                curveToRelative(0f, 0f, -21.41f, 50.61f, -30.16f, 64.94f)
                curveToRelative(-8.37f, 13.7f, -16.07f, 33.49f, -16.07f, 33.49f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0.23529412f)
                    ),
                    center = Offset(71.84f, 91.34f),
                    radius = 45.24f
                )
            ) {
                moveToRelative(65.03f, 122.49f)
                curveToRelative(0f, 0f, -12.47f, -24.96f, -3.72f, -37.9f)
                curveToRelative(9.84f, -14.55f, 49.81f, -37.39f, 49.81f, -37.39f)
                curveToRelative(0f, 0f, -21.87f, 38.5f, -30.15f, 49.64f)
                curveToRelative(-7.91f, 10.65f, -15.94f, 25.65f, -15.94f, 25.65f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFFEFF))) {
                moveToRelative(14.05f, 36.61f)
                lineToRelative(0f, 169.67f)
                lineToRelative(134.49f, 0f)
                lineToRelative(0f, -169.67f)
                lineToRelative(-134.49f, 0f)
                close()
                moveTo(83.92f, 59.49f)
                curveToRelative(1.53f, 11.01f, 48.85f, 55.05f, 50.38f, 78.44f)
                curveToRelative(1.07f, 16.54f, -10.68f, 23.39f, -21.36f, 23.39f)
                curveToRelative(-13.1f, -0.48f, -21.55f, -16.4f, -24.44f, -19.27f)
                curveToRelative(-1.53f, 4.13f, 10.11f, 38.53f, 13.74f, 38.53f)
                lineToRelative(-36.64f, 0f)
                curveToRelative(3.63f, 0f, 15.27f, -34.4f, 13.74f, -38.53f)
                curveToRelative(-3.29f, 3.12f, -12.86f, 19.14f, -24.43f, 19.27f)
                curveToRelative(-10.69f, 0f, -22.44f, -6.85f, -21.38f, -23.39f)
                curveToRelative(1.53f, -23.4f, 48.86f, -67.43f, 50.39f, -78.44f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(158.56f, 215.1f)
                lineToRelative(-0f, 22.91f)
                lineToRelative(-3.03f, -0f)
                lineToRelative(-0f, -11.36f)
                lineToRelative(-11.38f, 11.36f)
                lineToRelative(-4.11f, -0f)
                lineToRelative(9.61f, -9.28f)
                lineToRelative(-10.03f, -13.63f)
                lineToRelative(4f, -0f)
                lineToRelative(8.16f, 11.59f)
                lineToRelative(3.75f, -3.66f)
                lineToRelative(-0f, -7.94f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(138.17f, 193.76f)
                curveTo(138.54f, 199.36f, 149.86f, 209.89f, 150.22f, 212.53f)
                curveToRelative(0.37f, -2.63f, 11.69f, -13.17f, 12.05f, -18.76f)
                curveToRelative(0.25f, -3.96f, -2.56f, -5.6f, -5.11f, -5.6f)
                curveToRelative(-2.77f, 0.03f, -5.06f, 3.86f, -5.84f, 4.61f)
                curveToRelative(-0.37f, -0.99f, 2.42f, -9.22f, 3.29f, -9.22f)
                lineToRelative(-8.77f, -0f)
                curveTo(146.71f, 183.56f, 149.49f, 191.79f, 149.13f, 192.78f)
                curveTo(148.44f, 192.09f, 146.42f, 188.28f, 143.28f, 188.17f)
                curveTo(140.73f, 188.17f, 137.92f, 189.81f, 138.17f, 193.76f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(8.59f, 28.01f)
                verticalLineTo(5.11f)
                horizontalLineTo(11.62f)
                verticalLineTo(16.47f)
                lineToRelative(11.38f, -11.36f)
                horizontalLineToRelative(4.11f)
                lineToRelative(-9.61f, 9.28f)
                lineToRelative(10.03f, 13.63f)
                horizontalLineToRelative(-4f)
                lineToRelative(-8.16f, -11.59f)
                lineToRelative(-3.75f, 3.66f)
                verticalLineToRelative(7.94f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(28.98f, 49.35f)
                curveTo(28.62f, 43.75f, 17.29f, 33.22f, 16.93f, 30.58f)
                curveToRelative(-0.37f, 2.63f, -11.69f, 13.17f, -12.05f, 18.76f)
                curveToRelative(-0.25f, 3.96f, 2.56f, 5.6f, 5.11f, 5.6f)
                curveToRelative(2.77f, -0.03f, 5.06f, -3.86f, 5.84f, -4.61f)
                curveToRelative(0.37f, 0.99f, -2.42f, 9.22f, -3.29f, 9.22f)
                lineToRelative(8.77f, 0f)
                curveTo(20.44f, 59.55f, 17.66f, 51.32f, 18.03f, 50.33f)
                curveTo(18.72f, 51.02f, 20.74f, 54.83f, 23.87f, 54.94f)
                curveTo(26.43f, 54.94f, 29.24f, 53.3f, 28.98f, 49.35f)
                close()
            }
        }.build()

        return _KingOfSpades!!
    }

@Suppress("ObjectPropertyName")
private var _KingOfSpades: ImageVector? = null
