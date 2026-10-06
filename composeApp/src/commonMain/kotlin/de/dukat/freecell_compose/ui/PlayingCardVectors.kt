package de.dukat.freecell_compose.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.graphics.vector.VectorPath
import androidx.compose.ui.graphics.vector.ImageVector
import de.dukat.playingcards.*
import de.dukat.playingcards.PlayingCards
import de.dukat.freecell_compose.freecell.model.Card
import de.dukat.freecell_compose.freecell.model.Suit

fun Card.toPlayingCardVector(): ImageVector = when (rank) {
    1 -> when (suit) {
        Suit.Clubs -> PlayingCards.AceOfClubs
        Suit.Diamonds -> PlayingCards.AceOfDiamonds
        Suit.Hearts -> PlayingCards.AceOfHearts
        Suit.Spades -> PlayingCards.AceOfSpades
    }
    2 -> when (suit) {
        Suit.Clubs -> PlayingCards.`2OfClubs`
        Suit.Diamonds -> PlayingCards.`2OfDiamonds`
        Suit.Hearts -> PlayingCards.`2OfHearts`
        Suit.Spades -> PlayingCards.`2OfSpades`
    }
    3 -> when (suit) {
        Suit.Clubs -> PlayingCards.`3OfClubs`
        Suit.Diamonds -> PlayingCards.`3OfDiamonds`
        Suit.Hearts -> PlayingCards.`3OfHearts`
        Suit.Spades -> PlayingCards.`3OfSpades`
    }
    4 -> when (suit) {
        Suit.Clubs -> PlayingCards.`4OfClubs`
        Suit.Diamonds -> PlayingCards.`4OfDiamonds`
        Suit.Hearts -> PlayingCards.`4OfHearts`
        Suit.Spades -> PlayingCards.`4OfSpades`
    }
    5 -> when (suit) {
        Suit.Clubs -> PlayingCards.`5OfClubs`
        Suit.Diamonds -> PlayingCards.`5OfDiamonds`
        Suit.Hearts -> PlayingCards.`5OfHearts`
        Suit.Spades -> PlayingCards.`5OfSpades`
    }
    6 -> when (suit) {
        Suit.Clubs -> PlayingCards.`6OfClubs`
        Suit.Diamonds -> PlayingCards.`6OfDiamonds`
        Suit.Hearts -> PlayingCards.`6OfHearts`
        Suit.Spades -> PlayingCards.`6OfSpades`
    }
    7 -> when (suit) {
        Suit.Clubs -> PlayingCards.`7OfClubs`
        Suit.Diamonds -> PlayingCards.`7OfDiamonds`
        Suit.Hearts -> PlayingCards.`7OfHearts`
        Suit.Spades -> PlayingCards.`7OfSpades`
    }
    8 -> when (suit) {
        Suit.Clubs -> PlayingCards.`8OfClubs`
        Suit.Diamonds -> PlayingCards.`8OfDiamonds`
        Suit.Hearts -> PlayingCards.`8OfHearts`
        Suit.Spades -> PlayingCards.`8OfSpades`
    }
    9 -> when (suit) {
        Suit.Clubs -> PlayingCards.`9OfClubs`
        Suit.Diamonds -> PlayingCards.`9OfDiamonds`
        Suit.Hearts -> PlayingCards.`9OfHearts`
        Suit.Spades -> PlayingCards.`9OfSpades`
    }
    10 -> when (suit) {
        Suit.Clubs -> PlayingCards.`10OfClubs`
        Suit.Diamonds -> PlayingCards.`10OfDiamonds`
        Suit.Hearts -> PlayingCards.`10OfHearts`
        Suit.Spades -> PlayingCards.`10OfSpades`
    }
    11 -> when (suit) {
        Suit.Clubs -> PlayingCards.JackOfClubs
        Suit.Diamonds -> PlayingCards.JackOfDiamonds
        Suit.Hearts -> PlayingCards.JackOfHearts
        Suit.Spades -> PlayingCards.JackOfSpades
    }
    12 -> when (suit) {
        Suit.Clubs -> PlayingCards.QueenOfClubs
        Suit.Diamonds -> PlayingCards.QueenOfDiamonds
        Suit.Hearts -> PlayingCards.QueenOfHearts
        Suit.Spades -> PlayingCards.QueenOfSpades
    }
    13 -> when (suit) {
        Suit.Clubs -> PlayingCards.KingOfClubs
        Suit.Diamonds -> PlayingCards.KingOfDiamonds
        Suit.Hearts -> PlayingCards.KingOfHearts
        Suit.Spades -> PlayingCards.KingOfSpades
    }
    else -> error("rank must be 1..13")
}

/** Reuse the deck's artwork, leaving paper and corner indices to the card layout. */
internal fun Card.toPlayingCardArtwork(paper: Color): ImageVector {
    val face = toPlayingCardVector()
    // Court faces have one central emblem; trim its empty top/bottom margins.
    val topInset = if (rank >= 11) 32f else 0f
    val artworkHeight = face.viewportHeight - topInset * 2f
    return ImageVector.Builder(
        name = "${face.name}_artwork",
        defaultWidth = face.defaultWidth,
        defaultHeight = face.defaultHeight * (artworkHeight / face.viewportHeight),
        viewportWidth = face.viewportWidth,
        viewportHeight = artworkHeight,
    ).apply {
        // All deck faces have the same viewport and corner-index bounds. This stepped
        // clip excludes those indices while preserving even the top/bottom pips of 10.
        addGroup(translationY = -topInset, clipPathData = PathParser()
            .parsePathString("M 0 62 L 32 62 L 32 0 L 167.09 0 L 167.09 180.67 L 135.09 180.67 L 135.09 242.67 L 0 242.67 Z")
            .toNodes())
        // The generated deck's first path is its white paper and outer border.
        for (index in 1 until face.root.size) {
            val path = face.root[index] as VectorPath
            // Some court faces use an opaque near-white knockout around their
            // shaded emblem. Match that paper to the surface, including dimmed cards.
            val solidFill = path.fill as? SolidColor
            val fill = if (solidFill != null && solidFill.value.red > 0.99f &&
                solidFill.value.green > 0.99f && solidFill.value.blue > 0.99f
            ) SolidColor(paper) else path.fill
            addPath(
                pathData = path.pathData,
                pathFillType = path.pathFillType,
                name = path.name,
                fill = fill,
                fillAlpha = path.fillAlpha,
                stroke = path.stroke,
                strokeAlpha = path.strokeAlpha,
                strokeLineWidth = path.strokeLineWidth,
                strokeLineCap = path.strokeLineCap,
                strokeLineJoin = path.strokeLineJoin,
                strokeLineMiter = path.strokeLineMiter,
                trimPathStart = path.trimPathStart,
                trimPathEnd = path.trimPathEnd,
                trimPathOffset = path.trimPathOffset,
            )
        }
        clearGroup()
    }.build()
}
