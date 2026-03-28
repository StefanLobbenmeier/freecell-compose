package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.GameState
import java.nio.file.Files
import java.nio.file.Path

actual object PlatformGameStatePersistence : GameStatePersistence {
    private val savePath: Path
        get() = Path.of(System.getProperty("user.home"), ".freecell-compose", "restore-point.txt")

    override fun load(): GameState? {
        if (!Files.exists(savePath)) return null
        return runCatching { decodeGameState(Files.readString(savePath)) }.getOrNull()
    }

    override fun save(state: GameState) {
        runCatching {
            Files.createDirectories(savePath.parent)
            Files.writeString(savePath, encodeGameState(state))
        }
    }
}
