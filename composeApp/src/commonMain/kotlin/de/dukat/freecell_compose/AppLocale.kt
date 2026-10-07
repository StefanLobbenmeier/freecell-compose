package de.dukat.freecell_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue

enum class AppLanguage(val tag: String?, val label: String) {
    System(null, ""), English("en", "English"), German("de", "Deutsch"),
    BrazilianPortuguese("pt-BR", "Português (Brasil)"), Spanish("es", "Español");

    companion object {
        fun fromTag(tag: String?): AppLanguage = entries.firstOrNull { it.tag == tag } ?: System
    }
}

// Platform implementations follow Compose's resource-environment locale guidance.
expect object LocalAppLocale {
    @Composable infix fun provides(value: String?): ProvidedValue<*>
}

expect fun loadAppLanguage(): AppLanguage
expect fun saveAppLanguage(language: AppLanguage)
internal const val LANGUAGE_STORAGE_KEY = "freecell-compose.language"
