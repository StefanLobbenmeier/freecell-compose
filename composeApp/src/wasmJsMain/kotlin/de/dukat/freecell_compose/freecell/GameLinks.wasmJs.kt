package de.dukat.freecell_compose.freecell

import kotlinx.browser.window

actual fun platformGameBaseUrl(): String = window.location.href.substringBefore('#')
@OptIn(kotlin.js.ExperimentalWasmJsInterop::class)
actual fun platformIncomingGameLink(): String? {
    val link = window.location.href.takeIf { "#game=" in it } ?: return null
    // Consume the incoming link so reloading restores the library without importing it again.
    window.history.replaceState(null, "", window.location.pathname + window.location.search)
    return link
}
