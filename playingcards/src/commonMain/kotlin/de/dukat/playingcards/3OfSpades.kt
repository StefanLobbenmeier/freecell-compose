package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`3OfSpades`: ImageVector
    get() {
        if (_3OfSpades != null) {
            return _3OfSpades!!
        }
        _3OfSpades = ImageVector.Builder(
            name = "3OfSpades",
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
                moveToRelative(9.89f, 21.97f)
                lineToRelative(2.81f, -0.38f)
                quadToRelative(0.48f, 2.39f, 1.64f, 3.45f)
                quadToRelative(1.17f, 1.05f, 2.84f, 1.05f)
                quadToRelative(1.98f, 0f, 3.34f, -1.38f)
                quadToRelative(1.38f, -1.38f, 1.38f, -3.41f)
                quadToRelative(0f, -1.94f, -1.27f, -3.19f)
                quadToRelative(-1.27f, -1.27f, -3.22f, -1.27f)
                quadToRelative(-0.8f, 0f, -1.98f, 0.31f)
                lineToRelative(0.31f, -2.47f)
                quadToRelative(0.28f, 0.03f, 0.45f, 0.03f)
                quadToRelative(1.8f, 0f, 3.23f, -0.94f)
                quadToRelative(1.44f, -0.94f, 1.44f, -2.89f)
                quadToRelative(0f, -1.55f, -1.05f, -2.56f)
                quadToRelative(-1.05f, -1.02f, -2.7f, -1.02f)
                quadToRelative(-1.64f, 0f, -2.73f, 1.03f)
                quadToRelative(-1.09f, 1.03f, -1.41f, 3.09f)
                lineToRelative(-2.81f, -0.5f)
                quadToRelative(0.52f, -2.83f, 2.34f, -4.37f)
                quadToRelative(1.83f, -1.56f, 4.55f, -1.56f)
                quadToRelative(1.88f, 0f, 3.45f, 0.81f)
                quadToRelative(1.58f, 0.8f, 2.41f, 2.19f)
                quadToRelative(0.84f, 1.39f, 0.84f, 2.95f)
                quadToRelative(0f, 1.48f, -0.8f, 2.7f)
                quadToRelative(-0.8f, 1.22f, -2.36f, 1.94f)
                quadToRelative(2.03f, 0.47f, 3.16f, 1.95f)
                quadToRelative(1.13f, 1.47f, 1.13f, 3.69f)
                quadToRelative(0f, 3f, -2.19f, 5.09f)
                quadToRelative(-2.19f, 2.08f, -5.53f, 2.08f)
                quadToRelative(-3.02f, 0f, -5.02f, -1.8f)
                quadToRelative(-1.98f, -1.8f, -2.27f, -4.66f)
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
                moveTo(104.57f, 56.88f)
                curveTo(103.93f, 47.06f, 84.05f, 28.56f, 83.41f, 23.94f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(89.58f, 74.8f, 84.7f, 60.35f, 85.34f, 58.61f)
                curveTo(86.55f, 59.82f, 90.1f, 66.5f, 95.6f, 66.71f)
                curveTo(100.08f, 66.7f, 105.02f, 63.83f, 104.57f, 56.88f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(157.63f, 221.17f)
                lineToRelative(-2.81f, 0.38f)
                quadToRelative(-0.48f, -2.39f, -1.64f, -3.45f)
                quadToRelative(-1.17f, -1.05f, -2.84f, -1.05f)
                quadToRelative(-1.98f, -0f, -3.34f, 1.38f)
                quadToRelative(-1.38f, 1.38f, -1.38f, 3.41f)
                quadToRelative(-0f, 1.94f, 1.27f, 3.19f)
                quadToRelative(1.27f, 1.27f, 3.22f, 1.27f)
                quadToRelative(0.8f, -0f, 1.98f, -0.31f)
                lineToRelative(-0.31f, 2.47f)
                quadToRelative(-0.28f, -0.03f, -0.45f, -0.03f)
                quadToRelative(-1.8f, -0f, -3.23f, 0.94f)
                quadToRelative(-1.44f, 0.94f, -1.44f, 2.89f)
                quadToRelative(-0f, 1.55f, 1.05f, 2.56f)
                quadToRelative(1.05f, 1.02f, 2.7f, 1.02f)
                quadToRelative(1.64f, -0f, 2.73f, -1.03f)
                quadToRelative(1.09f, -1.03f, 1.41f, -3.09f)
                lineToRelative(2.81f, 0.5f)
                quadToRelative(-0.52f, 2.83f, -2.34f, 4.38f)
                quadToRelative(-1.83f, 1.56f, -4.55f, 1.56f)
                quadToRelative(-1.88f, -0f, -3.45f, -0.81f)
                quadToRelative(-1.58f, -0.8f, -2.41f, -2.19f)
                quadToRelative(-0.84f, -1.39f, -0.84f, -2.95f)
                quadToRelative(-0f, -1.48f, 0.8f, -2.7f)
                quadToRelative(0.8f, -1.22f, 2.36f, -1.94f)
                quadToRelative(-2.03f, -0.47f, -3.16f, -1.95f)
                quadToRelative(-1.13f, -1.47f, -1.13f, -3.69f)
                quadToRelative(-0f, -3f, 2.19f, -5.09f)
                quadToRelative(2.19f, -2.08f, 5.53f, -2.08f)
                quadToRelative(3.02f, -0f, 5.02f, 1.8f)
                quadToRelative(1.98f, 1.8f, 2.27f, 4.66f)
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
                moveTo(62.3f, 186.26f)
                curveTo(62.94f, 196.08f, 82.82f, 214.57f, 83.46f, 219.2f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(77.28f, 168.34f, 82.17f, 182.79f, 81.53f, 184.52f)
                curveTo(80.32f, 183.32f, 76.77f, 176.63f, 71.27f, 176.43f)
                curveTo(66.78f, 176.43f, 61.85f, 179.31f, 62.3f, 186.26f)
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
        }.build()

        return _3OfSpades!!
    }

@Suppress("ObjectPropertyName")
private var _3OfSpades: ImageVector? = null
