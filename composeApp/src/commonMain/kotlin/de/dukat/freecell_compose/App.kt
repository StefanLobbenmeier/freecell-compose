package de.dukat.freecell_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import kotlinx.coroutines.delay
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.dukat.freecell_compose.ui.SimplifiedCardFace
import de.dukat.freecell_compose.ui.ClassicCardFace
import de.dukat.freecell_compose.freecell.model.Analysis
import de.dukat.freecell_compose.freecell.model.Card
import de.dukat.freecell_compose.freecell.model.CardRef
import de.dukat.freecell_compose.freecell.model.GameState
import de.dukat.freecell_compose.freecell.model.Move
import de.dukat.freecell_compose.freecell.model.PileId
import de.dukat.freecell_compose.freecell.model.Suit
import de.dukat.freecell_compose.freecell.FreecellStore
import kotlinx.coroutines.launch
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

private const val MOVE_ANIMATION_DURATION_MS = 240
private const val AUTO_MOVE_ANIMATION_DURATION_MS = (1.4 * MOVE_ANIMATION_DURATION_MS).toInt()
private const val AUTO_MOVE_DELAY_MS = 100L

private data class CardFaceProps(
    val showStackedHidden: Boolean = false,
    val dim: Boolean = false,
    val modifier: Modifier = Modifier,
)

private typealias CardFaceRenderer = @Composable (card: Card, props: CardFaceProps) -> Unit

