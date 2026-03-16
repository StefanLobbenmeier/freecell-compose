package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`3OfHearts`: ImageVector
    get() {
        if (_3OfHearts != null) {
            return _3OfHearts!!
        }
        _3OfHearts = ImageVector.Builder(
            name = "3OfHearts",
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
                moveToRelative(10.12f, 21.97f)
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
                moveToRelative(157.47f, 219.56f)
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
                moveTo(93.53f, 24.2f)
                curveTo(84.52f, 24.2f, 83.31f, 33.24f, 83.31f, 33.24f)
                curveTo(83.31f, 33.24f, 82.11f, 24.2f, 73.1f, 24.2f)
                curveTo(66.79f, 24.2f, 61.08f, 28.25f, 61.08f, 35.9f)
                curveTo(61.08f, 46.01f, 79.36f, 56.17f, 83.31f, 71.01f)
                curveTo(87.07f, 56.18f, 105.54f, 46.01f, 105.54f, 35.9f)
                curveTo(105.54f, 28.25f, 99.84f, 24.2f, 93.53f, 24.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(73.1f, 215.41f)
                curveTo(82.11f, 215.41f, 83.31f, 206.37f, 83.31f, 206.37f)
                curveTo(83.31f, 206.37f, 84.52f, 215.41f, 93.53f, 215.41f)
                curveTo(99.84f, 215.41f, 105.54f, 211.36f, 105.54f, 203.71f)
                curveTo(105.54f, 193.6f, 87.26f, 183.44f, 83.31f, 168.6f)
                curveTo(79.56f, 183.43f, 61.08f, 193.6f, 61.08f, 203.71f)
                curveTo(61.08f, 211.36f, 66.79f, 215.41f, 73.1f, 215.41f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(93.53f, 95.5f)
                curveTo(84.52f, 95.5f, 83.31f, 104.54f, 83.31f, 104.54f)
                curveTo(83.31f, 104.54f, 82.11f, 95.5f, 73.1f, 95.5f)
                curveTo(66.79f, 95.5f, 61.08f, 99.55f, 61.08f, 107.2f)
                curveTo(61.08f, 117.31f, 79.36f, 127.47f, 83.31f, 142.31f)
                curveTo(87.07f, 127.48f, 105.54f, 117.31f, 105.54f, 107.2f)
                curveTo(105.54f, 99.55f, 99.84f, 95.5f, 93.53f, 95.5f)
                close()
            }
        }.build()

        return _3OfHearts!!
    }

@Suppress("ObjectPropertyName")
private var _3OfHearts: ImageVector? = null
