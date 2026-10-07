package de.dukat.freecell_compose.freecell

import de.dukat.freecell_compose.freecell.model.GameState
import java.nio.file.Files
import java.nio.file.Path

private class DesktopGameStatePersistence : GameStatePersistence {
    private val savePath: Path
        get() = Path.of(System.getProperty("user.home"), ".freecell-compose", "restore-point.txt")

    private val archivePath: Path
        get() = savePath.resolveSibling("game-archive.txt")

    override fun loadArchive(): String? = runCatching {
        if (Files.exists(archivePath)) Files.readString(archivePath) else null
    }.getOrNull()

    override fun saveArchive(serialized: String) {
        runCatching {
            Files.createDirectories(archivePath.parent)
            val temporary = archivePath.resolveSibling("game-archive.tmp")
            Files.writeString(temporary, serialized)
            Files.move(temporary, archivePath, java.nio.file.StandardCopyOption.REPLACE_EXISTING)
        }
    }

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

actual fun createPlatformGameStatePersistence(): GameStatePersistence = DesktopGameStatePersistence()
