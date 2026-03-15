package de.dukat.freecell_compose

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "FreeCell",
    ) {
        App()
    }
}
