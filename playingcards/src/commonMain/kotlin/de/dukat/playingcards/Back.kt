package com.dukat.playingcards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val com.dukat.playingcards.PlayingCards.Back: ImageVector
    get() {
        if (_root_ide_package_.com.dukat.playingcards._Back != null) {
            return _root_ide_package_.com.dukat.playingcards._Back!!
        }
        _root_ide_package_.com.dukat.playingcards._Back = ImageVector.Builder(
            name = "Back",
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
            path(
                stroke = SolidColor(Color(0xFF131F67)),
                strokeLineWidth = 3.64f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(12.84f, 14f)
                lineToRelative(142.16f, 0f)
                lineToRelative(0f, 214.3f)
                lineToRelative(-142.16f, 0f)
                close()
            }
            path(
                fill = SolidColor(Color.Black),
                stroke = SolidColor(Color(0xFF131F67)),
                strokeLineWidth = 0.73f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(16.01f, 16.9f)
                lineToRelative(135.83f, 0f)
                lineToRelative(0f, 208.52f)
                lineToRelative(-135.83f, 0f)
                close()
            }
        }.build()

        return _root_ide_package_.com.dukat.playingcards._Back!!
    }

@Suppress("ObjectPropertyName")
private var _Back: ImageVector? = null
