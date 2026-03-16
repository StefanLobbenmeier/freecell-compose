package de.dukat.playingcards

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.JackOfClubs: ImageVector
    get() {
        if (_JackOfClubs != null) {
            return _JackOfClubs!!
        }
        _JackOfClubs = ImageVector.Builder(
            name = "JackOfClubs",
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
                moveToRelative(10.83f, 21.05f)
                lineToRelative(2.73f, -0.38f)
                quadToRelative(0.11f, 2.63f, 0.98f, 3.59f)
                quadToRelative(0.88f, 0.97f, 2.42f, 0.97f)
                quadToRelative(1.14f, 0f, 1.97f, -0.52f)
                quadToRelative(0.83f, -0.53f, 1.14f, -1.42f)
                quadToRelative(0.31f, -0.91f, 0.31f, -2.88f)
                verticalLineTo(4.64f)
                horizontalLineToRelative(3.03f)
                verticalLineTo(20.25f)
                quadToRelative(0f, 2.88f, -0.7f, 4.45f)
                quadToRelative(-0.69f, 1.58f, -2.2f, 2.41f)
                quadToRelative(-1.5f, 0.83f, -3.53f, 0.83f)
                quadToRelative(-3.02f, 0f, -4.63f, -1.73f)
                quadToRelative(-1.59f, -1.73f, -1.53f, -5.16f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.Black,
                        1f to Color.Black.copy(alpha = 0.654902f)
                    ),
                    center = Offset(84.26f, 86.21f),
                    radius = 88.54f
                )
            ) {
                moveToRelative(96.57f, 113.44f)
                curveToRelative(0f, 0f, 14.18f, -11.35f, 14.18f, -27.08f)
                curveToRelative(0f, -9.21f, -8.18f, -24.5f, -27.08f, -24.5f)
                curveToRelative(-18.9f, 0f, -27.08f, 15.29f, -27.08f, 24.5f)
                curveToRelative(0f, 15.73f, 14.18f, 27.08f, 14.18f, 27.08f)
                curveToRelative(-15.75f, -12.27f, -43.84f, -3.89f, -43.84f, 20.63f)
                curveToRelative(0f, 12.28f, 10.03f, 25.79f, 25.79f, 25.79f)
                curveToRelative(18.9f, 0f, 27.08f, -20.63f, 27.08f, -20.63f)
                curveToRelative(0f, 0f, 2.4f, 23.52f, -11.6f, 36.11f)
                lineToRelative(30.95f, 0f)
                curveToRelative(-14f, -12.58f, -11.6f, -36.11f, -11.6f, -36.11f)
                curveToRelative(0f, 0f, 8.18f, 20.63f, 27.08f, 20.63f)
                curveToRelative(15.76f, 0f, 25.79f, -13.51f, 25.79f, -25.79f)
                curveToRelative(0f, -24.53f, -28.09f, -32.91f, -43.84f, -20.63f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0.53333336f)
                    ),
                    center = Offset(39.11f, 118.03f),
                    radius = 25.59f
                )
            ) {
                moveToRelative(27.99f, 143.93f)
                curveToRelative(0f, 0f, -1.84f, -23.63f, 5.23f, -30.57f)
                curveToRelative(7.95f, -7.81f, 32.01f, -2.84f, 32.01f, -2.84f)
                curveToRelative(0f, 0f, -16.36f, 6.18f, -22.86f, 12.09f)
                curveToRelative(-6.22f, 5.65f, -14.37f, 21.33f, -14.37f, 21.33f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0.5176471f)
                    ),
                    center = Offset(70.98f, 72.48f),
                    radius = 25.59f
                )
            ) {
                moveToRelative(59.86f, 98.39f)
                curveToRelative(0f, 0f, -1.84f, -23.63f, 5.23f, -30.57f)
                curveToRelative(7.95f, -7.81f, 32.01f, -2.84f, 32.01f, -2.84f)
                curveToRelative(0f, 0f, -16.36f, 6.18f, -22.86f, 12.09f)
                curveToRelative(-6.22f, 5.65f, -14.37f, 21.33f, -14.37f, 21.33f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0.7019608f)
                    ),
                    center = Offset(116.65f, 106.23f),
                    radius = 31.87f
                )
            ) {
                moveToRelative(81.97f, 141.01f)
                curveToRelative(0f, 0f, 14.58f, -27.94f, 26.7f, -31.33f)
                curveToRelative(13.63f, -3.81f, 34.94f, 17.06f, 34.94f, 17.06f)
                curveToRelative(0f, 0f, -21.15f, -3.36f, -31.97f, -0.79f)
                curveToRelative(-10.34f, 2.46f, -29.67f, 15.06f, -29.67f, 15.06f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFFEFF))) {
                moveToRelative(14.72f, 41.67f)
                lineToRelative(0f, 151.37f)
                lineToRelative(137.53f, 0f)
                lineToRelative(0f, -151.37f)
                lineToRelative(-137.53f, 0f)
                close()
                moveTo(83.63f, 61.79f)
                curveToRelative(18.9f, 0f, 27.08f, 15.29f, 27.08f, 24.5f)
                curveToRelative(0f, 15.73f, -14.19f, 27.08f, -14.19f, 27.08f)
                curveToRelative(15.75f, -12.27f, 43.84f, -3.89f, 43.84f, 20.63f)
                curveToRelative(0f, 12.27f, -10.03f, 25.79f, -25.79f, 25.79f)
                curveToRelative(-18.9f, 0f, -27.08f, -20.63f, -27.08f, -20.63f)
                curveToRelative(0f, 0f, -2.4f, 23.52f, 11.6f, 36.11f)
                lineToRelative(-30.95f, 0f)
                curveToRelative(14f, -12.59f, 11.61f, -36.11f, 11.61f, -36.11f)
                curveToRelative(0f, 0f, -8.17f, 20.63f, -27.08f, 20.63f)
                curveToRelative(-15.75f, 0f, -25.79f, -13.51f, -25.79f, -25.79f)
                curveToRelative(0f, -24.53f, 28.08f, -32.91f, 43.84f, -20.63f)
                curveToRelative(0f, 0f, -14.19f, -11.35f, -14.19f, -27.08f)
                curveToRelative(0f, -9.2f, 8.17f, -24.5f, 27.08f, -24.5f)
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
                moveToRelative(156.34f, 220.97f)
                lineToRelative(-2.73f, 0.38f)
                quadToRelative(-0.11f, -2.63f, -0.98f, -3.59f)
                quadToRelative(-0.88f, -0.97f, -2.42f, -0.97f)
                quadToRelative(-1.14f, -0f, -1.97f, 0.52f)
                quadToRelative(-0.83f, 0.53f, -1.14f, 1.42f)
                quadToRelative(-0.31f, 0.91f, -0.31f, 2.88f)
                lineToRelative(-0f, 15.78f)
                lineToRelative(-3.03f, -0f)
                lineToRelative(-0f, -15.61f)
                quadToRelative(-0f, -2.88f, 0.7f, -4.45f)
                quadToRelative(0.69f, -1.58f, 2.2f, -2.41f)
                quadToRelative(1.5f, -0.83f, 3.53f, -0.83f)
                quadToRelative(3.02f, -0f, 4.63f, 1.73f)
                quadToRelative(1.59f, 1.73f, 1.53f, 5.16f)
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
        }.build()

        return _JackOfClubs!!
    }

@Suppress("ObjectPropertyName")
private var _JackOfClubs: ImageVector? = null
