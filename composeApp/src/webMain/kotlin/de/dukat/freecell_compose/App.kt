package de.dukat.freecell_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.dukat.freecell_compose.ui.toPlayingCardVector
import de.dukat.freecell_compose.freecell.model.Analysis
import de.dukat.freecell_compose.freecell.model.Card
import de.dukat.freecell_compose.freecell.model.CardRef
import de.dukat.freecell_compose.freecell.model.GameState
import de.dukat.freecell_compose.freecell.model.Move
import de.dukat.freecell_compose.freecell.model.PileId
import de.dukat.freecell_compose.freecell.model.Suit
import de.dukat.freecell_compose.freecell.model.analyze
import de.dukat.freecell_compose.freecell.model.applyMove
import de.dukat.freecell_compose.freecell.model.newGame
import kotlin.math.roundToInt

@Composable
fun App() {
    MaterialTheme {
        val history = remember { ArrayDeque<GameState>() }
        var state by remember { mutableStateOf(newGame()) }
        var seedText by remember { mutableStateOf("") }
        var message by remember { mutableStateOf<String?>(null) }

        val analysis = remember(state) { analyze(state) }
        val drag = remember { mutableStateOf<DragState?>(null) }
        val pileRects = remember { PileRects() }

        val cardW = 80.dp
        val cardH = 112.dp
        val tableGapY = 22.dp
        val stackGapY = 18.dp

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0E3B2B))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "FreeCell",
                            color = Color(0xFFF2E8D5),
                            fontFamily = FontFamily.Serif,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Spacer(Modifier.width(12.dp))
                        if (state.isWon) {
                            Text("You won!", color = Color(0xFFF2E8D5), fontWeight = FontWeight.Bold)
                        }
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = seedText,
                            onValueChange = { seedText = it.filter { ch -> ch.isDigit() || ch == '-' }.take(11) },
                            label = { Text("Seed") },
                            singleLine = true,
                            modifier = Modifier.width(140.dp),
                        )
                        Spacer(Modifier.width(8.dp))
                        Button(onClick = {
                            val seed = seedText.toIntOrNull()
                            history.clear()
                            state = newGame(seed)
                            message = null
                        }) { Text("New") }
                        Spacer(Modifier.width(8.dp))
                        Button(
                            onClick = {
                                val prev = history.removeLastOrNull()
                                if (prev != null) {
                                    state = prev
                                    message = null
                                }
                            },
                            enabled = history.isNotEmpty(),
                        ) { Text("Undo") }
                    }
                }

                Spacer(Modifier.height(12.dp))

                if (message != null) {
                    Text(
                        text = message!!,
                        color = Color(0xFFF2E8D5),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                }

                fun tryMove(move: Move) {
                    val r = applyMove(state, move)
                    val next = r.getOrNull()
                    if (next != null) {
                        history.addLast(state)
                        state = next
                        message = null
                    } else {
                        message = r.exceptionOrNull()?.message ?: "Illegal move"
                    }
                }

                // Top row: freecells + foundations
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        for (i in 0 until 4) {
                            PileSlot(
                                id = PileId.FreeCell(i),
                                title = "",
                                cardW = cardW,
                                cardH = cardH,
                                state = state,
                                analysis = analysis,
                                drag = drag,
                                pileRects = pileRects,
                                onMove = ::tryMove,
                                highlight = isHighlightingPile(drag.value, PileId.FreeCell(i)),
                                dim = isDimmingPile(drag.value, PileId.FreeCell(i)),
                            )
                        }
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        for (suit in Suit.entries) {
                            PileSlot(
                                id = PileId.Foundation(suit),
                                title = "",
                                cardW = cardW,
                                cardH = cardH,
                                state = state,
                                analysis = analysis,
                                drag = drag,
                                pileRects = pileRects,
                                onMove = ::tryMove,
                                highlight = isHighlightingPile(drag.value, PileId.Foundation(suit)),
                                dim = isDimmingPile(drag.value, PileId.Foundation(suit)),
                            )
                        }
                    }
                }

                Spacer(Modifier.height(tableGapY))

                // Tableaus
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    for (col in 0 until 8) {
                        TableauColumn(
                            col = col,
                            cardW = cardW,
                            cardH = cardH,
                            gapY = stackGapY,
                            state = state,
                            analysis = analysis,
                            drag = drag,
                            pileRects = pileRects,
                            onMove = ::tryMove,
                            highlight = isHighlightingPile(drag.value, PileId.Tableau(col)),
                            dim = isDimmingPile(drag.value, PileId.Tableau(col)),
                        )
                    }
                }
            }

            // Drag overlay
            val d = drag.value
            if (d != null) {
                val alpha = 0.96f
                val px = d.pointer
                val offset = px - d.grabOffsetLocal
                Box(
                    modifier = Modifier
                        .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
                        .alpha(alpha)
                ) {
                    val stackH = if (d.cards.isEmpty()) cardH else (cardH + (stackGapY * (d.cards.size - 1)))
                    Box(
                        modifier = Modifier
                            .width(cardW)
                            .height(stackH)
                    ) {
                        for ((i, card) in d.cards.withIndex()) {
                            CardFace(
                                card = card,
                                width = cardW,
                                height = cardH,
                                modifier = Modifier
                                    .offset(y = stackGapY * i)
                            )
                        }
                    }
                }
            }
        }
    }
}

