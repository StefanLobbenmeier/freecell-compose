package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`2OfDiamonds`: ImageVector
    get() {
        if (_2OfDiamonds != null) {
            return _2OfDiamonds!!
        }
        _2OfDiamonds = ImageVector.Builder(
            name = "2OfDiamonds",
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
                moveToRelative(23.96f, 23.71f)
                verticalLineToRelative(2.7f)
                horizontalLineTo(8.81f)
                quadToRelative(-0.03f, -1.02f, 0.33f, -1.95f)
                quadToRelative(0.58f, -1.55f, 1.84f, -3.05f)
                quadToRelative(1.28f, -1.5f, 3.69f, -3.47f)
                quadToRelative(3.73f, -3.06f, 5.05f, -4.84f)
                quadToRelative(1.31f, -1.8f, 1.31f, -3.39f)
                quadToRelative(0f, -1.67f, -1.2f, -2.81f)
                quadToRelative(-1.19f, -1.16f, -3.11f, -1.16f)
                quadToRelative(-2.03f, 0f, -3.25f, 1.22f)
                quadToRelative(-1.22f, 1.22f, -1.23f, 3.38f)
                lineTo(9.35f, 10.04f)
                quadToRelative(0.3f, -3.23f, 2.23f, -4.92f)
                quadToRelative(1.94f, -1.7f, 5.2f, -1.7f)
                quadToRelative(3.3f, 0f, 5.22f, 1.83f)
                quadToRelative(1.92f, 1.83f, 1.92f, 4.53f)
                quadToRelative(0f, 1.37f, -0.56f, 2.7f)
                quadToRelative(-0.56f, 1.33f, -1.88f, 2.8f)
                quadToRelative(-1.3f, 1.47f, -4.33f, 4.03f)
                quadToRelative(-2.53f, 2.13f, -3.25f, 2.89f)
                quadToRelative(-0.72f, 0.75f, -1.19f, 1.52f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveToRelative(143.38f, 219.42f)
                lineToRelative(-0f, -2.7f)
                lineToRelative(15.14f, -0f)
                quadToRelative(0.03f, 1.02f, -0.33f, 1.95f)
                quadToRelative(-0.58f, 1.55f, -1.84f, 3.05f)
                quadToRelative(-1.28f, 1.5f, -3.69f, 3.47f)
                quadToRelative(-3.73f, 3.06f, -5.05f, 4.84f)
                quadToRelative(-1.31f, 1.8f, -1.31f, 3.39f)
                quadToRelative(-0f, 1.67f, 1.2f, 2.81f)
                quadToRelative(1.19f, 1.16f, 3.11f, 1.16f)
                quadToRelative(2.03f, -0f, 3.25f, -1.22f)
                quadToRelative(1.22f, -1.22f, 1.23f, -3.38f)
                lineToRelative(2.89f, 0.3f)
                quadToRelative(-0.3f, 3.23f, -2.23f, 4.92f)
                quadToRelative(-1.94f, 1.7f, -5.2f, 1.7f)
                quadToRelative(-3.3f, -0f, -5.22f, -1.83f)
                quadToRelative(-1.92f, -1.83f, -1.92f, -4.53f)
                quadToRelative(-0f, -1.38f, 0.56f, -2.7f)
                quadToRelative(0.56f, -1.33f, 1.88f, -2.8f)
                quadToRelative(1.3f, -1.47f, 4.33f, -4.03f)
                quadToRelative(2.53f, -2.13f, 3.25f, -2.89f)
                quadToRelative(0.72f, -0.75f, 1.19f, -1.52f)
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
                moveTo(91.32f, 171.79f)
                curveTo(85.84f, 164.38f, 82.93f, 156.84f, 82.93f, 156.84f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(69.05f, 179.2f, 62.22f, 184.02f, 62.22f, 184.02f)
                curveTo(62.22f, 184.02f, 69.05f, 188.84f, 74.53f, 196.26f)
                curveTo(80.01f, 203.67f, 82.93f, 211.2f, 82.93f, 211.2f)
                curveTo(82.93f, 211.2f, 85.84f, 203.67f, 91.32f, 196.26f)
                curveTo(96.81f, 188.84f, 103.64f, 184.02f, 103.64f, 184.02f)
                curveTo(103.64f, 184.02f, 96.81f, 179.2f, 91.32f, 171.79f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(91.32f, 43.39f)
                curveTo(85.84f, 35.98f, 82.93f, 28.44f, 82.93f, 28.44f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(69.05f, 50.8f, 62.22f, 55.62f, 62.22f, 55.62f)
                curveTo(62.22f, 55.62f, 69.05f, 60.44f, 74.53f, 67.85f)
                curveTo(80.01f, 75.26f, 82.93f, 82.8f, 82.93f, 82.8f)
                curveTo(82.93f, 82.8f, 85.84f, 75.26f, 91.32f, 67.85f)
                curveTo(96.81f, 60.44f, 103.64f, 55.62f, 103.64f, 55.62f)
                curveTo(103.64f, 55.62f, 96.81f, 50.8f, 91.32f, 43.39f)
                close()
            }
        }.build()

        return _2OfDiamonds!!
    }

@Suppress("ObjectPropertyName")
private var _2OfDiamonds: ImageVector? = null
