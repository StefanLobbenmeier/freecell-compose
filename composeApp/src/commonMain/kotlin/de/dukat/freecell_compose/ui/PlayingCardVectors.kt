package de.dukat.freecell_compose.ui

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
