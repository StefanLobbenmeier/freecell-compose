package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`6OfClubs`: ImageVector
    get() {
        if (_6OfClubs != null) {
            return _6OfClubs!!
        }
        _6OfClubs = ImageVector.Builder(
            name = "6OfClubs",
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
                moveToRelative(24.23f, 10.25f)
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
                moveTo(12.75f, 20.13f)
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
                moveToRelative(20.69f, 43.74f)
                curveToRelative(0f, 0f, 3.53f, -2.82f, 3.53f, -6.74f)
                curveToRelative(0f, -2.29f, -2.03f, -6.09f, -6.74f, -6.09f)
                curveToRelative(-4.7f, 0f, -6.74f, 3.8f, -6.74f, 6.09f)
                curveToRelative(0f, 3.91f, 3.53f, 6.74f, 3.53f, 6.74f)
                curveToRelative(-3.92f, -3.05f, -10.91f, -0.97f, -10.91f, 5.13f)
                curveToRelative(0f, 3.05f, 2.5f, 6.42f, 6.42f, 6.42f)
                curveToRelative(4.7f, 0f, 6.74f, -5.13f, 6.74f, -5.13f)
                curveToRelative(0f, 0f, 0.6f, 5.85f, -2.89f, 8.98f)
                lineToRelative(7.7f, 0f)
                curveToRelative(-3.48f, -3.13f, -2.89f, -8.98f, -2.89f, -8.98f)
                curveToRelative(0f, 0f, 2.03f, 5.13f, 6.74f, 5.13f)
                curveToRelative(3.92f, 0f, 6.42f, -3.36f, 6.42f, -6.42f)
                curveToRelative(0f, -6.1f, -6.99f, -8.19f, -10.91f, -5.13f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(142.94f, 231.76f)
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
                moveTo(154.43f, 221.89f)
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
                moveToRelative(146.48f, 198.74f)
                curveToRelative(-0f, -0f, -3.53f, 2.82f, -3.53f, 6.74f)
                curveToRelative(-0f, 2.29f, 2.03f, 6.09f, 6.74f, 6.09f)
                curveToRelative(4.7f, -0f, 6.74f, -3.8f, 6.74f, -6.09f)
                curveToRelative(-0f, -3.91f, -3.53f, -6.74f, -3.53f, -6.74f)
                curveToRelative(3.92f, 3.05f, 10.91f, 0.97f, 10.91f, -5.13f)
                curveToRelative(-0f, -3.05f, -2.5f, -6.42f, -6.42f, -6.42f)
                curveToRelative(-4.7f, -0f, -6.74f, 5.13f, -6.74f, 5.13f)
                curveToRelative(-0f, -0f, -0.6f, -5.85f, 2.89f, -8.98f)
                lineToRelative(-7.7f, -0f)
                curveToRelative(3.48f, 3.13f, 2.89f, 8.98f, 2.89f, 8.98f)
                curveToRelative(-0f, -0f, -2.03f, -5.13f, -6.74f, -5.13f)
                curveToRelative(-3.92f, -0f, -6.42f, 3.36f, -6.42f, 6.42f)
                curveToRelative(-0f, 6.1f, 6.99f, 8.19f, 10.91f, 5.13f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(62.37f, 47.5f)
                curveToRelative(0f, 0f, 5.97f, -4.77f, 5.97f, -11.39f)
                curveToRelative(0f, -3.87f, -3.44f, -10.31f, -11.39f, -10.31f)
                curveToRelative(-7.95f, 0f, -11.39f, 6.43f, -11.39f, 10.31f)
                curveToRelative(0f, 6.62f, 5.97f, 11.39f, 5.97f, 11.39f)
                curveToRelative(-6.63f, -5.16f, -18.44f, -1.64f, -18.44f, 8.68f)
                curveToRelative(0f, 5.17f, 4.22f, 10.85f, 10.85f, 10.85f)
                curveToRelative(7.95f, 0f, 11.39f, -8.68f, 11.39f, -8.68f)
                curveToRelative(0f, 0f, 1.01f, 9.89f, -4.88f, 15.19f)
                lineToRelative(13.02f, 0f)
                curveToRelative(-5.89f, -5.29f, -4.88f, -15.19f, -4.88f, -15.19f)
                curveToRelative(0f, 0f, 3.44f, 8.68f, 11.39f, 8.68f)
                curveToRelative(6.63f, 0f, 10.85f, -5.69f, 10.85f, -10.85f)
                curveToRelative(0f, -10.32f, -11.82f, -13.84f, -18.44f, -8.68f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(51.57f, 196.24f)
                curveToRelative(-0f, -0f, -5.97f, 4.77f, -5.97f, 11.39f)
                curveToRelative(-0f, 3.87f, 3.44f, 10.31f, 11.39f, 10.31f)
                curveToRelative(7.95f, -0f, 11.39f, -6.43f, 11.39f, -10.31f)
                curveToRelative(-0f, -6.62f, -5.97f, -11.39f, -5.97f, -11.39f)
                curveToRelative(6.63f, 5.16f, 18.44f, 1.64f, 18.44f, -8.68f)
                curveToRelative(-0f, -5.17f, -4.22f, -10.85f, -10.85f, -10.85f)
                curveToRelative(-7.95f, -0f, -11.39f, 8.68f, -11.39f, 8.68f)
                curveToRelative(-0f, -0f, -1.01f, -9.89f, 4.88f, -15.19f)
                lineToRelative(-13.02f, -0f)
                curveToRelative(5.89f, 5.29f, 4.88f, 15.19f, 4.88f, 15.19f)
                curveToRelative(-0f, -0f, -3.44f, -8.68f, -11.39f, -8.68f)
                curveToRelative(-6.63f, -0f, -10.85f, 5.69f, -10.85f, 10.85f)
                curveToRelative(-0f, 10.32f, 11.82f, 13.84f, 18.44f, 8.68f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(62.37f, 117.2f)
                curveToRelative(0f, 0f, 5.97f, -4.77f, 5.97f, -11.39f)
                curveToRelative(0f, -3.87f, -3.44f, -10.31f, -11.39f, -10.31f)
                curveToRelative(-7.95f, 0f, -11.39f, 6.43f, -11.39f, 10.31f)
                curveToRelative(0f, 6.62f, 5.97f, 11.39f, 5.97f, 11.39f)
                curveToRelative(-6.63f, -5.16f, -18.44f, -1.64f, -18.44f, 8.68f)
                curveToRelative(0f, 5.17f, 4.22f, 10.85f, 10.85f, 10.85f)
                curveToRelative(7.95f, 0f, 11.39f, -8.68f, 11.39f, -8.68f)
                curveToRelative(0f, 0f, 1.01f, 9.89f, -4.88f, 15.19f)
                lineToRelative(13.02f, 0f)
                curveToRelative(-5.89f, -5.29f, -4.88f, -15.19f, -4.88f, -15.19f)
                curveToRelative(0f, 0f, 3.44f, 8.68f, 11.39f, 8.68f)
                curveToRelative(6.63f, 0f, 10.85f, -5.69f, 10.85f, -10.85f)
                curveToRelative(0f, -10.32f, -11.82f, -13.84f, -18.44f, -8.68f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(115.16f, 47.33f)
                curveToRelative(0f, 0f, 5.97f, -4.77f, 5.97f, -11.39f)
                curveToRelative(0f, -3.87f, -3.44f, -10.31f, -11.39f, -10.31f)
                curveToRelative(-7.95f, 0f, -11.39f, 6.43f, -11.39f, 10.31f)
                curveToRelative(0f, 6.62f, 5.97f, 11.39f, 5.97f, 11.39f)
                curveToRelative(-6.63f, -5.16f, -18.44f, -1.64f, -18.44f, 8.68f)
                curveToRelative(0f, 5.17f, 4.22f, 10.85f, 10.85f, 10.85f)
                curveToRelative(7.95f, 0f, 11.39f, -8.68f, 11.39f, -8.68f)
                curveToRelative(0f, 0f, 1.01f, 9.89f, -4.88f, 15.19f)
                lineToRelative(13.02f, 0f)
                curveToRelative(-5.89f, -5.29f, -4.88f, -15.19f, -4.88f, -15.19f)
                curveToRelative(0f, 0f, 3.44f, 8.68f, 11.39f, 8.68f)
                curveToRelative(6.63f, 0f, 10.85f, -5.69f, 10.85f, -10.85f)
                curveToRelative(0f, -10.32f, -11.82f, -13.84f, -18.44f, -8.68f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(104.35f, 196.07f)
                curveToRelative(-0f, -0f, -5.97f, 4.77f, -5.97f, 11.39f)
                curveToRelative(-0f, 3.87f, 3.44f, 10.31f, 11.39f, 10.31f)
                curveToRelative(7.95f, -0f, 11.39f, -6.43f, 11.39f, -10.31f)
                curveToRelative(-0f, -6.62f, -5.97f, -11.39f, -5.97f, -11.39f)
                curveToRelative(6.63f, 5.16f, 18.44f, 1.64f, 18.44f, -8.68f)
                curveToRelative(-0f, -5.17f, -4.22f, -10.85f, -10.85f, -10.85f)
                curveToRelative(-7.95f, -0f, -11.39f, 8.68f, -11.39f, 8.68f)
                curveToRelative(-0f, -0f, -1.01f, -9.89f, 4.88f, -15.19f)
                lineToRelative(-13.02f, -0f)
                curveToRelative(5.89f, 5.29f, 4.88f, 15.19f, 4.88f, 15.19f)
                curveToRelative(-0f, -0f, -3.44f, -8.68f, -11.39f, -8.68f)
                curveToRelative(-6.63f, -0f, -10.85f, 5.69f, -10.85f, 10.85f)
                curveToRelative(-0f, 10.32f, 11.82f, 13.84f, 18.44f, 8.68f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(115.16f, 117.03f)
                curveToRelative(0f, 0f, 5.97f, -4.77f, 5.97f, -11.39f)
                curveToRelative(0f, -3.87f, -3.44f, -10.31f, -11.39f, -10.31f)
                curveToRelative(-7.95f, 0f, -11.39f, 6.43f, -11.39f, 10.31f)
                curveToRelative(0f, 6.62f, 5.97f, 11.39f, 5.97f, 11.39f)
                curveToRelative(-6.63f, -5.16f, -18.44f, -1.64f, -18.44f, 8.68f)
                curveToRelative(0f, 5.17f, 4.22f, 10.85f, 10.85f, 10.85f)
                curveToRelative(7.95f, 0f, 11.39f, -8.68f, 11.39f, -8.68f)
                curveToRelative(0f, 0f, 1.01f, 9.89f, -4.88f, 15.19f)
                lineToRelative(13.02f, 0f)
                curveToRelative(-5.89f, -5.29f, -4.88f, -15.19f, -4.88f, -15.19f)
                curveToRelative(0f, 0f, 3.44f, 8.68f, 11.39f, 8.68f)
                curveToRelative(6.63f, 0f, 10.85f, -5.69f, 10.85f, -10.85f)
                curveToRelative(0f, -10.32f, -11.82f, -13.84f, -18.44f, -8.68f)
                close()
            }
        }.build()

        return _6OfClubs!!
    }

@Suppress("ObjectPropertyName")
private var _6OfClubs: ImageVector? = null
