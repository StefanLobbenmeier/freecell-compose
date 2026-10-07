package de.dukat.freecell_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import java.util.Locale
import java.util.prefs.Preferences

actual object LocalAppLocale {
    private val systemLocale = Locale.getDefault()
    private val local = staticCompositionLocalOf { systemLocale.toLanguageTag() }

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        val locale = value?.let(Locale::forLanguageTag) ?: systemLocale
        Locale.setDefault(locale)
        return local.provides(locale.toLanguageTag())
    }
}

actual fun loadAppLanguage(): AppLanguage = runCatching {
    AppLanguage.fromTag(Preferences.userRoot().node("de/dukat/freecell-compose").get(LANGUAGE_STORAGE_KEY, null))
}.getOrDefault(AppLanguage.System)

actual fun saveAppLanguage(language: AppLanguage) {
    runCatching {
        val preferences = Preferences.userRoot().node("de/dukat/freecell-compose")
        language.tag?.let { preferences.put(LANGUAGE_STORAGE_KEY, it) } ?: preferences.remove(LANGUAGE_STORAGE_KEY)
    }
}
