package de.dukat.freecell_compose

class DesktopPlatform : Platform {
    override val name: String = "Desktop (JVM)"
}

actual fun getPlatform(): Platform = DesktopPlatform()
