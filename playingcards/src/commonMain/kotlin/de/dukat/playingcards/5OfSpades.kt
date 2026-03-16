package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`5OfSpades`: ImageVector
    get() {
        if (_5OfSpades != null) {
            return _5OfSpades!!
        }
        _5OfSpades = ImageVector.Builder(
            name = "5OfSpades",
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
                moveToRelative(9.87f, 22.01f)
                lineToRelative(2.95f, -0.25f)
                quadToRelative(0.33f, 2.16f, 1.52f, 3.25f)
                quadToRelative(1.2f, 1.08f, 2.89f, 1.08f)
                quadToRelative(2.03f, 0f, 3.44f, -1.53f)
                quadToRelative(1.41f, -1.53f, 1.41f, -4.06f)
                quadToRelative(0f, -2.41f, -1.36f, -3.8f)
                quadToRelative(-1.34f, -1.39f, -3.53f, -1.39f)
                quadToRelative(-1.36f, 0f, -2.45f, 0.63f)
                quadToRelative(-1.09f, 0.61f, -1.72f, 1.59f)
                lineToRelative(-2.64f, -0.34f)
                lineToRelative(2.22f, -11.77f)
                horizontalLineToRelative(11.39f)
                verticalLineToRelative(2.69f)
                horizontalLineToRelative(-9.14f)
                lineToRelative(-1.23f, 6.16f)
                quadToRelative(2.06f, -1.44f, 4.33f, -1.44f)
                quadToRelative(3f, 0f, 5.06f, 2.08f)
                quadToRelative(2.06f, 2.08f, 2.06f, 5.34f)
                quadToRelative(0f, 3.11f, -1.81f, 5.38f)
                quadToRelative(-2.2f, 2.78f, -6.02f, 2.78f)
                quadToRelative(-3.13f, 0f, -5.11f, -1.75f)
                quadToRelative(-1.97f, -1.75f, -2.25f, -4.64f)
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
                moveTo(77.37f, 56.88f)
                curveTo(76.73f, 47.06f, 56.85f, 28.56f, 56.21f, 23.94f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(62.38f, 74.8f, 57.5f, 60.35f, 58.14f, 58.61f)
                curveTo(59.35f, 59.82f, 62.9f, 66.5f, 68.4f, 66.71f)
                curveTo(72.88f, 66.7f, 77.82f, 63.83f, 77.37f, 56.88f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(157.65f, 221.12f)
                lineToRelative(-2.95f, 0.25f)
                quadToRelative(-0.33f, -2.16f, -1.52f, -3.25f)
                quadToRelative(-1.2f, -1.08f, -2.89f, -1.08f)
                quadToRelative(-2.03f, -0f, -3.44f, 1.53f)
                quadToRelative(-1.41f, 1.53f, -1.41f, 4.06f)
                quadToRelative(-0f, 2.41f, 1.36f, 3.8f)
                quadToRelative(1.34f, 1.39f, 3.53f, 1.39f)
                quadToRelative(1.36f, -0f, 2.45f, -0.63f)
                quadToRelative(1.09f, -0.61f, 1.72f, -1.59f)
                lineToRelative(2.64f, 0.34f)
                lineToRelative(-2.22f, 11.77f)
                lineToRelative(-11.39f, -0f)
                lineToRelative(-0f, -2.69f)
                lineToRelative(9.14f, -0f)
                lineToRelative(1.23f, -6.16f)
                quadToRelative(-2.06f, 1.44f, -4.33f, 1.44f)
                quadToRelative(-3f, -0f, -5.06f, -2.08f)
                quadToRelative(-2.06f, -2.08f, -2.06f, -5.34f)
                quadToRelative(-0f, -3.11f, 1.81f, -5.38f)
                quadToRelative(2.2f, -2.78f, 6.02f, -2.78f)
                quadToRelative(3.13f, -0f, 5.11f, 1.75f)
                quadToRelative(1.97f, 1.75f, 2.25f, 4.64f)
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
                moveTo(35.1f, 186.26f)
                curveTo(35.74f, 196.08f, 55.62f, 214.57f, 56.26f, 219.2f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(50.08f, 168.34f, 54.97f, 182.79f, 54.33f, 184.52f)
                curveTo(53.12f, 183.32f, 49.57f, 176.63f, 44.07f, 176.43f)
                curveTo(39.58f, 176.43f, 34.65f, 179.31f, 35.1f, 186.26f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(104.65f, 126.58f)
                curveTo(104.01f, 116.76f, 84.14f, 98.26f, 83.49f, 93.64f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(89.67f, 144.5f, 84.78f, 130.05f, 85.42f, 128.32f)
                curveTo(86.63f, 129.52f, 90.18f, 136.21f, 95.68f, 136.41f)
                curveTo(100.17f, 136.4f, 105.1f, 133.53f, 104.65f, 126.58f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(131.09f, 57.01f)
                curveTo(130.45f, 47.19f, 110.57f, 28.69f, 109.93f, 24.07f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(116.1f, 74.93f, 111.22f, 60.48f, 111.86f, 58.74f)
                curveTo(113.07f, 59.95f, 116.62f, 66.63f, 122.12f, 66.84f)
                curveTo(126.6f, 66.83f, 131.54f, 63.96f, 131.09f, 57.01f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(88.82f, 186.39f)
                curveTo(89.46f, 196.21f, 109.34f, 214.7f, 109.98f, 219.33f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(103.8f, 168.47f, 108.69f, 182.92f, 108.05f, 184.65f)
                curveTo(106.84f, 183.45f, 103.29f, 176.76f, 97.79f, 176.56f)
                curveTo(93.3f, 176.56f, 88.37f, 179.44f, 88.82f, 186.39f)
                close()
            }
        }.build()

        return _5OfSpades!!
    }

@Suppress("ObjectPropertyName")
private var _5OfSpades: ImageVector? = null
