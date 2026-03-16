package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`6OfSpades`: ImageVector
    get() {
        if (_6OfSpades != null) {
            return _6OfSpades!!
        }
        _6OfSpades = ImageVector.Builder(
            name = "6OfSpades",
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
                moveToRelative(24.47f, 10.72f)
                lineToRelative(-2.8f, 0.22f)
                quadToRelative(-0.38f, -1.66f, -1.06f, -2.41f)
                quadToRelative(-1.14f, -1.2f, -2.81f, -1.2f)
                quadToRelative(-1.34f, 0f, -2.36f, 0.75f)
                quadToRelative(-1.33f, 0.97f, -2.09f, 2.83f)
                quadToRelative(-0.77f, 1.86f, -0.8f, 5.3f)
                quadToRelative(1.02f, -1.55f, 2.48f, -2.3f)
                quadToRelative(1.47f, -0.75f, 3.08f, -0.75f)
                quadToRelative(2.81f, 0f, 4.78f, 2.08f)
                quadToRelative(1.98f, 2.06f, 1.98f, 5.34f)
                quadToRelative(0f, 2.16f, -0.94f, 4.02f)
                quadToRelative(-0.92f, 1.84f, -2.55f, 2.83f)
                quadToRelative(-1.63f, 0.98f, -3.69f, 0.98f)
                quadToRelative(-3.52f, 0f, -5.73f, -2.58f)
                quadToRelative(-2.22f, -2.59f, -2.22f, -8.53f)
                quadToRelative(0f, -6.64f, 2.45f, -9.66f)
                quadToRelative(2.14f, -2.63f, 5.77f, -2.63f)
                quadToRelative(2.7f, 0f, 4.42f, 1.52f)
                quadToRelative(1.73f, 1.52f, 2.08f, 4.19f)
                close()
                moveTo(12.98f, 20.59f)
                quadToRelative(0f, 1.45f, 0.61f, 2.78f)
                quadToRelative(0.63f, 1.33f, 1.73f, 2.03f)
                quadToRelative(1.11f, 0.69f, 2.33f, 0.69f)
                quadToRelative(1.78f, 0f, 3.06f, -1.44f)
                quadToRelative(1.28f, -1.44f, 1.28f, -3.91f)
                quadToRelative(0f, -2.38f, -1.27f, -3.73f)
                quadToRelative(-1.27f, -1.38f, -3.19f, -1.38f)
                quadToRelative(-1.91f, 0f, -3.23f, 1.38f)
                quadToRelative(-1.33f, 1.36f, -1.33f, 3.58f)
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
                moveToRelative(143.06f, 232.42f)
                lineToRelative(2.8f, -0.22f)
                quadToRelative(0.38f, 1.66f, 1.06f, 2.41f)
                quadToRelative(1.14f, 1.2f, 2.81f, 1.2f)
                quadToRelative(1.34f, -0f, 2.36f, -0.75f)
                quadToRelative(1.33f, -0.97f, 2.09f, -2.83f)
                quadToRelative(0.77f, -1.86f, 0.8f, -5.3f)
                quadToRelative(-1.02f, 1.55f, -2.48f, 2.3f)
                quadToRelative(-1.47f, 0.75f, -3.08f, 0.75f)
                quadToRelative(-2.81f, -0f, -4.78f, -2.08f)
                quadToRelative(-1.98f, -2.06f, -1.98f, -5.34f)
                quadToRelative(-0f, -2.16f, 0.94f, -4.02f)
                quadToRelative(0.92f, -1.84f, 2.55f, -2.83f)
                quadToRelative(1.63f, -0.98f, 3.69f, -0.98f)
                quadToRelative(3.52f, -0f, 5.73f, 2.58f)
                quadToRelative(2.22f, 2.59f, 2.22f, 8.53f)
                quadToRelative(-0f, 6.64f, -2.45f, 9.66f)
                quadToRelative(-2.14f, 2.63f, -5.77f, 2.63f)
                quadToRelative(-2.7f, -0f, -4.42f, -1.52f)
                quadToRelative(-1.73f, -1.52f, -2.08f, -4.19f)
                close()
                moveTo(154.54f, 222.55f)
                quadToRelative(-0f, -1.45f, -0.61f, -2.78f)
                quadToRelative(-0.63f, -1.33f, -1.73f, -2.03f)
                quadToRelative(-1.11f, -0.69f, -2.33f, -0.69f)
                quadToRelative(-1.78f, -0f, -3.06f, 1.44f)
                quadToRelative(-1.28f, 1.44f, -1.28f, 3.91f)
                quadToRelative(-0f, 2.38f, 1.27f, 3.73f)
                quadToRelative(1.27f, 1.38f, 3.19f, 1.38f)
                quadToRelative(1.91f, -0f, 3.23f, -1.38f)
                quadToRelative(1.33f, -1.36f, 1.33f, -3.58f)
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
                moveTo(77.45f, 126.58f)
                curveTo(76.81f, 116.76f, 56.94f, 98.26f, 56.29f, 93.64f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(62.47f, 144.5f, 57.58f, 130.05f, 58.22f, 128.32f)
                curveTo(59.43f, 129.52f, 62.98f, 136.21f, 68.48f, 136.41f)
                curveTo(72.97f, 136.4f, 77.9f, 133.53f, 77.45f, 126.58f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(132.06f, 56.68f)
                curveTo(131.42f, 46.86f, 111.54f, 28.36f, 110.9f, 23.74f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(117.07f, 74.6f, 112.18f, 60.15f, 112.82f, 58.42f)
                curveTo(114.03f, 59.62f, 117.58f, 66.3f, 123.08f, 66.51f)
                curveTo(127.57f, 66.5f, 132.51f, 63.63f, 132.06f, 56.68f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(89.78f, 186.06f)
                curveTo(90.42f, 195.88f, 110.3f, 214.37f, 110.94f, 219f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(104.77f, 168.14f, 109.66f, 182.59f, 109.02f, 184.32f)
                curveTo(107.81f, 183.12f, 104.26f, 176.43f, 98.76f, 176.23f)
                curveTo(94.27f, 176.24f, 89.34f, 179.11f, 89.78f, 186.06f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(132.14f, 126.38f)
                curveTo(131.5f, 116.56f, 111.62f, 98.07f, 110.98f, 93.44f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(117.15f, 144.3f, 112.27f, 129.85f, 112.91f, 128.12f)
                curveTo(114.12f, 129.32f, 117.67f, 136.01f, 123.17f, 136.21f)
                curveTo(127.66f, 136.21f, 132.59f, 133.33f, 132.14f, 126.38f)
                close()
            }
        }.build()

        return _6OfSpades!!
    }

@Suppress("ObjectPropertyName")
private var _6OfSpades: ImageVector? = null
