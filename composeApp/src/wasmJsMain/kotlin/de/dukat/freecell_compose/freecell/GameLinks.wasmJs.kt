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

@OptIn(kotlin.js.ExperimentalWasmJsInterop::class)
private fun writeClipboard(text: String, onResult: (Boolean) -> Unit): Unit = js(
    """{ try { if (!navigator.clipboard) { onResult(false); return; } navigator.clipboard.writeText(text).then(() => onResult(true), () => onResult(false)); } catch (_) { onResult(false); } }"""
)

actual fun copyGameLinkToClipboard(link: String, onResult: (Boolean) -> Unit) = writeClipboard(link, onResult)