private data class DragState(
    val start: CardRef,
    val cards: List<Card>,
    val moves: List<Move>,
    val grabOffsetLocal: Offset,
    val pointer: Offset,
    val hoverPile: PileId?,
)

private class PileRects {
    private val rects: MutableMap<PileId, Rect> = linkedMapOf()

    fun set(id: PileId, rect: Rect) {
        rects[id] = rect
    }

    fun hitTest(pointer: Offset): PileId? {
        // Prefer smallest area match (cards overlap in tableau columns)
        var best: Pair<PileId, Float>? = null
        for ((id, r) in rects) {
            if (!r.contains(pointer)) continue
            val area = r.width * r.height
            if (best == null || area < best.second) best = id to area
        }
        return best?.first
    }
}

@Composable
private fun PileSlot(
    id: PileId,
    title: String,
    cardW: Dp,
    cardH: Dp,
    state: GameState,
    analysis: Analysis,
    drag: MutableState<DragState?>,
    pileRects: PileRects,
    onMove: (Move) -> Unit,
    highlight: Boolean,
    dim: Boolean,
) {
    val card = when (id) {
        is PileId.FreeCell -> state.freeCells[id.index]
        is PileId.Foundation -> state.foundations.getValue(id.suit).lastOrNull()
        else -> null
    }

    val alpha = when {
        highlight -> 1f
        dim -> 0.35f
        else -> 1f
    }

    Box(
        modifier = Modifier
            .width(cardW)
            .height(cardH)
            .alpha(alpha)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 2.dp,
                color = if (highlight) Color(0xFFF2E8D5) else Color(0x55F2E8D5),
                shape = RoundedCornerShape(12.dp)
            )
            .background(Color(0x11000000))
            .onGloballyPositioned { coords ->
                val pos = coords.positionInRoot()
                val rect = Rect(pos, Size(coords.size.width.toFloat(), coords.size.height.toFloat()))
                pileRects.set(id, rect)
            },
        contentAlignment = Alignment.Center,
    ) {
        if (title.isNotBlank()) {
            Text(title, color = Color(0xAAF2E8D5), fontSize = 11.sp)
        }
        if (card != null) {
            val canStart = analysis.movableStarts.contains(CardRef(id, 0))
            val ghost = drag.value?.start?.pile == id
            DraggableCardStart(
                start = CardRef(id, 0),
                cards = listOf(card),
                analysis = analysis,
                drag = drag,
                pileRects = pileRects,
                enabled = canStart,
                onMove = onMove,
            ) {
                CardFace(
                    card = card,
                    width = cardW,
                    height = cardH,
                    dim = !canStart && !ghost,
                    modifier = Modifier.alpha(if (ghost) 0.25f else 1f)
                )
            }
        }
    }
}

