package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`6OfHearts`: ImageVector
    get() {
        if (_6OfHearts != null) {
            return _6OfHearts!!
        }
        _6OfHearts = ImageVector.Builder(
            name = "6OfHearts",
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
                moveToRelative(24.7f, 10.72f)
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
                moveTo(13.21f, 20.59f)
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
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(23.33f, 32.28f)
                curveTo(17.9f, 32.28f, 17.18f, 37.73f, 17.18f, 37.73f)
                curveTo(17.18f, 37.73f, 16.45f, 32.28f, 11.02f, 32.28f)
                curveTo(7.22f, 32.28f, 3.78f, 34.73f, 3.78f, 39.33f)
                curveTo(3.78f, 45.42f, 14.8f, 51.55f, 17.18f, 60.49f)
                curveTo(19.44f, 51.55f, 30.57f, 45.42f, 30.57f, 39.33f)
                curveTo(30.57f, 34.73f, 27.13f, 32.28f, 23.33f, 32.28f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveToRelative(142.9f, 230.81f)
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
                moveTo(154.38f, 220.94f)
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
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(144f, 209.25f)
                curveTo(149.43f, 209.25f, 150.16f, 203.8f, 150.16f, 203.8f)
                curveTo(150.16f, 203.8f, 150.88f, 209.25f, 156.31f, 209.25f)
                curveTo(160.11f, 209.25f, 163.55f, 206.8f, 163.55f, 202.19f)
                curveTo(163.55f, 196.11f, 152.53f, 189.98f, 150.16f, 181.04f)
                curveTo(147.89f, 189.97f, 136.76f, 196.11f, 136.76f, 202.19f)
                curveTo(136.76f, 206.8f, 140.2f, 209.25f, 144f, 209.25f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(67.93f, 24.2f)
                curveTo(58.92f, 24.2f, 57.71f, 33.24f, 57.71f, 33.24f)
                curveTo(57.71f, 33.24f, 56.51f, 24.2f, 47.5f, 24.2f)
                curveTo(41.19f, 24.2f, 35.48f, 28.25f, 35.48f, 35.9f)
                curveTo(35.48f, 46.01f, 53.76f, 56.17f, 57.71f, 71.01f)
                curveTo(61.47f, 56.18f, 79.94f, 46.01f, 79.94f, 35.9f)
                curveTo(79.94f, 28.25f, 74.24f, 24.2f, 67.93f, 24.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(47.5f, 215.41f)
                curveTo(56.51f, 215.41f, 57.71f, 206.37f, 57.71f, 206.37f)
                curveTo(57.71f, 206.37f, 58.92f, 215.41f, 67.93f, 215.41f)
                curveTo(74.24f, 215.41f, 79.94f, 211.36f, 79.94f, 203.71f)
                curveTo(79.94f, 193.6f, 61.66f, 183.44f, 57.71f, 168.6f)
                curveTo(53.96f, 183.43f, 35.48f, 193.6f, 35.48f, 203.71f)
                curveTo(35.48f, 211.36f, 41.19f, 215.41f, 47.5f, 215.41f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(67.93f, 95.5f)
                curveTo(58.92f, 95.5f, 57.71f, 104.54f, 57.71f, 104.54f)
                curveTo(57.71f, 104.54f, 56.51f, 95.5f, 47.5f, 95.5f)
                curveTo(41.19f, 95.5f, 35.48f, 99.55f, 35.48f, 107.2f)
                curveTo(35.48f, 117.31f, 53.76f, 127.47f, 57.71f, 142.31f)
                curveTo(61.47f, 127.48f, 79.94f, 117.31f, 79.94f, 107.2f)
                curveTo(79.94f, 99.55f, 74.24f, 95.5f, 67.93f, 95.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(119.27f, 23.86f)
                curveTo(110.25f, 23.86f, 109.05f, 32.91f, 109.05f, 32.91f)
                curveTo(109.05f, 32.91f, 107.85f, 23.86f, 98.83f, 23.86f)
                curveTo(92.53f, 23.86f, 86.82f, 27.92f, 86.82f, 35.57f)
                curveTo(86.82f, 45.68f, 105.1f, 55.84f, 109.05f, 70.68f)
                curveTo(112.81f, 55.85f, 131.28f, 45.68f, 131.28f, 35.57f)
                curveTo(131.28f, 27.92f, 125.57f, 23.86f, 119.27f, 23.86f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(98.83f, 215.08f)
                curveTo(107.85f, 215.08f, 109.05f, 206.04f, 109.05f, 206.04f)
                curveTo(109.05f, 206.04f, 110.25f, 215.08f, 119.27f, 215.08f)
                curveTo(125.57f, 215.08f, 131.28f, 211.03f, 131.28f, 203.38f)
                curveTo(131.28f, 193.27f, 113f, 183.11f, 109.05f, 168.27f)
                curveTo(105.29f, 183.1f, 86.82f, 193.27f, 86.82f, 203.38f)
                curveTo(86.82f, 211.03f, 92.53f, 215.08f, 98.83f, 215.08f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(119.27f, 95.17f)
                curveTo(110.25f, 95.17f, 109.05f, 104.21f, 109.05f, 104.21f)
                curveTo(109.05f, 104.21f, 107.85f, 95.17f, 98.83f, 95.17f)
                curveTo(92.53f, 95.17f, 86.82f, 99.22f, 86.82f, 106.87f)
                curveTo(86.82f, 116.98f, 105.1f, 127.14f, 109.05f, 141.98f)
                curveTo(112.81f, 127.15f, 131.28f, 116.98f, 131.28f, 106.87f)
                curveTo(131.28f, 99.22f, 125.57f, 95.17f, 119.27f, 95.17f)
                close()
            }
        }.build()

        return _6OfHearts!!
    }

@Suppress("ObjectPropertyName")
private var _6OfHearts: ImageVector? = null
