package de.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val PlayingCards.`4OfHearts`: ImageVector
    get() {
        if (_4OfHearts != null) {
            return _4OfHearts!!
        }
        _4OfHearts = ImageVector.Builder(
            name = "4OfHearts",
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
                moveToRelative(19.12f, 28.01f)
                verticalLineToRelative(-5.48f)
                horizontalLineToRelative(-9.94f)
                lineTo(9.18f, 19.95f)
                lineTo(19.63f, 5.11f)
                horizontalLineToRelative(2.3f)
                lineTo(21.93f, 19.95f)
                horizontalLineToRelative(3.09f)
                verticalLineToRelative(2.58f)
                horizontalLineToRelative(-3.09f)
                verticalLineToRelative(5.48f)
                close()
                moveTo(19.12f, 19.95f)
                lineTo(19.12f, 9.62f)
                lineTo(11.95f, 19.95f)
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
                moveToRelative(148.47f, 213.52f)
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
                moveTo(148.47f, 221.58f)
                lineToRelative(-0f, 10.33f)
                lineToRelative(7.17f, -10.33f)
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
                moveTo(66.33f, 41.45f)
                curveTo(57.32f, 41.45f, 56.11f, 50.5f, 56.11f, 50.5f)
                curveTo(56.11f, 50.5f, 54.91f, 41.45f, 45.9f, 41.45f)
                curveTo(39.59f, 41.45f, 33.88f, 45.51f, 33.88f, 53.16f)
                curveTo(33.88f, 63.26f, 52.16f, 73.43f, 56.11f, 88.27f)
                curveTo(59.87f, 73.44f, 78.34f, 63.26f, 78.34f, 53.16f)
                curveTo(78.34f, 45.51f, 72.64f, 41.45f, 66.33f, 41.45f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(45.9f, 200.67f)
                curveTo(54.91f, 200.67f, 56.11f, 191.63f, 56.11f, 191.63f)
                curveTo(56.11f, 191.63f, 57.32f, 200.67f, 66.33f, 200.67f)
                curveTo(72.64f, 200.67f, 78.34f, 196.62f, 78.34f, 188.97f)
                curveTo(78.34f, 178.86f, 60.06f, 168.7f, 56.11f, 153.85f)
                curveTo(52.36f, 168.68f, 33.88f, 178.86f, 33.88f, 188.97f)
                curveTo(33.88f, 196.62f, 39.59f, 200.67f, 45.9f, 200.67f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(120.92f, 41.72f)
                curveTo(111.91f, 41.72f, 110.7f, 50.77f, 110.7f, 50.77f)
                curveTo(110.7f, 50.77f, 109.5f, 41.72f, 100.49f, 41.72f)
                curveTo(94.18f, 41.72f, 88.47f, 45.78f, 88.47f, 53.43f)
                curveTo(88.47f, 63.54f, 106.76f, 73.7f, 110.7f, 88.54f)
                curveTo(114.46f, 73.71f, 132.94f, 63.54f, 132.94f, 53.43f)
                curveTo(132.94f, 45.78f, 127.23f, 41.72f, 120.92f, 41.72f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDF0000))) {
                moveTo(100.49f, 200.94f)
                curveTo(109.5f, 200.94f, 110.7f, 191.9f, 110.7f, 191.9f)
                curveTo(110.7f, 191.9f, 111.91f, 200.94f, 120.92f, 200.94f)
                curveTo(127.23f, 200.94f, 132.94f, 196.89f, 132.94f, 189.24f)
                curveTo(132.94f, 179.13f, 114.65f, 168.97f, 110.7f, 154.13f)
                curveTo(106.95f, 168.96f, 88.47f, 179.13f, 88.47f, 189.24f)
                curveTo(88.47f, 196.89f, 94.18f, 200.94f, 100.49f, 200.94f)
                close()
            }
        }.build()

        return _4OfHearts!!
    }

@Suppress("ObjectPropertyName")
private var _4OfHearts: ImageVector? = null
