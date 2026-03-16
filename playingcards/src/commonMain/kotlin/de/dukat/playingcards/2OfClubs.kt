package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`2OfClubs`: ImageVector
    get() {
        if (_2OfClubs != null) {
            return _2OfClubs!!
        }
        _2OfClubs = ImageVector.Builder(
            name = "2OfClubs",
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
                moveToRelative(24.42f, 24.85f)
                verticalLineToRelative(2.7f)
                horizontalLineTo(9.28f)
                quadToRelative(-0.03f, -1.02f, 0.33f, -1.95f)
                quadToRelative(0.58f, -1.55f, 1.84f, -3.05f)
                quadToRelative(1.28f, -1.5f, 3.69f, -3.47f)
                quadToRelative(3.73f, -3.06f, 5.05f, -4.84f)
                quadToRelative(1.31f, -1.8f, 1.31f, -3.39f)
                quadToRelative(0f, -1.67f, -1.2f, -2.81f)
                quadToRelative(-1.19f, -1.16f, -3.11f, -1.16f)
                quadToRelative(-2.03f, 0f, -3.25f, 1.22f)
                quadToRelative(-1.22f, 1.22f, -1.23f, 3.38f)
                lineTo(9.81f, 11.17f)
                quadToRelative(0.3f, -3.23f, 2.23f, -4.92f)
                quadToRelative(1.94f, -1.7f, 5.2f, -1.7f)
                quadToRelative(3.3f, 0f, 5.22f, 1.83f)
                quadToRelative(1.92f, 1.83f, 1.92f, 4.53f)
                quadToRelative(0f, 1.38f, -0.56f, 2.7f)
                quadToRelative(-0.56f, 1.33f, -1.88f, 2.8f)
                quadToRelative(-1.3f, 1.47f, -4.33f, 4.03f)
                quadToRelative(-2.53f, 2.13f, -3.25f, 2.89f)
                quadToRelative(-0.72f, 0.75f, -1.19f, 1.52f)
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
                moveToRelative(142.75f, 217.17f)
                lineToRelative(-0f, -2.7f)
                lineToRelative(15.14f, -0f)
                quadToRelative(0.03f, 1.02f, -0.33f, 1.95f)
                quadToRelative(-0.58f, 1.55f, -1.84f, 3.05f)
                quadToRelative(-1.28f, 1.5f, -3.69f, 3.47f)
                quadToRelative(-3.73f, 3.06f, -5.05f, 4.84f)
                quadToRelative(-1.31f, 1.8f, -1.31f, 3.39f)
                quadToRelative(-0f, 1.67f, 1.2f, 2.81f)
                quadToRelative(1.19f, 1.16f, 3.11f, 1.16f)
                quadToRelative(2.03f, -0f, 3.25f, -1.22f)
                quadToRelative(1.22f, -1.22f, 1.23f, -3.38f)
                lineToRelative(2.89f, 0.3f)
                quadToRelative(-0.3f, 3.23f, -2.23f, 4.92f)
                quadToRelative(-1.94f, 1.7f, -5.2f, 1.7f)
                quadToRelative(-3.3f, -0f, -5.22f, -1.83f)
                quadToRelative(-1.92f, -1.83f, -1.92f, -4.53f)
                quadToRelative(-0f, -1.38f, 0.56f, -2.7f)
                quadToRelative(0.56f, -1.33f, 1.88f, -2.8f)
                quadToRelative(1.3f, -1.47f, 4.33f, -4.03f)
                quadToRelative(2.53f, -2.13f, 3.25f, -2.89f)
                quadToRelative(0.72f, -0.75f, 1.19f, -1.52f)
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
                moveToRelative(89.57f, 55.5f)
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
                moveToRelative(78.77f, 188.24f)
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
        }.build()

        return _2OfClubs!!
    }

@Suppress("ObjectPropertyName")
private var _2OfClubs: ImageVector? = null
