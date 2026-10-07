package de.dukat.freecell_compose.freecell

actual fun platformGameBaseUrl(): String = "https://stefanlobbenmeier.github.io/freecell-compose/"
actual fun platformIncomingGameLink(): String? = null

actual fun copyGameLinkToClipboard(link: String, onResult: (Boolean) -> Unit) {
    onResult(runCatching {
        java.awt.Toolkit.getDefaultToolkit().systemClipboard.setContents(java.awt.datatransfer.StringSelection(link), null)
    }.isSuccess)
}
