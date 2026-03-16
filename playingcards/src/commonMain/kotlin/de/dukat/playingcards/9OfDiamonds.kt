package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`9OfDiamonds`: ImageVector
    get() {
        if (_9OfDiamonds != null) {
            return _9OfDiamonds!!
        }
        _9OfDiamonds = ImageVector.Builder(
            name = "9OfDiamonds",
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
                moveToRelative(9.6f, 21.12f)
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
                moveTo(21.11f, 11.01f)
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
                moveToRelative(157.74f, 222.01f)
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
                moveTo(146.22f, 232.12f)
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
                moveTo(62.52f, 198.68f)
                curveTo(57.04f, 191.27f, 54.13f, 183.74f, 54.13f, 183.74f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(40.25f, 206.09f, 33.42f, 210.91f, 33.42f, 210.91f)
                curveTo(33.42f, 210.91f, 40.25f, 215.73f, 45.73f, 223.15f)
                curveTo(51.21f, 230.56f, 54.13f, 238.09f, 54.13f, 238.09f)
                curveTo(54.13f, 238.09f, 57.04f, 230.56f, 62.52f, 223.15f)
                curveTo(68.01f, 215.73f, 74.84f, 210.91f, 74.84f, 210.91f)
                curveTo(74.84f, 210.91f, 68.01f, 206.09f, 62.52f, 198.68f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(62.52f, 19.39f)
                curveTo(57.04f, 11.98f, 54.13f, 4.44f, 54.13f, 4.44f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(40.25f, 26.8f, 33.42f, 31.62f, 33.42f, 31.62f)
                curveTo(33.42f, 31.62f, 40.25f, 36.44f, 45.73f, 43.85f)
                curveTo(51.21f, 51.26f, 54.13f, 58.8f, 54.13f, 58.8f)
                curveTo(54.13f, 58.8f, 57.04f, 51.26f, 62.52f, 43.85f)
                curveTo(68.01f, 36.44f, 74.84f, 31.62f, 74.84f, 31.62f)
                curveTo(74.84f, 31.62f, 68.01f, 26.8f, 62.52f, 19.39f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(62.52f, 138.95f)
                curveTo(57.04f, 131.54f, 54.13f, 124.01f, 54.13f, 124.01f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(40.25f, 146.36f, 33.42f, 151.18f, 33.42f, 151.18f)
                curveTo(33.42f, 151.18f, 40.25f, 156f, 45.73f, 163.42f)
                curveTo(51.21f, 170.83f, 54.13f, 178.36f, 54.13f, 178.36f)
                curveTo(54.13f, 178.36f, 57.04f, 170.83f, 62.52f, 163.42f)
                curveTo(68.01f, 156f, 74.84f, 151.18f, 74.84f, 151.18f)
                curveTo(74.84f, 151.18f, 68.01f, 146.36f, 62.52f, 138.95f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(62.52f, 79.12f)
                curveTo(57.04f, 71.71f, 54.13f, 64.17f, 54.13f, 64.17f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(40.25f, 86.53f, 33.42f, 91.35f, 33.42f, 91.35f)
                curveTo(33.42f, 91.35f, 40.25f, 96.17f, 45.73f, 103.58f)
                curveTo(51.21f, 110.99f, 54.13f, 118.53f, 54.13f, 118.53f)
                curveTo(54.13f, 118.53f, 57.04f, 110.99f, 62.52f, 103.58f)
                curveTo(68.01f, 96.17f, 74.84f, 91.35f, 74.84f, 91.35f)
                curveTo(74.84f, 91.35f, 68.01f, 86.53f, 62.52f, 79.12f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(121.29f, 198.68f)
                curveTo(115.81f, 191.27f, 112.9f, 183.74f, 112.9f, 183.74f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(99.02f, 206.09f, 92.19f, 210.91f, 92.19f, 210.91f)
                curveTo(92.19f, 210.91f, 99.02f, 215.73f, 104.5f, 223.15f)
                curveTo(109.98f, 230.56f, 112.9f, 238.09f, 112.9f, 238.09f)
                curveTo(112.9f, 238.09f, 115.81f, 230.56f, 121.29f, 223.15f)
                curveTo(126.77f, 215.73f, 133.6f, 210.91f, 133.6f, 210.91f)
                curveTo(133.6f, 210.91f, 126.77f, 206.09f, 121.29f, 198.68f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(121.29f, 19.39f)
                curveTo(115.81f, 11.98f, 112.9f, 4.44f, 112.9f, 4.44f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(99.02f, 26.8f, 92.19f, 31.62f, 92.19f, 31.62f)
                curveTo(92.19f, 31.62f, 99.02f, 36.44f, 104.5f, 43.85f)
                curveTo(109.98f, 51.26f, 112.9f, 58.8f, 112.9f, 58.8f)
                curveTo(112.9f, 58.8f, 115.81f, 51.26f, 121.29f, 43.85f)
                curveTo(126.77f, 36.44f, 133.6f, 31.62f, 133.6f, 31.62f)
                curveTo(133.6f, 31.62f, 126.77f, 26.8f, 121.29f, 19.39f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(121.29f, 138.95f)
                curveTo(115.81f, 131.54f, 112.9f, 124.01f, 112.9f, 124.01f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(99.02f, 146.36f, 92.19f, 151.18f, 92.19f, 151.18f)
                curveTo(92.19f, 151.18f, 99.02f, 156f, 104.5f, 163.42f)
                curveTo(109.98f, 170.83f, 112.9f, 178.36f, 112.9f, 178.36f)
                curveTo(112.9f, 178.36f, 115.81f, 170.83f, 121.29f, 163.42f)
                curveTo(126.77f, 156f, 133.6f, 151.18f, 133.6f, 151.18f)
                curveTo(133.6f, 151.18f, 126.77f, 146.36f, 121.29f, 138.95f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(121.29f, 79.12f)
                curveTo(115.81f, 71.71f, 112.9f, 64.17f, 112.9f, 64.17f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(99.02f, 86.53f, 92.19f, 91.35f, 92.19f, 91.35f)
                curveTo(92.19f, 91.35f, 99.02f, 96.17f, 104.5f, 103.58f)
                curveTo(109.98f, 110.99f, 112.9f, 118.53f, 112.9f, 118.53f)
                curveTo(112.9f, 118.53f, 115.81f, 110.99f, 121.29f, 103.58f)
                curveTo(126.77f, 96.17f, 133.6f, 91.35f, 133.6f, 91.35f)
                curveTo(133.6f, 91.35f, 126.77f, 86.53f, 121.29f, 79.12f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(91.61f, 49.6f)
                curveTo(86.13f, 42.19f, 83.21f, 34.65f, 83.21f, 34.65f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(69.34f, 57.01f, 62.51f, 61.83f, 62.51f, 61.83f)
                curveTo(62.51f, 61.83f, 69.34f, 66.65f, 74.82f, 74.06f)
                curveTo(80.3f, 81.47f, 83.21f, 89.01f, 83.21f, 89.01f)
                curveTo(83.21f, 89.01f, 86.13f, 81.47f, 91.61f, 74.06f)
                curveTo(97.09f, 66.65f, 103.92f, 61.83f, 103.92f, 61.83f)
                curveTo(103.92f, 61.83f, 97.09f, 57.01f, 91.61f, 49.6f)
                close()
            }
        }.build()

        return _9OfDiamonds!!
    }

@Suppress("ObjectPropertyName")
private var _9OfDiamonds: ImageVector? = null
