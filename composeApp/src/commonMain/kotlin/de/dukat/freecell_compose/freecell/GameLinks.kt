package de.dukat.freecell_compose.freecell

expect fun platformGameBaseUrl(): String
expect fun platformIncomingGameLink(): String?

/** Reports success only after the platform accepts the clipboard write. */
expect fun copyGameLinkToClipboard(link: String, onResult: (Boolean) -> Unit)
