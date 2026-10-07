package de.dukat.freecell_compose.ui

import androidx.compose.runtime.Composable
import de.dukat.freecell_compose.freecell.model.Card
import de.dukat.freecell_compose.freecell.model.MoveError
import de.dukat.freecell_compose.freecell.model.Suit
import freecell_compose.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun localizedCardDescription(card: Card): String {
    val rank = when (card.rank) {
        1 -> stringResource(Res.string.ace)
        11 -> stringResource(Res.string.jack)
        12 -> stringResource(Res.string.queen)
        13 -> stringResource(Res.string.king)
        else -> card.rank.toString()
    }
    val suit = stringResource(when (card.suit) {
        Suit.Clubs -> Res.string.clubs
        Suit.Diamonds -> Res.string.diamonds
        Suit.Hearts -> Res.string.hearts
        Suit.Spades -> Res.string.spades
    })
    return stringResource(Res.string.card_description, rank, suit)
}

@Composable
internal fun localizedMoveError(error: String): String = stringResource(when (error) {
    MoveError.MoveTooLargeForCapacity.name -> Res.string.move_capacity
    MoveError.FreeCellNotEmpty.name -> Res.string.cell_occupied
    MoveError.RunNotValid.name -> Res.string.invalid_run
    MoveError.FoundationNotCompatible.name -> Res.string.foundation_incompatible
    else -> Res.string.illegal_move
})
