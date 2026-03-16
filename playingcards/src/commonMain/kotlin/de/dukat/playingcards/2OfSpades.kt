package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`2OfSpades`: ImageVector
    get() {
        if (_2OfSpades != null) {
            return _2OfSpades!!
        }
        _2OfSpades = ImageVector.Builder(
            name = "2OfSpades",
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
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(24.66f, 25.31f)
                verticalLineToRelative(2.7f)
                horizontalLineTo(9.52f)
                quadToRelative(-0.03f, -1.02f, 0.33f, -1.95f)
                quadToRelative(0.58f, -1.55f, 1.84f, -3.05f)
                quadToRelative(1.28f, -1.5f, 3.69f, -3.47f)
                quadToRelative(3.73f, -3.06f, 5.05f, -4.84f)
                quadToRelative(1.31f, -1.8f, 1.31f, -3.39f)
                quadToRelative(0f, -1.67f, -1.2f, -2.81f)
                quadToRelative(-1.19f, -1.16f, -3.11f, -1.16f)
                quadToRelative(-2.03f, 0f, -3.25f, 1.22f)
                quadToRelative(-1.22f, 1.22f, -1.23f, 3.37f)
                lineToRelative(-2.89f, -0.3f)
                quadToRelative(0.3f, -3.23f, 2.23f, -4.92f)
                quadToRelative(1.94f, -1.7f, 5.2f, -1.7f)
                quadToRelative(3.3f, 0f, 5.22f, 1.83f)
                quadToRelative(1.92f, 1.83f, 1.92f, 4.53f)
                quadToRelative(0f, 1.38f, -0.56f, 2.7f)
                quadToRelative(-0.56f, 1.33f, -1.88f, 2.8f)
                quadToRelative(-1.3f, 1.47f, -4.33f, 4.03f)
                quadToRelative(-2.53f, 2.13f, -3.25f, 2.89f)
                quadToRelative(-0.72f, 0.75f, -1.19f, 1.52f)
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
            path(fill = SolidColor(Color.Black)) {
                moveTo(104.57f, 64.88f)
                curveTo(103.93f, 55.06f, 84.05f, 36.56f, 83.41f, 31.94f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(89.58f, 82.8f, 84.7f, 68.35f, 85.34f, 66.61f)
                curveTo(86.55f, 67.82f, 90.1f, 74.5f, 95.6f, 74.71f)
                curveTo(100.08f, 74.7f, 105.02f, 71.83f, 104.57f, 64.88f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(142.87f, 217.83f)
                lineToRelative(-0f, -2.7f)
                lineTo(158.01f, 215.12f)
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
            path(fill = SolidColor(Color.Black)) {
                moveTo(138.17f, 193.76f)
                curveTo(138.54f, 199.36f, 149.86f, 209.89f, 150.23f, 212.53f)
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
                moveTo(62.3f, 178.26f)
                curveTo(62.94f, 188.08f, 82.82f, 206.57f, 83.46f, 211.2f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(77.28f, 160.34f, 82.17f, 174.79f, 81.53f, 176.52f)
                curveTo(80.32f, 175.32f, 76.77f, 168.63f, 71.27f, 168.43f)
                curveTo(66.78f, 168.43f, 61.85f, 171.31f, 62.3f, 178.26f)
                close()
            }
        }.build()

        return _2OfSpades!!
    }

@Suppress("ObjectPropertyName")
private var _2OfSpades: ImageVector? = null
