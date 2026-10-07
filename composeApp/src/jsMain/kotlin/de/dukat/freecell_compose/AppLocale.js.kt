package de.dukat.freecell_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.browser.window

actual object LocalAppLocale {
    private val local = staticCompositionLocalOf<String?> { null }

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        updateCustomLocale(value)
        return local.provides(value)
    }
}

private fun updateCustomLocale(value: String?) {
    js("window.setFreecellLocale(value)")
}

actual fun loadAppLanguage(): AppLanguage = runCatching {
    AppLanguage.fromTag(window.localStorage.getItem(LANGUAGE_STORAGE_KEY))
}.getOrDefault(AppLanguage.System)

actual fun saveAppLanguage(language: AppLanguage) {
    runCatching {
        language.tag?.let { window.localStorage.setItem(LANGUAGE_STORAGE_KEY, it) }
            ?: window.localStorage.removeItem(LANGUAGE_STORAGE_KEY)
    }
}
