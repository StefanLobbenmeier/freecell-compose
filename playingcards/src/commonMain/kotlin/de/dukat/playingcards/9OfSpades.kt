package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`9OfSpades`: ImageVector
    get() {
        if (_9OfSpades != null) {
            return _9OfSpades!!
        }
        _9OfSpades = ImageVector.Builder(
            name = "9OfSpades",
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
                moveToRelative(10.3f, 22.72f)
                lineToRelative(2.7f, -0.25f)
                quadToRelative(0.34f, 1.91f, 1.31f, 2.77f)
                quadToRelative(0.97f, 0.86f, 2.48f, 0.86f)
                quadToRelative(1.3f, 0f, 2.27f, -0.59f)
                quadToRelative(0.98f, -0.59f, 1.61f, -1.58f)
                quadToRelative(0.63f, -1f, 1.05f, -2.69f)
                quadToRelative(0.42f, -1.69f, 0.42f, -3.44f)
                quadToRelative(0f, -0.19f, -0.02f, -0.56f)
                quadToRelative(-0.84f, 1.34f, -2.31f, 2.19f)
                quadToRelative(-1.45f, 0.83f, -3.16f, 0.83f)
                quadToRelative(-2.84f, 0f, -4.81f, -2.06f)
                quadToRelative(-1.97f, -2.06f, -1.97f, -5.44f)
                quadToRelative(0f, -3.48f, 2.05f, -5.61f)
                quadToRelative(2.06f, -2.13f, 5.16f, -2.13f)
                quadToRelative(2.23f, 0f, 4.08f, 1.2f)
                quadToRelative(1.86f, 1.2f, 2.81f, 3.44f)
                quadToRelative(0.97f, 2.22f, 0.97f, 6.44f)
                quadToRelative(0f, 4.39f, -0.95f, 7f)
                quadToRelative(-0.95f, 2.59f, -2.84f, 3.95f)
                quadToRelative(-1.88f, 1.36f, -4.41f, 1.36f)
                quadToRelative(-2.69f, 0f, -4.39f, -1.48f)
                quadToRelative(-1.7f, -1.5f, -2.05f, -4.2f)
                close()
                moveTo(21.81f, 12.61f)
                quadToRelative(0f, -2.42f, -1.3f, -3.84f)
                quadToRelative(-1.28f, -1.42f, -3.09f, -1.42f)
                quadToRelative(-1.88f, 0f, -3.27f, 1.53f)
                quadToRelative(-1.39f, 1.53f, -1.39f, 3.97f)
                quadToRelative(0f, 2.19f, 1.31f, 3.56f)
                quadToRelative(1.33f, 1.36f, 3.27f, 1.36f)
                quadToRelative(1.95f, 0f, 3.2f, -1.36f)
                quadToRelative(1.27f, -1.38f, 1.27f, -3.8f)
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
                moveTo(74.17f, 39.28f)
                curveTo(73.53f, 29.46f, 53.65f, 10.96f, 53.01f, 6.34f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(59.18f, 57.2f, 54.3f, 42.75f, 54.94f, 41.01f)
                curveTo(56.15f, 42.22f, 59.7f, 48.9f, 65.2f, 49.11f)
                curveTo(69.68f, 49.1f, 74.62f, 46.23f, 74.17f, 39.28f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(157.23f, 220.42f)
                lineToRelative(-2.7f, 0.25f)
                quadToRelative(-0.34f, -1.91f, -1.31f, -2.77f)
                quadToRelative(-0.97f, -0.86f, -2.48f, -0.86f)
                quadToRelative(-1.3f, -0f, -2.27f, 0.59f)
                quadToRelative(-0.98f, 0.59f, -1.61f, 1.58f)
                quadToRelative(-0.63f, 1f, -1.05f, 2.69f)
                quadToRelative(-0.42f, 1.69f, -0.42f, 3.44f)
                quadToRelative(-0f, 0.19f, 0.02f, 0.56f)
                quadToRelative(0.84f, -1.34f, 2.31f, -2.19f)
                quadToRelative(1.45f, -0.83f, 3.16f, -0.83f)
                quadToRelative(2.84f, -0f, 4.81f, 2.06f)
                quadToRelative(1.97f, 2.06f, 1.97f, 5.44f)
                quadToRelative(-0f, 3.48f, -2.05f, 5.61f)
                quadToRelative(-2.06f, 2.13f, -5.16f, 2.13f)
                quadToRelative(-2.23f, -0f, -4.08f, -1.2f)
                quadToRelative(-1.86f, -1.2f, -2.81f, -3.44f)
                quadToRelative(-0.97f, -2.22f, -0.97f, -6.44f)
                quadToRelative(-0f, -4.39f, 0.95f, -7f)
                quadToRelative(0.95f, -2.59f, 2.84f, -3.95f)
                quadToRelative(1.88f, -1.36f, 4.41f, -1.36f)
                quadToRelative(2.69f, -0f, 4.39f, 1.48f)
                quadToRelative(1.7f, 1.5f, 2.05f, 4.2f)
                close()
                moveTo(145.71f, 230.53f)
                quadToRelative(-0f, 2.42f, 1.3f, 3.84f)
                quadToRelative(1.28f, 1.42f, 3.09f, 1.42f)
                quadToRelative(1.88f, -0f, 3.27f, -1.53f)
                quadToRelative(1.39f, -1.53f, 1.39f, -3.97f)
                quadToRelative(-0f, -2.19f, -1.31f, -3.56f)
                quadToRelative(-1.33f, -1.36f, -3.27f, -1.36f)
                quadToRelative(-1.95f, -0f, -3.2f, 1.36f)
                quadToRelative(-1.27f, 1.38f, -1.27f, 3.8f)
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
                moveTo(74.5f, 102.21f)
                curveTo(73.86f, 92.39f, 53.98f, 73.9f, 53.34f, 69.27f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(59.51f, 120.13f, 54.62f, 105.68f, 55.27f, 103.95f)
                curveTo(56.48f, 105.15f, 60.03f, 111.84f, 65.53f, 112.04f)
                curveTo(70.01f, 112.04f, 74.95f, 109.16f, 74.5f, 102.21f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(32.63f, 205.15f)
                curveTo(33.27f, 214.97f, 53.15f, 233.47f, 53.79f, 238.09f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(47.62f, 187.23f, 52.5f, 201.68f, 51.86f, 203.42f)
                curveTo(50.65f, 202.21f, 47.1f, 195.53f, 41.6f, 195.32f)
                curveTo(37.12f, 195.33f, 32.18f, 198.2f, 32.63f, 205.15f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(32.3f, 143.82f)
                curveTo(32.94f, 153.64f, 52.82f, 172.13f, 53.46f, 176.76f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(47.29f, 125.9f, 52.18f, 140.35f, 51.53f, 142.08f)
                curveTo(50.32f, 140.88f, 46.77f, 134.19f, 41.27f, 133.99f)
                curveTo(36.79f, 133.99f, 31.85f, 136.87f, 32.3f, 143.82f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(136.14f, 39.09f)
                curveTo(135.5f, 29.27f, 115.62f, 10.78f, 114.98f, 6.15f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(121.15f, 57.01f, 116.26f, 42.56f, 116.9f, 40.83f)
                curveTo(118.11f, 42.03f, 121.66f, 48.72f, 127.16f, 48.92f)
                curveTo(131.65f, 48.92f, 136.59f, 46.04f, 136.14f, 39.09f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(136.47f, 102.03f)
                curveTo(135.83f, 92.2f, 115.95f, 73.71f, 115.31f, 69.08f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(121.48f, 119.94f, 116.59f, 105.49f, 117.23f, 103.76f)
                curveTo(118.44f, 104.96f, 121.99f, 111.65f, 127.49f, 111.85f)
                curveTo(131.98f, 111.85f, 136.91f, 108.97f, 136.47f, 102.03f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(94.6f, 204.96f)
                curveTo(95.24f, 214.79f, 115.12f, 233.28f, 115.76f, 237.9f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(109.59f, 187.05f, 114.47f, 201.49f, 113.83f, 203.23f)
                curveTo(112.62f, 202.03f, 109.07f, 195.34f, 103.57f, 195.14f)
                curveTo(99.08f, 195.14f, 94.15f, 198.02f, 94.6f, 204.96f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(94.27f, 143.63f)
                curveTo(94.91f, 153.45f, 114.79f, 171.95f, 115.43f, 176.57f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(109.26f, 125.71f, 114.14f, 140.16f, 113.5f, 141.89f)
                curveTo(112.29f, 140.69f, 108.74f, 134.01f, 103.24f, 133.8f)
                curveTo(98.75f, 133.81f, 93.82f, 136.68f, 94.27f, 143.63f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(105.31f, 71.69f)
                curveTo(104.67f, 61.86f, 84.79f, 43.37f, 84.15f, 38.74f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(90.32f, 89.6f, 85.44f, 75.15f, 86.08f, 73.42f)
                curveTo(87.29f, 74.62f, 90.84f, 81.31f, 96.34f, 81.51f)
                curveTo(100.83f, 81.51f, 105.76f, 78.63f, 105.31f, 71.69f)
                close()
            }
        }.build()

        return _9OfSpades!!
    }

@Suppress("ObjectPropertyName")
private var _9OfSpades: ImageVector? = null