@Composable
private fun TableauColumn(
    col: Int,
    cardW: Dp,
    cardH: Dp,
    gapY: Dp,
    state: GameState,
    analysis: Analysis,
    drag: MutableState<DragState?>,
    pileRects: PileRects,
    onMove: (Move) -> Unit,
    highlight: Boolean,
    dim: Boolean,
) {
    val cards = state.tableau[col]
    val alpha = when {
        highlight -> 1f
        dim -> 0.35f
        else -> 1f
    }

    Box(
        modifier = Modifier
            .width(cardW)
            .alpha(alpha)
            .onGloballyPositioned { coords ->
                val pos = coords.positionInRoot()
                val rect = Rect(pos, Size(coords.size.width.toFloat(), coords.size.height.toFloat()))
                pileRects.set(PileId.Tableau(col), rect)
            }
    ) {
        if (cards.isEmpty()) {
            EmptyTableauSlot(cardW, cardH, highlight, dim)
        } else {
            // Classic FreeCell overlap: each next card is shifted down by gapY,
            // so only the top portion of hidden cards remains visible.
            val stackH = cardH + (gapY * (cards.size - 1))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(stackH),
                contentAlignment = Alignment.TopCenter,
            ) {
                for (i in cards.indices) {
                    val card = cards[i]
                    val start = CardRef(PileId.Tableau(col), i)
                    val canStart = analysis.movableStarts.contains(start)
                    val activeDrag = drag.value
                    val ghost = activeDrag?.start?.pile == PileId.Tableau(col) && i >= activeDrag.start.index

                    Box(
                        modifier = Modifier
                            .offset(y = gapY * i)
                    ) {
                        DraggableCardStart(
                            start = start,
                            cards = cards.subList(i, cards.size),
                            analysis = analysis,
                            drag = drag,
                            pileRects = pileRects,
                            enabled = canStart,
                            onMove = onMove,
                        ) {
                            CardFace(
                                card = card,
                                width = cardW,
                                height = cardH,
                                dim = !canStart && !ghost,
                                modifier = Modifier.alpha(if (ghost) 0.25f else 1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun EmptyTableauSlot(cardW: Dp, cardH: Dp, highlight: Boolean, dim: Boolean) {
    val alpha = when {
        highlight -> 1f
        dim -> 0.35f
        else -> 1f
    }
    Box(
        modifier = Modifier
            .width(cardW)
            .height(cardH)
            .alpha(alpha)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 2.dp,
                color = if (highlight) Color(0xFFF2E8D5) else Color(0x44F2E8D5),
                shape = RoundedCornerShape(12.dp)
            )
            .background(Color(0x0D000000)),
    )
}

@Composable
private fun DraggableCardStart(
    start: CardRef,
    cards: List<Card>,
    analysis: Analysis,
    drag: MutableState<DragState?>,
    pileRects: PileRects,
    enabled: Boolean = true,
    onMove: (Move) -> Unit,
    content: @Composable () -> Unit,
) {
    val moves = analysis.movesFrom[start].orEmpty()
    var topLeftRoot by remember { mutableStateOf(Offset.Zero) }
    Box(
        modifier = Modifier
            .onGloballyPositioned { coords ->
                topLeftRoot = coords.positionInRoot()
            }
            .pointerInput(enabled, moves) {
                if (!enabled || moves.isEmpty()) return@pointerInput
                detectDragGestures(
                    onDragStart = { offset ->
                        val pointer = topLeftRoot + offset
                        drag.value = DragState(
                            start = start,
                            cards = cards,
                            moves = moves,
                            grabOffsetLocal = offset,
                            pointer = pointer,
                            hoverPile = pileRects.hitTest(pointer),
                        )
                    },
                    onDragEnd = {
                        val d = drag.value
                        val dropId = d?.hoverPile
                        val move = if (d != null && dropId != null) d.moves.firstOrNull { it.to == dropId } else null
                        if (move != null) onMove(move)
                        drag.value = null
                    },
                    onDragCancel = { drag.value = null },
                    onDrag = { change, amount ->
                        change.consume()
                        val cur = drag.value
                        if (cur != null) {
                            val pointer = cur.pointer + amount
                            val hover = pileRects.hitTest(pointer)
                            drag.value = cur.copy(pointer = pointer, hoverPile = hover)
                        }
                    }
                )
            }
    ) {
        content()
    }
}

@Composable
private fun CardFace(
    card: Card,
    width: Dp,
    height: Dp,
    dim: Boolean = false,
    modifier: Modifier = Modifier,
) {
    val vector = card.toPlayingCardVector()

    // SVG source used a 167.09 x 242.67 viewport.
    // Reference SVG (7_of_spades.svg) places the top-left rank at x=8.5467014, y=28.013288 with font-size 32px.
    val viewportW = 167.09f
    val viewportH = 242.67f
    val rankX = 8.5467014f
    val rankBaselineY = 28.013288f
    val rankFontSizePx = 32f

    // Compose Text uses sp, and SVG uses px; approximate by scaling off card height.
    // Tuned to match the SVG rank size visually.
    val rankFontSize = (height.value * (rankFontSizePx * 0.94f / viewportH)).sp
    val insetX = width * (rankX / viewportW)
    // Compose offset is top-left; SVG y is baseline. Use an ascent factor tuned to match the SVG.
    val insetTop = (height * (rankBaselineY / viewportH)) - (height * ((rankFontSizePx * 1.02f) / viewportH))

    val rankText = when (card.rank) {
        1 -> "A"
        11 -> "J"
        12 -> "Q"
        13 -> "K"
        else -> card.rank.toString()
    }
    val dimScale = if (dim) 0.72f else 1f
    val rankColorBase = if (card.isRed) Color(0xFFDF0000) else Color.Black
    val rankColor = Color(
        red = rankColorBase.red * dimScale,
        green = rankColorBase.green * dimScale,
        blue = rankColorBase.blue * dimScale,
        alpha = 1f,
    )

    val dimFilter = if (dim) {
        ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(dimScale, dimScale, dimScale, 1f) })
    } else {
        null
    }

    Box(
        modifier = modifier
            .width(width)
            .height(height)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Transparent)
            .border(1.dp, Color(0x22000000), RoundedCornerShape(12.dp)),
    ) {
        PlayingCardVector(
            vector = vector,
            colorFilter = dimFilter,
            modifier = Modifier.fillMaxSize(),
        )

        Text(
            text = rankText,
            color = rankColor,
            fontFamily = FontFamily.SansSerif,
            fontSize = rankFontSize,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.offset(x = insetX, y = insetTop),
        )

        Text(
            text = rankText,
            color = rankColor,
            fontFamily = FontFamily.SansSerif,
            fontSize = rankFontSize,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = -insetX, y = -insetTop)
                .graphicsLayer { rotationZ = 180f },
        )
    }
}

@Composable
private fun PlayingCardVector(
    vector: ImageVector,
    colorFilter: ColorFilter? = null,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = rememberVectorPainter(vector),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        colorFilter = colorFilter,
        modifier = modifier,
    )
}

private fun isHighlightingPile(d: DragState?, id: PileId): Boolean {
    if (d == null) return false
    return d.hoverPile == id && d.moves.any { it.to == id }
}

private fun isDimmingPile(d: DragState?, id: PileId): Boolean {
    if (d == null) return false
    return d.moves.none { it.to == id }
}
