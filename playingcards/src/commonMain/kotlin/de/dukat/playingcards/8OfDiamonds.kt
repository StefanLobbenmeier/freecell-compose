package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`8OfDiamonds`: ImageVector
    get() {
        if (_8OfDiamonds != null) {
            return _8OfDiamonds!!
        }
        _8OfDiamonds = ImageVector.Builder(
            name = "8OfDiamonds",
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
                moveToRelative(13.5f, 13.99f)
                quadToRelative(-1.75f, -0.64f, -2.59f, -1.83f)
                quadToRelative(-0.84f, -1.19f, -0.84f, -2.84f)
                quadToRelative(0f, -2.5f, 1.8f, -4.2f)
                quadToRelative(1.8f, -1.7f, 4.78f, -1.7f)
                quadToRelative(3f, 0f, 4.83f, 1.75f)
                quadToRelative(1.83f, 1.73f, 1.83f, 4.23f)
                quadToRelative(0f, 1.59f, -0.84f, 2.78f)
                quadToRelative(-0.83f, 1.17f, -2.53f, 1.81f)
                quadToRelative(2.11f, 0.69f, 3.2f, 2.22f)
                quadToRelative(1.11f, 1.53f, 1.11f, 3.66f)
                quadToRelative(0f, 2.94f, -2.08f, 4.94f)
                quadToRelative(-2.08f, 2f, -5.47f, 2f)
                quadToRelative(-3.39f, 0f, -5.47f, -2f)
                quadToRelative(-2.08f, -2.02f, -2.08f, -5.02f)
                quadToRelative(0f, -2.23f, 1.12f, -3.73f)
                quadToRelative(1.14f, -1.52f, 3.23f, -2.06f)
                close()
                moveTo(12.94f, 9.23f)
                quadToRelative(0f, 1.62f, 1.05f, 2.66f)
                quadToRelative(1.05f, 1.03f, 2.72f, 1.03f)
                quadToRelative(1.63f, 0f, 2.66f, -1.02f)
                quadToRelative(1.05f, -1.03f, 1.05f, -2.52f)
                quadToRelative(0f, -1.55f, -1.08f, -2.59f)
                quadToRelative(-1.06f, -1.06f, -2.66f, -1.06f)
                quadToRelative(-1.61f, 0f, -2.67f, 1.03f)
                quadToRelative(-1.06f, 1.03f, -1.06f, 2.47f)
                close()
                moveTo(12.03f, 19.8f)
                quadToRelative(0f, 1.2f, 0.56f, 2.33f)
                quadToRelative(0.58f, 1.13f, 1.7f, 1.75f)
                quadToRelative(1.13f, 0.61f, 2.42f, 0.61f)
                quadToRelative(2.02f, 0f, 3.33f, -1.3f)
                quadToRelative(1.31f, -1.3f, 1.31f, -3.3f)
                quadToRelative(0f, -2.03f, -1.36f, -3.36f)
                quadToRelative(-1.34f, -1.33f, -3.38f, -1.33f)
                quadToRelative(-1.98f, 0f, -3.3f, 1.31f)
                quadToRelative(-1.3f, 1.31f, -1.3f, 3.28f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveToRelative(153.83f, 229.14f)
                quadToRelative(1.75f, 0.64f, 2.59f, 1.83f)
                quadToRelative(0.84f, 1.19f, 0.84f, 2.84f)
                quadToRelative(-0f, 2.5f, -1.8f, 4.2f)
                quadToRelative(-1.8f, 1.7f, -4.78f, 1.7f)
                quadToRelative(-3f, -0f, -4.83f, -1.75f)
                quadToRelative(-1.83f, -1.73f, -1.83f, -4.23f)
                quadToRelative(-0f, -1.59f, 0.84f, -2.78f)
                quadToRelative(0.83f, -1.17f, 2.53f, -1.81f)
                quadToRelative(-2.11f, -0.69f, -3.2f, -2.22f)
                quadToRelative(-1.11f, -1.53f, -1.11f, -3.66f)
                quadToRelative(-0f, -2.94f, 2.08f, -4.94f)
                quadToRelative(2.08f, -2f, 5.47f, -2f)
                quadToRelative(3.39f, -0f, 5.47f, 2f)
                quadToRelative(2.08f, 2.02f, 2.08f, 5.02f)
                quadToRelative(-0f, 2.23f, -1.13f, 3.73f)
                quadToRelative(-1.14f, 1.52f, -3.23f, 2.06f)
                close()
                moveTo(154.39f, 233.9f)
                quadToRelative(-0f, -1.63f, -1.05f, -2.66f)
                quadToRelative(-1.05f, -1.03f, -2.72f, -1.03f)
                quadToRelative(-1.63f, -0f, -2.66f, 1.02f)
                quadToRelative(-1.05f, 1.03f, -1.05f, 2.52f)
                quadToRelative(-0f, 1.55f, 1.08f, 2.59f)
                quadToRelative(1.06f, 1.06f, 2.66f, 1.06f)
                quadToRelative(1.61f, -0f, 2.67f, -1.03f)
                quadToRelative(1.06f, -1.03f, 1.06f, -2.47f)
                close()
                moveTo(155.3f, 223.32f)
                quadToRelative(-0f, -1.2f, -0.56f, -2.33f)
                quadToRelative(-0.58f, -1.13f, -1.7f, -1.75f)
                quadToRelative(-1.13f, -0.61f, -2.42f, -0.61f)
                quadToRelative(-2.02f, -0f, -3.33f, 1.3f)
                quadToRelative(-1.31f, 1.3f, -1.31f, 3.3f)
                quadToRelative(-0f, 2.03f, 1.36f, 3.36f)
                quadToRelative(1.34f, 1.33f, 3.38f, 1.33f)
                quadToRelative(1.98f, -0f, 3.3f, -1.31f)
                quadToRelative(1.3f, -1.31f, 1.3f, -3.28f)
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
                moveTo(120.12f, 181.39f)
                curveTo(114.64f, 173.98f, 111.73f, 166.44f, 111.73f, 166.44f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(97.85f, 188.8f, 91.02f, 193.62f, 91.02f, 193.62f)
                curveTo(91.02f, 193.62f, 97.85f, 198.44f, 103.33f, 205.86f)
                curveTo(108.81f, 213.27f, 111.73f, 220.8f, 111.73f, 220.8f)
                curveTo(111.73f, 220.8f, 114.64f, 213.27f, 120.12f, 205.86f)
                curveTo(125.61f, 198.44f, 132.44f, 193.62f, 132.44f, 193.62f)
                curveTo(132.44f, 193.62f, 125.61f, 188.8f, 120.12f, 181.39f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(120.12f, 36.99f)
                curveTo(114.64f, 29.58f, 111.73f, 22.04f, 111.73f, 22.04f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(97.85f, 44.4f, 91.02f, 49.22f, 91.02f, 49.22f)
                curveTo(91.02f, 49.22f, 97.85f, 54.04f, 103.33f, 61.45f)
                curveTo(108.81f, 68.86f, 111.73f, 76.4f, 111.73f, 76.4f)
                curveTo(111.73f, 76.4f, 114.64f, 68.86f, 120.12f, 61.45f)
                curveTo(125.61f, 54.04f, 132.44f, 49.22f, 132.44f, 49.22f)
                curveTo(132.44f, 49.22f, 125.61f, 44.4f, 120.12f, 36.99f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(120.12f, 108.29f)
                curveTo(114.64f, 100.88f, 111.73f, 93.34f, 111.73f, 93.34f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(97.85f, 115.7f, 91.02f, 120.52f, 91.02f, 120.52f)
                curveTo(91.02f, 120.52f, 97.85f, 125.34f, 103.33f, 132.75f)
                curveTo(108.81f, 140.16f, 111.73f, 147.7f, 111.73f, 147.7f)
                curveTo(111.73f, 147.7f, 114.64f, 140.16f, 120.12f, 132.75f)
                curveTo(125.61f, 125.34f, 132.44f, 120.52f, 132.44f, 120.52f)
                curveTo(132.44f, 120.52f, 125.61f, 115.7f, 120.12f, 108.29f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(62.81f, 181.51f)
                curveTo(57.33f, 174.1f, 54.41f, 166.56f, 54.41f, 166.56f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(40.54f, 188.92f, 33.71f, 193.74f, 33.71f, 193.74f)
                curveTo(33.71f, 193.74f, 40.54f, 198.56f, 46.02f, 205.97f)
                curveTo(51.5f, 213.38f, 54.41f, 220.92f, 54.41f, 220.92f)
                curveTo(54.41f, 220.92f, 57.33f, 213.38f, 62.81f, 205.97f)
                curveTo(68.29f, 198.56f, 75.12f, 193.74f, 75.12f, 193.74f)
                curveTo(75.12f, 193.74f, 68.29f, 188.92f, 62.81f, 181.51f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(62.81f, 37.11f)
                curveTo(57.33f, 29.69f, 54.41f, 22.16f, 54.41f, 22.16f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(40.54f, 44.52f, 33.71f, 49.34f, 33.71f, 49.34f)
                curveTo(33.71f, 49.34f, 40.54f, 54.16f, 46.02f, 61.57f)
                curveTo(51.5f, 68.98f, 54.41f, 76.51f, 54.41f, 76.51f)
                curveTo(54.41f, 76.51f, 57.33f, 68.98f, 62.81f, 61.57f)
                curveTo(68.29f, 54.16f, 75.12f, 49.34f, 75.12f, 49.34f)
                curveTo(75.12f, 49.34f, 68.29f, 44.52f, 62.81f, 37.11f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(62.81f, 108.41f)
                curveTo(57.33f, 101f, 54.41f, 93.46f, 54.41f, 93.46f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(40.54f, 115.82f, 33.71f, 120.64f, 33.71f, 120.64f)
                curveTo(33.71f, 120.64f, 40.54f, 125.46f, 46.02f, 132.87f)
                curveTo(51.5f, 140.28f, 54.41f, 147.82f, 54.41f, 147.82f)
                curveTo(54.41f, 147.82f, 57.33f, 140.28f, 62.81f, 132.87f)
                curveTo(68.29f, 125.46f, 75.12f, 120.64f, 75.12f, 120.64f)
                curveTo(75.12f, 120.64f, 68.29f, 115.82f, 62.81f, 108.41f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(91.61f, 73.31f)
                curveTo(86.13f, 65.89f, 83.21f, 58.36f, 83.21f, 58.36f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(69.34f, 80.72f, 62.51f, 85.54f, 62.51f, 85.54f)
                curveTo(62.51f, 85.54f, 69.34f, 90.36f, 74.82f, 97.77f)
                curveTo(80.3f, 105.18f, 83.21f, 112.71f, 83.21f, 112.71f)
                curveTo(83.21f, 112.71f, 86.13f, 105.18f, 91.61f, 97.77f)
                curveTo(97.09f, 90.36f, 103.92f, 85.54f, 103.92f, 85.54f)
                curveTo(103.92f, 85.54f, 97.09f, 80.72f, 91.61f, 73.31f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(91.61f, 144.69f)
                curveTo(86.13f, 137.28f, 83.21f, 129.75f, 83.21f, 129.75f)
                curveToRelative(0f, 0f, -2.92f, 7.53f, -8.39f, 14.95f)
                curveTo(69.34f, 152.1f, 62.51f, 156.92f, 62.51f, 156.92f)
                curveTo(62.51f, 156.92f, 69.34f, 161.74f, 74.82f, 169.16f)
                curveTo(80.3f, 176.57f, 83.21f, 184.1f, 83.21f, 184.1f)
                curveTo(83.21f, 184.1f, 86.13f, 176.57f, 91.61f, 169.16f)
                curveTo(97.09f, 161.74f, 103.92f, 156.92f, 103.92f, 156.92f)
                curveTo(103.92f, 156.92f, 97.09f, 152.1f, 91.61f, 144.69f)
                close()
            }
        }.build()

        return _8OfDiamonds!!
    }

@Suppress("ObjectPropertyName")
private var _8OfDiamonds: ImageVector? = null
