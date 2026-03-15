package de.dukat.freecell_compose

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform