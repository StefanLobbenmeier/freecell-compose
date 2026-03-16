package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`4OfClubs`: ImageVector
    get() {
        if (_4OfClubs != null) {
            return _4OfClubs!!
        }
        _4OfClubs = ImageVector.Builder(
            name = "4OfClubs",
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
                moveTo(18.65f, 27.55f)
                lineTo(18.65f, 22.06f)
                lineTo(8.72f, 22.06f)
                lineTo(8.72f, 19.49f)
                lineTo(19.17f, 4.64f)
                horizontalLineToRelative(2.3f)
                lineTo(21.47f, 19.49f)
                horizontalLineToRelative(3.09f)
                verticalLineToRelative(2.58f)
                horizontalLineToRelative(-3.09f)
                verticalLineToRelative(5.48f)
                close()
                moveTo(18.65f, 19.49f)
                lineTo(18.65f, 9.16f)
                lineTo(11.48f, 19.49f)
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
                moveToRelative(148.52f, 214.47f)
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
                moveTo(148.52f, 222.53f)
                lineToRelative(-0f, 10.33f)
                lineToRelative(7.17f, -10.33f)
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
                moveToRelative(59.17f, 55.5f)
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
                moveToRelative(48.37f, 188.24f)
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
                moveToRelative(117.25f, 55.5f)
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
                moveToRelative(106.45f, 188.24f)
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

        return _4OfClubs!!
    }

@Suppress("ObjectPropertyName")
private var _4OfClubs: ImageVector? = null