@Composable
internal fun GameBoard(store: FreecellStore, automaticSafeMoves: Boolean, onGameWon: () -> Unit) {
    val ui by store.uiState.collectAsState()
    val state = ui.state
    val analysis = ui.analysis
    val message = ui.message
    val drag = remember { mutableStateOf<DragState?>(null) }
    val pileRects = remember { PileRects() }
    val cardRects = remember { CardRects() }
    var moveAnimations by remember { mutableStateOf<List<MoveAnimation>>(emptyList()) }
    val flyingCards = moveAnimations.flatMap { it.cards }.toSet()
    var boardOriginRoot by remember { mutableStateOf(Offset.Zero) }
    var autoSolveHold by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(state.isWon, moveAnimations.isEmpty()) {
        if (state.isWon && moveAnimations.isEmpty()) onGameWon()
    }

    fun animateMove(
        moveState: GameState,
        move: Move,
        durationMillis: Int = MOVE_ANIMATION_DURATION_MS,
        apply: () -> Unit,
    ) {
        val fromRect = cardRects.get(startForMove(moveState, move))
        val toRect = pileRects.get(move.to)
        val extracted = extractAutoMoveStack(moveState, move)
        apply()

        if (store.uiState.value.state == moveState || extracted == null || toRect == null || fromRect == null) return

        val progress = Animatable(0f)
        val animation = MoveAnimation(
            cards = extracted.cards,
            fromRect = fromRect,
            toRect = toRect,
            progress = progress,
        )
        moveAnimations = moveAnimations + animation
        scope.launch {
            try {
                progress.animateTo(
                    1f,
                    animationSpec = tween(durationMillis = durationMillis),
                )
            } finally {
                moveAnimations = moveAnimations.filterNot { it === animation }
            }
        }
    }

    LaunchedEffect(analysis.safeFoundationMoves.isNotEmpty(), drag.value != null, autoSolveHold, automaticSafeMoves) {
        if (drag.value != null) return@LaunchedEffect
        if (autoSolveHold || !automaticSafeMoves) return@LaunchedEffect

        while (store.uiState.value.analysis.safeFoundationMoves.isNotEmpty()) {
            delay(AUTO_MOVE_DELAY_MS)
            if (drag.value != null || autoSolveHold) return@LaunchedEffect
            val current = store.uiState.value
            val move = current.analysis.safeFoundationMoves.firstOrNull { candidate ->
                val cards = extractAutoMoveStack(current.state, candidate)?.cards.orEmpty()
                moveAnimations.none { animation -> animation.cards.any { it in cards } }
            } ?: continue
            animateMove(
                moveState = current.state,
                move = move,
                durationMillis = AUTO_MOVE_ANIMATION_DURATION_MS,
            ) {
                store.tryAutoMove(move)
            }
        }
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF214F42), Color(0xFF102F28))))
    ) {
        val portrait = maxHeight > maxWidth
        val pagePadding = when {
            maxWidth < 340.dp -> 4.dp
            maxWidth < 420.dp -> 8.dp
            else -> 16.dp
        }

        // Keep all 8 tableau columns visible by scaling the whole board's measurements.
        // In portrait, make cards slimmer and increase stack spacing relative to card height
        // so hidden cards remain readable.
        val baseCardW = if (portrait) 70.dp else 104.dp
        // Mobile: aspect ratio 2:3.
        val baseCardH = if (portrait) (baseCardW * 1.5f) else (baseCardW * (112f / 80f))
        val baseGapX = if (portrait) 4.dp else 10.dp
        val baseTableGapY = if (portrait) 18.dp else 22.dp
        // Mobile: keep a full header visible for stacked cards.
        val baseStackGapY = if (portrait) (baseCardH / 3f) else 32.dp
        val requiredTableauW = (baseCardW * 8f) + (baseGapX * 7f)

        val availableW = (maxWidth - (pagePadding * 2f) - 1.dp).coerceAtLeast(0.dp)
        val fitScale = (availableW / requiredTableauW).coerceAtMost(1f)
        val s = fitScale.coerceAtLeast(0.06f)

        val cardW = baseCardW * s
        val cardH = baseCardH * s
        val gapX = baseGapX * s
        val tableGapY = baseTableGapY * s
        // Don't scale down the tableau overlap spacing; otherwise hidden cards become unreadable
        // when the board is scaled to fit slim screens.
        val stackGapY = baseStackGapY

        val cardCorner = cardCorner(cardW, cardH)
        val headerHMobile = (cardW * 0.74f).coerceAtMost(stackGapY - 2.dp)
        val headerHClassic = (cardW * 0.29f).coerceAtMost(stackGapY - 2.dp)

        // Scale borders with the board scale so they don't eat into content on slim screens.
        val slotBorderW = (2.dp * s).coerceIn(0.75.dp, 2.dp)
        val cardBorderW = (1.dp * s).coerceIn(0.5.dp, 1.dp)

        val renderCardFace: CardFaceRenderer = { card, props ->
            if (portrait) {
                SimplifiedCardFace(
                    card = card,
                    width = cardW,
                    height = cardH,
                    corner = cardCorner,
                    borderW = cardBorderW,
                    headerH = headerHMobile,
                    showLargePip = !props.showStackedHidden,
                    dim = props.dim,
                    modifier = props.modifier,
                )
            } else {
                ClassicCardFace(
                    card = card,
                    width = cardW,
                    height = cardH,
                    corner = cardCorner,
                    borderW = cardBorderW,
                    headerH = headerHClassic,
                    showArtwork = !props.showStackedHidden,
                    dim = props.dim,
                    modifier = props.modifier,
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(pagePadding)
                .onGloballyPositioned { coords ->
                    boardOriginRoot = coords.positionInRoot()
                }
        ) {
            Column(
                modifier = Modifier
                    .width(cardW * 8f + gapX * 7f)
                    .fillMaxHeight()
                    .align(Alignment.TopCenter)
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(if (state.isWon) "You won!" else "FreeCell", fontSize = 22.sp,
                        fontFamily = FontFamily.Serif, color = Color(0xFFF2E8D5))
                    Button(onClick = {
                        autoSolveHold = true
                        moveAnimations = emptyList()
                        drag.value = null
                        store.undo()
                    }, enabled = ui.canUndo) { Text("Undo") }
                }

                Spacer(Modifier.height(12.dp))

                if (message != null) {
                    Text(
                        text = message,
                        color = Color(0xFFF2E8D5),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                }

            fun tryMove(move: Move) {
                autoSolveHold = false
                store.tryMove(move)
            }

            fun tryClickMove(start: CardRef) {
                autoSolveHold = false
                if (drag.value != null) return

                val moveState = store.uiState.value.state
                val move = store.pickClickMove(start) ?: return
                val cards = extractAutoMoveStack(moveState, move)?.cards.orEmpty()
                if (moveAnimations.any { animation -> animation.cards.any { it in cards } }) return

                animateMove(moveState, move) {
                    store.tryMove(move)
                }
            }

                // Top row: freecells + foundations
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(gapX)) {
                    for (i in 0 until 4) {
                        PileSlot(
                            id = PileId.FreeCell(i),
                            cardW = cardW,
                            cardH = cardH,
                            slotBorderW = slotBorderW,
                            state = state,
                            analysis = analysis,
                            drag = drag,
                            pileRects = pileRects,
                            cardRects = cardRects,
                            onMove = ::tryMove,
                            onClickMove = ::tryClickMove,
                            renderCardFace = renderCardFace,
                            highlight = isHighlightingPile(drag.value, PileId.FreeCell(i)),
                            dim = isDimmingPile(drag.value, PileId.FreeCell(i)),
                            flyingCards = flyingCards,
                        )
                    }
                }

                    Row(horizontalArrangement = Arrangement.spacedBy(gapX)) {
                    for (suit in Suit.entries) {
                        PileSlot(
                            id = PileId.Foundation(suit),
                            cardW = cardW,
                            cardH = cardH,
                            slotBorderW = slotBorderW,
                            state = state,
                            analysis = analysis,
                            drag = drag,
                            pileRects = pileRects,
                            cardRects = cardRects,
                            onMove = ::tryMove,
                            onClickMove = ::tryClickMove,
                            renderCardFace = renderCardFace,
                            highlight = isHighlightingPile(drag.value, PileId.Foundation(suit)),
                            dim = isDimmingPile(drag.value, PileId.Foundation(suit)),
                            flyingCards = flyingCards,
                        )
                    }
                }
                }

            Spacer(Modifier.height(tableGapY))

                // Tableaus
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(gapX),
                ) {
                for (col in 0 until 8) {
                    TableauColumn(
                         col = col,
                         cardW = cardW,
                         cardH = cardH,
                         gapY = stackGapY,
                         slotBorderW = slotBorderW,
                         state = state,
                         analysis = analysis,
                          drag = drag,
                          pileRects = pileRects,
                          cardRects = cardRects,
                          onMove = ::tryMove,
                          onClickMove = ::tryClickMove,
                           renderCardFace = renderCardFace,
                           highlight = isHighlightingPile(drag.value, PileId.Tableau(col)),
                           dim = isDimmingPile(drag.value, PileId.Tableau(col)),
                           flyingCards = flyingCards,
                      )
                 }
                }
        }

            // Keep each move overlay independent while its animation runs.
            for (a in moveAnimations) {
                val t = a.progress.value.coerceIn(0f, 1f)
                val from = a.fromRect.topLeft - boardOriginRoot
                val to = a.toRect.topLeft - boardOriginRoot
                val pos = Offset(
                    x = from.x + (to.x - from.x) * t,
                    y = from.y + (to.y - from.y) * t,
                )
                Box(
                    modifier = Modifier
                        .offset { IntOffset(pos.x.roundToInt(), pos.y.roundToInt()) }
                        .alpha(0.98f)
                ) {
                    val stackH = if (a.cards.isEmpty()) cardH else (cardH + (stackGapY * (a.cards.size - 1)))
                    Box(
                        modifier = Modifier
                            .width(cardW)
                            .height(stackH)
                    ) {
                        for ((i, card) in a.cards.withIndex()) {
                            renderCardFace(
                                card,
                                CardFaceProps(
                                    modifier = Modifier.offset(y = stackGapY * i),
                                )
                            )
                        }
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
                            renderCardFace(
                                card,
                                CardFaceProps(
                                    modifier = Modifier.offset(y = stackGapY * i),
                                )
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
    val cardSizePx: Size,
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

    fun get(id: PileId): Rect? = rects[id]
}

private fun pickBestDropTarget(
    pileRects: PileRects,
    moves: List<Move>,
    draggedRect: Rect,
    leewayPx: Float,
): PileId? {
    if (moves.isEmpty()) return null

    val dc = draggedRect.center
    var best: Pair<PileId, Float>? = null

    for (id in moves.asSequence().map { it.to }.distinct()) {
        val r = pileRects.get(id) ?: continue
        val expanded = Rect(
            left = r.left - leewayPx,
            top = r.top - leewayPx,
            right = r.right + leewayPx,
            bottom = r.bottom + leewayPx,
        )

        // Require intersection with an expanded target so cancelling is possible.
        val overlapW = min(draggedRect.right, expanded.right) - max(draggedRect.left, expanded.left)
        val overlapH = min(draggedRect.bottom, expanded.bottom) - max(draggedRect.top, expanded.top)
        if (overlapW <= 0f || overlapH <= 0f) continue

        val rc = expanded.center
        val dist2 = (dc.x - rc.x) * (dc.x - rc.x) + (dc.y - rc.y) * (dc.y - rc.y)
        if (best == null || dist2 < best.second) best = id to dist2
    }

    return best?.first
}

private class CardRects {
    private val rects: MutableMap<CardRef, Rect> = linkedMapOf()

    fun set(ref: CardRef, rect: Rect) {
        rects[ref] = rect
    }

    fun get(ref: CardRef?): Rect? {
        if (ref == null) return null
        return rects[ref]
    }
}

private data class MoveAnimation(
    val cards: List<Card>,
    val fromRect: Rect,
    val toRect: Rect,
    val progress: Animatable<Float, *>,
)

private data class AutoMoveStack(
    val from: CardRef,
    val cards: List<Card>,
)

private fun extractAutoMoveStack(state: GameState, move: Move): AutoMoveStack? {
    return when (val from = move.from) {
        is PileId.Tableau -> {
            val col = state.tableau[from.index]
            if (move.fromIndex !in col.indices) return null
            val cards = col.subList(move.fromIndex, col.size)
            if (cards.size != move.count) return null
            AutoMoveStack(from = CardRef(from, move.fromIndex), cards = cards)
        }

        is PileId.FreeCell -> {
            val card = state.freeCells[from.index] ?: return null
            AutoMoveStack(from = CardRef(from, 0), cards = listOf(card))
        }

        is PileId.Foundation -> {
            val card = state.foundations.getValue(from.suit).lastOrNull() ?: return null
            AutoMoveStack(from = CardRef(from, 0), cards = listOf(card))
        }
    }
}

private fun startForMove(state: GameState, move: Move): CardRef? = extractAutoMoveStack(state, move)?.from

@Composable
private fun PileSlot(
    id: PileId,
    title: String = "",
    cardW: Dp,
    cardH: Dp,
    slotBorderW: Dp,
    state: GameState,
    analysis: Analysis,
    drag: MutableState<DragState?>,
    pileRects: PileRects,
    cardRects: CardRects,
    onMove: (Move) -> Unit,
    onClickMove: (CardRef) -> Unit,
    renderCardFace: CardFaceRenderer,
    highlight: Boolean,
    dim: Boolean,
    flyingCards: Set<Card>,
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

    val corner = RoundedCornerShape(cardCorner(cardW, cardH))

    Box(
        modifier = Modifier
            .width(cardW)
            .height(cardH)
            .alpha(alpha)
            .clip(corner)
            .border(
                width = slotBorderW,
                color = if (highlight) Color(0xFFF2E8D5) else Color(0x55F2E8D5),
                shape = corner
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
            val flying = card in flyingCards
            val visibleCard = when (id) {
                is PileId.Foundation -> state.foundations.getValue(id.suit).lastOrNull { it !in flyingCards }
                else -> card.takeUnless { flying }
            }
            val ghost = drag.value?.start?.pile == id
            DraggableCardStart(
                start = CardRef(id, 0),
                cards = listOf(card),
                analysis = analysis,
                drag = drag,
                pileRects = pileRects,
                cardRects = cardRects,
                enabled = canStart && !flying,
                onMove = onMove,
                onClickMove = onClickMove,
            ) {
                renderCardFace(
                    visibleCard ?: card,
                    CardFaceProps(
                        dim = !canStart && !ghost && !flying,
                        modifier = Modifier.alpha(
                            when {
                                visibleCard == null -> 0f
                                ghost -> 0.25f
                                else -> 1f
                            }
                        ),
                    )
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
    slotBorderW: Dp,
    state: GameState,
    analysis: Analysis,
    drag: MutableState<DragState?>,
    pileRects: PileRects,
    cardRects: CardRects,
    onMove: (Move) -> Unit,
    onClickMove: (CardRef) -> Unit,
    renderCardFace: CardFaceRenderer,
    highlight: Boolean,
    dim: Boolean,
    flyingCards: Set<Card>,
) {
    val cards = state.tableau[col]
    val pileId = PileId.Tableau(col)
    val density = LocalDensity.current
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
                // Drop target is the next empty position below the current stack.
                // Using the full column rect makes hover selection too eager in slim layouts.
                val cardWpx = with(density) { cardW.toPx() }
                val cardHpx = with(density) { cardH.toPx() }
                val gapPx = with(density) { gapY.toPx() }
                val dropTopLeft = pos + Offset(0f, gapPx * cards.size)
                pileRects.set(pileId, Rect(dropTopLeft, Size(cardWpx, cardHpx)))
            }
    ) {
        // Classic FreeCell overlap: each next card is shifted down by gapY,
        // so only the top portion of hidden cards remains visible.
        val stackH = cardH + (gapY * (cards.size - 1)).coerceAtLeast(cardH)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(stackH),
            contentAlignment = Alignment.TopCenter,
        ) {
            EmptyTableauSlot(cardW, cardH, slotBorderW, highlight, dim)
             for (i in cards.indices) {
                 val card = cards[i]
                 val start = CardRef(pileId, i)
                 val canStart = analysis.movableStarts.contains(start)
                 val activeDrag = drag.value
                 val dragStartIndex = if (activeDrag?.start?.pile == pileId) activeDrag.start.index else null
                 val ghost = dragStartIndex != null && i >= dragStartIndex
                // If the card directly above is being dragged or is still in flight,
                // render this one with the full face so it becomes readable immediately.
                val aboveIsMoving = (dragStartIndex != null && dragStartIndex <= (i + 1)) ||
                    (cards.getOrNull(i + 1) in flyingCards)
                 val showStackedHidden = (i < cards.lastIndex) && !aboveIsMoving && !ghost
                 val faceAlpha = when {
                     card in flyingCards -> 0f
                     ghost -> 0.25f
                     else -> 1f
                 }

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
                        cardRects = cardRects,
                        enabled = canStart && cards.subList(i, cards.size).none { it in flyingCards },
                        onMove = onMove,
                        onClickMove = onClickMove,
                    ) {
                        renderCardFace(
                            card,
                            CardFaceProps(
                                showStackedHidden = showStackedHidden,
                                dim = !canStart && !ghost,
                                modifier = Modifier.alpha(faceAlpha),
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun EmptyTableauSlot(cardW: Dp, cardH: Dp, borderW: Dp, highlight: Boolean, dim: Boolean) {
    val alpha = when {
        highlight -> 1f
        dim -> 0.35f
        else -> 1f
    }
    val corner = RoundedCornerShape(cardCorner(cardW, cardH))
    Box(
        modifier = Modifier
            .width(cardW)
            .height(cardH)
            .alpha(alpha)
            .clip(corner)
            .border(
                width = borderW,
                color = if (highlight) Color(0xFFF2E8D5) else Color(0x44F2E8D5),
                shape = corner
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
    cardRects: CardRects,
    enabled: Boolean = true,
    onMove: (Move) -> Unit,
    onClickMove: (CardRef) -> Unit,
    content: @Composable () -> Unit,
) {
    val moves = analysis.movesFrom[start].orEmpty()
    var topLeftRoot by remember { mutableStateOf(Offset.Zero) }
    var sizePx by remember { mutableStateOf(Size.Zero) }
    Box(
        modifier = Modifier
            .onGloballyPositioned { coords ->
                topLeftRoot = coords.positionInRoot()
                sizePx = Size(coords.size.width.toFloat(), coords.size.height.toFloat())
                val rect = Rect(topLeftRoot, sizePx)
                cardRects.set(start, rect)
            }
            .clickable(enabled = enabled && moves.isNotEmpty()) {
                onClickMove(start)
            }
            .pointerInput(enabled, moves) {
                if (!enabled || moves.isEmpty()) return@pointerInput
                detectDragGestures(
                    onDragStart = { offset ->
                        val pointer = topLeftRoot + offset
                        val topLeft = pointer - offset
                        val draggedRect = Rect(topLeft, sizePx)
                        val leewayPx = (min(sizePx.width, sizePx.height) * 0.12f).coerceIn(6f, 18f)
                        val hover = pickBestDropTarget(pileRects, moves, draggedRect, leewayPx)
                        drag.value = DragState(
                            start = start,
                            cards = cards,
                            moves = moves,
                            grabOffsetLocal = offset,
                            pointer = pointer,
                            hoverPile = hover,
                            cardSizePx = sizePx,
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
                            val topLeft = pointer - cur.grabOffsetLocal
                            val draggedRect = Rect(topLeft, cur.cardSizePx)
                            val leewayPx = (min(cur.cardSizePx.width, cur.cardSizePx.height) * 0.12f).coerceIn(6f, 18f)
                            val hover = pickBestDropTarget(pileRects, cur.moves, draggedRect, leewayPx)
                            drag.value = cur.copy(pointer = pointer, hoverPile = hover)
                        }
                    }
                )
            }
    ) {
        content()
    }
}

private fun cardCorner(w: Dp, h: Dp): Dp =
    (minOf(w, h) * 0.065f).coerceIn(2.dp, 5.dp)

private fun isHighlightingPile(d: DragState?, id: PileId): Boolean {
    if (d == null) return false
    return d.hoverPile == id && d.moves.any { it.to == id }
}

private fun isDimmingPile(d: DragState?, id: PileId): Boolean {
    if (d == null) return false
    return d.moves.none { it.to == id }
}
