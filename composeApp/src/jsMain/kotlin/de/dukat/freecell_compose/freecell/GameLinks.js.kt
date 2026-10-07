package de.dukat.freecell_compose.freecell

import kotlinx.browser.window

actual fun platformGameBaseUrl(): String = window.location.href.substringBefore('#')
actual fun platformIncomingGameLink(): String? {
    val link = window.location.href.takeIf { "#game=" in it } ?: return null
    // Consume the incoming link so reloading restores the library without importing it again.
    window.history.replaceState(null, "", window.location.pathname + window.location.search)
    return link
}

actual fun copyGameLinkToClipboard(link: String, onResult: (Boolean) -> Unit) {
    val clipboard = window.navigator.asDynamic().clipboard
    if (clipboard == null) {
        onResult(false)
        return
    }
    try {
        clipboard.writeText(link).then({ _: dynamic -> onResult(true) }, { _: dynamic -> onResult(false) })
    } catch (_: Throwable) {
        onResult(false)
    }
}
