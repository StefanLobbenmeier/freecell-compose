package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`9OfHearts`: ImageVector
    get() {
        if (_9OfHearts != null) {
            return _9OfHearts!!
        }
        _9OfHearts = ImageVector.Builder(
            name = "9OfHearts",
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
                moveTo(64.73f, 6.6f)
                curveTo(55.72f, 6.6f, 54.51f, 15.64f, 54.51f, 15.64f)
                curveTo(54.51f, 15.64f, 53.31f, 6.6f, 44.3f, 6.6f)
                curveTo(37.99f, 6.6f, 32.28f, 10.65f, 32.28f, 18.3f)
                curveTo(32.28f, 28.41f, 50.56f, 38.57f, 54.51f, 53.41f)
                curveTo(58.27f, 38.58f, 76.74f, 28.41f, 76.74f, 18.3f)
                curveTo(76.74f, 10.65f, 71.04f, 6.6f, 64.73f, 6.6f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(44.3f, 236.21f)
                curveTo(53.31f, 236.21f, 54.51f, 227.17f, 54.51f, 227.17f)
                curveTo(54.51f, 227.17f, 55.72f, 236.21f, 64.73f, 236.21f)
                curveTo(71.04f, 236.21f, 76.74f, 232.16f, 76.74f, 224.51f)
                curveTo(76.74f, 214.4f, 58.46f, 204.24f, 54.51f, 189.4f)
                curveTo(50.76f, 204.23f, 32.28f, 214.4f, 32.28f, 224.51f)
                curveTo(32.28f, 232.16f, 37.99f, 236.21f, 44.3f, 236.21f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(64.73f, 71.83f)
                curveTo(55.72f, 71.83f, 54.51f, 80.87f, 54.51f, 80.87f)
                curveTo(54.51f, 80.87f, 53.31f, 71.83f, 44.3f, 71.83f)
                curveTo(37.99f, 71.83f, 32.28f, 75.89f, 32.28f, 83.53f)
                curveTo(32.28f, 93.64f, 50.56f, 103.81f, 54.51f, 118.65f)
                curveTo(58.27f, 103.82f, 76.74f, 93.64f, 76.74f, 83.53f)
                curveTo(76.74f, 75.89f, 71.04f, 71.83f, 64.73f, 71.83f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(44.3f, 168.76f)
                curveTo(53.31f, 168.76f, 54.51f, 159.72f, 54.51f, 159.72f)
                curveTo(54.51f, 159.72f, 55.72f, 168.76f, 64.73f, 168.76f)
                curveTo(71.04f, 168.76f, 76.74f, 164.71f, 76.74f, 157.06f)
                curveTo(76.74f, 146.95f, 58.46f, 136.79f, 54.51f, 121.95f)
                curveTo(50.76f, 136.78f, 32.28f, 146.95f, 32.28f, 157.06f)
                curveTo(32.28f, 164.71f, 37.99f, 168.76f, 44.3f, 168.76f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(122.21f, 7.19f)
                curveTo(113.19f, 7.19f, 111.99f, 16.24f, 111.99f, 16.24f)
                curveTo(111.99f, 16.24f, 110.79f, 7.19f, 101.78f, 7.19f)
                curveTo(95.47f, 7.19f, 89.76f, 11.25f, 89.76f, 18.9f)
                curveTo(89.76f, 29.01f, 108.04f, 39.17f, 111.99f, 54.01f)
                curveTo(115.75f, 39.18f, 134.22f, 29.01f, 134.22f, 18.9f)
                curveTo(134.22f, 11.25f, 128.51f, 7.19f, 122.21f, 7.19f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(101.78f, 236.81f)
                curveTo(110.79f, 236.81f, 111.99f, 227.77f, 111.99f, 227.77f)
                curveTo(111.99f, 227.77f, 113.19f, 236.81f, 122.21f, 236.81f)
                curveTo(128.51f, 236.81f, 134.22f, 232.76f, 134.22f, 225.11f)
                curveTo(134.22f, 215f, 115.94f, 204.84f, 111.99f, 190f)
                curveTo(108.23f, 204.83f, 89.76f, 215f, 89.76f, 225.11f)
                curveTo(89.76f, 232.76f, 95.47f, 236.81f, 101.78f, 236.81f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(122.21f, 72.43f)
                curveTo(113.19f, 72.43f, 111.99f, 81.47f, 111.99f, 81.47f)
                curveTo(111.99f, 81.47f, 110.79f, 72.43f, 101.78f, 72.43f)
                curveTo(95.47f, 72.43f, 89.76f, 76.48f, 89.76f, 84.13f)
                curveTo(89.76f, 94.24f, 108.04f, 104.4f, 111.99f, 119.25f)
                curveTo(115.75f, 104.42f, 134.22f, 94.24f, 134.22f, 84.13f)
                curveTo(134.22f, 76.48f, 128.51f, 72.43f, 122.21f, 72.43f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(101.78f, 169.36f)
                curveTo(110.79f, 169.36f, 111.99f, 160.32f, 111.99f, 160.32f)
                curveTo(111.99f, 160.32f, 113.19f, 169.36f, 122.21f, 169.36f)
                curveTo(128.51f, 169.36f, 134.22f, 165.31f, 134.22f, 157.66f)
                curveTo(134.22f, 147.55f, 115.94f, 137.39f, 111.99f, 122.55f)
                curveTo(108.23f, 137.38f, 89.76f, 147.55f, 89.76f, 157.66f)
                curveTo(89.76f, 165.31f, 95.47f, 169.36f, 101.78f, 169.36f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(93.43f, 39.3f)
                curveTo(84.42f, 39.3f, 83.21f, 48.34f, 83.21f, 48.34f)
                curveTo(83.21f, 48.34f, 82.01f, 39.3f, 73f, 39.3f)
                curveTo(66.69f, 39.3f, 60.98f, 43.35f, 60.98f, 51f)
                curveTo(60.98f, 61.11f, 79.26f, 71.27f, 83.21f, 86.11f)
                curveTo(86.97f, 71.28f, 105.45f, 61.11f, 105.45f, 51f)
                curveTo(105.45f, 43.35f, 99.74f, 39.3f, 93.43f, 39.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveToRelative(10.49f, 22.72f)
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
                moveTo(22.01f, 12.61f)
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
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveToRelative(157.07f, 218.81f)
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
                moveTo(145.55f, 228.92f)
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
        }.build()

        return _9OfHearts!!
    }

@Suppress("ObjectPropertyName")
private var _9OfHearts: ImageVector? = null
