package de.dukat.freecell_compose

import freecell_compose.composeapp.generated.resources.*
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.getString
import java.util.Locale
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalizationTest {
    @Test
    fun resourcesResolveDeviceLanguagesAndFormattedMessages() = runBlocking {
        val previous = Locale.getDefault()
        try {
            for ((tag, settings, game) in listOf(
                Triple("en-US", "Settings", "Game 42"),
                Triple("de-DE", "Einstellungen", "Spiel 42"),
                Triple("pt-BR", "Configurações", "Jogo 42"),
                Triple("es-MX", "Ajustes", "Partida 42"),
                Triple("ja-JP", "Settings", "Game 42"),
            )) {
                Locale.setDefault(Locale.forLanguageTag(tag))
                assertEquals(settings, getString(Res.string.settings), tag)
                assertEquals(game, getString(Res.string.game_number, 42), tag)
            }
            Locale.setDefault(Locale.forLanguageTag("pt-BR"))
            assertEquals("7 / 52 cartas nas fundações", getString(Res.string.cards_home, 7))
        } finally {
            Locale.setDefault(previous)
        }
    }

    @Test
    fun unknownOrMissingSavedLanguageUsesSystemDefault() {
        assertEquals(AppLanguage.System, AppLanguage.fromTag(null))
        assertEquals(AppLanguage.System, AppLanguage.fromTag("invalid"))
        assertEquals(AppLanguage.BrazilianPortuguese, AppLanguage.fromTag("pt-BR"))
    }
}
