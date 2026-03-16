package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`4OfSpades`: ImageVector
    get() {
        if (_4OfSpades != null) {
            return _4OfSpades!!
        }
        _4OfSpades = ImageVector.Builder(
            name = "4OfSpades",
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
                moveTo(18.89f, 28.01f)
                lineTo(18.89f, 22.53f)
                lineTo(8.95f, 22.53f)
                lineTo(8.95f, 19.95f)
                lineTo(19.41f, 5.11f)
                horizontalLineToRelative(2.3f)
                lineTo(21.7f, 19.95f)
                horizontalLineToRelative(3.09f)
                verticalLineToRelative(2.58f)
                horizontalLineToRelative(-3.09f)
                verticalLineToRelative(5.48f)
                close()
                moveTo(18.89f, 19.95f)
                lineTo(18.89f, 9.62f)
                lineTo(11.72f, 19.95f)
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
                moveTo(75.77f, 64.88f)
                curveTo(75.13f, 55.06f, 55.25f, 36.56f, 54.61f, 31.94f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(60.78f, 82.8f, 55.9f, 68.35f, 56.54f, 66.61f)
                curveTo(57.75f, 67.82f, 61.3f, 74.5f, 66.8f, 74.71f)
                curveTo(71.28f, 74.7f, 76.22f, 71.83f, 75.77f, 64.88f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(148.63f, 215.12f)
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
                moveTo(148.63f, 223.19f)
                lineToRelative(-0f, 10.33f)
                lineToRelative(7.17f, -10.33f)
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
                moveTo(33.5f, 178.26f)
                curveTo(34.14f, 188.08f, 54.02f, 206.57f, 54.66f, 211.2f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(48.48f, 160.34f, 53.37f, 174.79f, 52.73f, 176.52f)
                curveTo(51.52f, 175.32f, 47.97f, 168.63f, 42.47f, 168.43f)
                curveTo(37.98f, 168.43f, 33.05f, 171.31f, 33.5f, 178.26f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(133.85f, 64.87f)
                curveTo(133.21f, 55.04f, 113.33f, 36.55f, 112.69f, 31.93f)
                curveToRelative(-0.64f, 4.62f, -20.52f, 23.12f, -21.16f, 32.94f)
                curveToRelative(-0.45f, 6.95f, 4.49f, 9.82f, 8.98f, 9.82f)
                curveToRelative(4.86f, -0.05f, 8.88f, -6.78f, 10.26f, -8.09f)
                curveToRelative(0.64f, 1.73f, -4.25f, 16.18f, -5.77f, 16.18f)
                lineToRelative(15.39f, 0f)
                curveTo(118.86f, 82.78f, 113.97f, 68.34f, 114.61f, 66.6f)
                curveTo(115.82f, 67.8f, 119.37f, 74.49f, 124.87f, 74.69f)
                curveTo(129.36f, 74.69f, 134.3f, 71.81f, 133.85f, 64.87f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(91.57f, 178.25f)
                curveTo(92.21f, 188.07f, 112.09f, 206.56f, 112.73f, 211.19f)
                curveToRelative(0.64f, -4.62f, 20.52f, -23.12f, 21.16f, -32.94f)
                curveToRelative(0.45f, -6.95f, -4.49f, -9.82f, -8.98f, -9.82f)
                curveToRelative(-4.86f, 0.05f, -8.88f, 6.78f, -10.26f, 8.09f)
                curveToRelative(-0.64f, -1.73f, 4.25f, -16.18f, 5.77f, -16.18f)
                lineToRelative(-15.39f, -0f)
                curveTo(106.56f, 160.33f, 111.45f, 174.78f, 110.81f, 176.51f)
                curveTo(109.6f, 175.31f, 106.05f, 168.62f, 100.55f, 168.42f)
                curveTo(96.06f, 168.42f, 91.13f, 171.3f, 91.57f, 178.25f)
                close()
            }
        }.build()

        return _4OfSpades!!
    }

@Suppress("ObjectPropertyName")
private var _4OfSpades: ImageVector? = null
