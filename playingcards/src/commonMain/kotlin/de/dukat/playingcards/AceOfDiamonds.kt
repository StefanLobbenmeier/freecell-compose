package de.dukat.playingcards

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.AceOfDiamonds: ImageVector
    get() {
        if (_AceOfDiamonds != null) {
            return _AceOfDiamonds!!
        }
        _AceOfDiamonds = ImageVector.Builder(
            name = "AceOfDiamonds",
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
                moveTo(6.2f, 28.01f)
                lineTo(15f, 5.11f)
                horizontalLineToRelative(3.27f)
                lineToRelative(9.38f, 22.91f)
                horizontalLineToRelative(-3.45f)
                lineToRelative(-2.67f, -6.94f)
                horizontalLineToRelative(-9.58f)
                lineToRelative(-2.52f, 6.94f)
                close()
                moveTo(12.81f, 18.61f)
                horizontalLineToRelative(7.77f)
                lineToRelative(-2.39f, -6.34f)
                quadToRelative(-1.09f, -2.89f, -1.63f, -4.75f)
                quadToRelative(-0.44f, 2.2f, -1.23f, 4.37f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveToRelative(161.13f, 213.52f)
                lineToRelative(-8.8f, 22.91f)
                lineToRelative(-3.27f, -0f)
                lineToRelative(-9.38f, -22.91f)
                lineToRelative(3.45f, -0f)
                lineToRelative(2.67f, 6.94f)
                lineToRelative(9.58f, -0f)
                lineToRelative(2.52f, -6.94f)
                close()
                moveTo(154.53f, 222.92f)
                lineToRelative(-7.77f, -0f)
                lineToRelative(2.39f, 6.34f)
                quadToRelative(1.09f, 2.89f, 1.63f, 4.75f)
                quadToRelative(0.44f, -2.2f, 1.23f, -4.38f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDF0000),
                        1f to Color(0xA3DF0000)
                    ),
                    center = Offset(82.28f, 91.63f),
                    radius = 53.44f
                )
            ) {
                moveTo(101.59f, 88.77f)
                curveTo(88.99f, 71.72f, 82.28f, 54.4f, 82.28f, 54.4f)
                curveToRelative(0f, 0f, -6.7f, 17.32f, -19.3f, 34.37f)
                curveTo(50.38f, 105.8f, 34.67f, 116.89f, 34.67f, 116.89f)
                curveTo(34.67f, 116.89f, 50.38f, 127.97f, 62.98f, 145.02f)
                curveTo(75.58f, 162.05f, 82.28f, 179.38f, 82.28f, 179.38f)
                curveTo(82.28f, 179.38f, 88.99f, 162.05f, 101.59f, 145.02f)
                curveTo(114.19f, 127.97f, 129.89f, 116.89f, 129.89f, 116.89f)
                curveTo(129.89f, 116.89f, 114.19f, 105.8f, 101.59f, 88.77f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0.43137255f)
                    ),
                    center = Offset(69.58f, 102.74f),
                    radius = 27.86f
                )
            ) {
                moveToRelative(77.35f, 73.93f)
                curveToRelative(-0f, 0f, 5.97f, 24.17f, -0.57f, 32.62f)
                curveToRelative(-7.35f, 9.49f, -34.4f, 8.59f, -34.4f, 8.59f)
                curveToRelative(-0f, 0f, 16.79f, -9.29f, 22.88f, -16.56f)
                curveToRelative(5.83f, -6.95f, 12.08f, -24.64f, 12.08f, -24.64f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(21.76f, 37.26f)
                curveTo(18.63f, 33.03f, 16.97f, 28.73f, 16.97f, 28.73f)
                curveToRelative(0f, 0f, -1.66f, 4.3f, -4.79f, 8.53f)
                curveTo(9.05f, 41.49f, 5.15f, 44.24f, 5.15f, 44.24f)
                curveTo(5.15f, 44.24f, 9.05f, 46.99f, 12.18f, 51.22f)
                curveTo(15.3f, 55.44f, 16.97f, 59.74f, 16.97f, 59.74f)
                curveTo(16.97f, 59.74f, 18.63f, 55.44f, 21.76f, 51.22f)
                curveTo(24.89f, 46.99f, 28.78f, 44.24f, 28.78f, 44.24f)
                curveTo(28.78f, 44.24f, 24.89f, 41.49f, 21.76f, 37.26f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(155.41f, 191.52f)
                curveTo(152.28f, 187.29f, 150.62f, 183f, 150.62f, 183f)
                curveToRelative(0f, 0f, -1.66f, 4.3f, -4.79f, 8.53f)
                curveTo(142.7f, 195.75f, 138.81f, 198.5f, 138.81f, 198.5f)
                curveTo(138.81f, 198.5f, 142.7f, 201.25f, 145.83f, 205.48f)
                curveTo(148.96f, 209.71f, 150.62f, 214.01f, 150.62f, 214.01f)
                curveTo(150.62f, 214.01f, 152.28f, 209.71f, 155.41f, 205.48f)
                curveTo(158.54f, 201.25f, 162.44f, 198.5f, 162.44f, 198.5f)
                curveTo(162.44f, 198.5f, 158.54f, 195.75f, 155.41f, 191.52f)
                close()
            }
        }.build()

        return _AceOfDiamonds!!
    }

@Suppress("ObjectPropertyName")
private var _AceOfDiamonds: ImageVector? = null
