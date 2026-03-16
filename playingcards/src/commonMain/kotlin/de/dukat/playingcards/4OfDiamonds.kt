package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`4OfDiamonds`: ImageVector
    get() {
        if (_4OfDiamonds != null) {
            return _4OfDiamonds!!
        }
        _4OfDiamonds = ImageVector.Builder(
            name = "4OfDiamonds",
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
                moveTo(18.19f, 26.41f)
                lineTo(18.19f, 20.93f)
                lineTo(8.25f, 20.93f)
                lineTo(8.25f, 18.35f)
                lineTo(18.71f, 3.51f)
                horizontalLineToRelative(2.3f)
                lineTo(21f, 18.35f)
                horizontalLineToRelative(3.09f)
                verticalLineToRelative(2.58f)
                horizontalLineToRelative(-3.09f)
                verticalLineToRelative(5.48f)
                close()
                moveTo(18.19f, 18.35f)
                lineTo(18.19f, 8.02f)
                lineTo(11.02f, 18.35f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveToRelative(149.14f, 216.72f)
                lineToRelative(-0f, 5.48f)
                lineToRelative(9.94f, -0f)
                lineToRelative(-0f, 2.58f)
                lineToRelative(-10.45f, 14.84f)
                lineToRelative(-2.3f, -0f)
                lineToRelative(-0f, -14.84f)
                lineToRelative(-3.09f, -0f)
                lineToRelative(-0f, -2.58f)
                lineToRelative(3.09f, -0f)
                lineToRelative(-0f, -5.48f)
                close()
                moveTo(149.14f, 224.78f)
                lineToRelative(-0f, 10.33f)
                lineToRelative(7.17f, -10.33f)
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
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(120.6f, 171.79f)
                curveTo(115.12f, 164.38f, 112.21f, 156.84f, 112.21f, 156.84f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(98.33f, 179.2f, 91.5f, 184.02f, 91.5f, 184.02f)
                curveTo(91.5f, 184.02f, 98.33f, 188.84f, 103.81f, 196.26f)
                curveTo(109.29f, 203.67f, 112.21f, 211.2f, 112.21f, 211.2f)
                curveTo(112.21f, 211.2f, 115.12f, 203.67f, 120.6f, 196.26f)
                curveTo(126.08f, 188.84f, 132.91f, 184.02f, 132.91f, 184.02f)
                curveTo(132.91f, 184.02f, 126.08f, 179.2f, 120.6f, 171.79f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(120.6f, 43.39f)
                curveTo(115.12f, 35.98f, 112.21f, 28.44f, 112.21f, 28.44f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(98.33f, 50.8f, 91.5f, 55.62f, 91.5f, 55.62f)
                curveTo(91.5f, 55.62f, 98.33f, 60.44f, 103.81f, 67.85f)
                curveTo(109.29f, 75.26f, 112.21f, 82.8f, 112.21f, 82.8f)
                curveTo(112.21f, 82.8f, 115.12f, 75.26f, 120.6f, 67.85f)
                curveTo(126.08f, 60.44f, 132.91f, 55.62f, 132.91f, 55.62f)
                curveTo(132.91f, 55.62f, 126.08f, 50.8f, 120.6f, 43.39f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(62.52f, 171.79f)
                curveTo(57.04f, 164.38f, 54.13f, 156.84f, 54.13f, 156.84f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(40.25f, 179.2f, 33.42f, 184.02f, 33.42f, 184.02f)
                curveTo(33.42f, 184.02f, 40.25f, 188.84f, 45.73f, 196.26f)
                curveTo(51.21f, 203.67f, 54.13f, 211.2f, 54.13f, 211.2f)
                curveTo(54.13f, 211.2f, 57.04f, 203.67f, 62.52f, 196.26f)
                curveTo(68.01f, 188.84f, 74.84f, 184.02f, 74.84f, 184.02f)
                curveTo(74.84f, 184.02f, 68.01f, 179.2f, 62.52f, 171.79f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(62.52f, 43.39f)
                curveTo(57.04f, 35.98f, 54.13f, 28.44f, 54.13f, 28.44f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(40.25f, 50.8f, 33.42f, 55.62f, 33.42f, 55.62f)
                curveTo(33.42f, 55.62f, 40.25f, 60.44f, 45.73f, 67.85f)
                curveTo(51.21f, 75.26f, 54.13f, 82.8f, 54.13f, 82.8f)
                curveTo(54.13f, 82.8f, 57.04f, 75.26f, 62.52f, 67.85f)
                curveTo(68.01f, 60.44f, 74.84f, 55.62f, 74.84f, 55.62f)
                curveTo(74.84f, 55.62f, 68.01f, 50.8f, 62.52f, 43.39f)
                close()
            }
        }.build()

        return _4OfDiamonds!!
    }

@Suppress("ObjectPropertyName")
private var _4OfDiamonds: ImageVector? = null
