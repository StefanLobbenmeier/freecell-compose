package de.dukat.freecell_compose.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

// Material icons, kept as vectors to avoid an entire extended-icons dependency.
object ActionIcons {
    val Undo = icon("Undo", "M12,5c-2.65,0 -5.05,1.08 -6.79,2.82L2,4.6V13h8.4L6.62,9.22C8.01,7.91 9.91,7.1 12,7.1c3.54,0 6.55,2.31 7.6,5.5l2.37,-0.78C20.64,7.86 16.68,5 12,5z")
    val Back = icon("Back", "M20,11H7.83l5.59,-5.59L12,4l-8,8 8,8 1.41,-1.41L7.83,13H20v-2z")
    val Settings = icon("Settings", "M19.43,12.98c0.04,-0.32 0.07,-0.65 0.07,-0.98s-0.03,-0.66 -0.08,-0.98l2.11,-1.65c0.19,-0.15 0.24,-0.42 0.12,-0.64l-2,-3.46c-0.12,-0.22 -0.37,-0.31 -0.6,-0.22l-2.49,1c-0.52,-0.4 -1.07,-0.73 -1.68,-0.98L14.5,2.42C14.46,2.18 14.25,2 14,2h-4c-0.25,0 -0.45,0.18 -0.49,0.42l-0.38,2.65c-0.61,0.25 -1.17,0.59 -1.68,0.98l-2.49,-1c-0.23,-0.09 -0.48,0 -0.6,0.22l-2,3.46c-0.13,0.22 -0.07,0.49 0.12,0.64l2.11,1.65c-0.05,0.32 -0.09,0.66 -0.09,0.98s0.03,0.66 0.08,0.98l-2.11,1.65c-0.19,0.15 -0.24,0.42 -0.12,0.64l2,3.46c0.12,0.22 0.37,0.31 0.6,0.22l2.49,-1c0.52,0.4 1.07,0.73 1.68,0.98l0.38,2.65c0.05,0.24 0.25,0.42 0.5,0.42h4c0.25,0 0.46,-0.18 0.49,-0.42l0.38,-2.65c0.61,-0.25 1.17,-0.58 1.68,-0.98l2.49,1c0.23,0.09 0.48,0 0.6,-0.22l2,-3.46c0.12,-0.22 0.07,-0.49 -0.12,-0.64l-2.09,-1.65zM12,15.5c-1.93,0 -3.5,-1.57 -3.5,-3.5s1.57,-3.5 3.5,-3.5 3.5,1.57 3.5,3.5 -1.57,3.5 -3.5,3.5z")

    private fun icon(name: String, data: String): ImageVector = ImageVector.Builder(
        name, 24.dp, 24.dp, 24f, 24f,
    ).apply { addPath(PathParser().parsePathString(data).toNodes(), fill = SolidColor(Color.Black)) }.build()
}
