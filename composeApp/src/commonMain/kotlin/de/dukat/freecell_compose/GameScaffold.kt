package de.dukat.freecell_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import de.dukat.freecell_compose.freecell.*
import de.dukat.freecell_compose.ui.ActionIcons
import freecell_compose.composeapp.generated.resources.*
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

private enum class Destination { Menu, Game, Settings }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    MaterialTheme(colorScheme = darkColorScheme(
        primary = Color(0xFFE4D1A5), onPrimary = Color(0xFF203D34),
        surface = Color(0xFF173E33), background = Color(0xFF102F28),
        onSurface = Color(0xFFF5EDDD), onBackground = Color(0xFFF5EDDD),
        onSurfaceVariant = Color(0xFFD0D9CE), outline = Color(0xFF789387),
    )) {
        var language by remember { mutableStateOf(loadAppLanguage()) }
        val library = remember { GameLibrary() }
        val libraryState by library.state.collectAsState()
        val backStack = remember { mutableStateListOf(Destination.Menu) }
        var store by remember { mutableStateOf<FreecellStore?>(null) }
        var boardGeneration by remember { mutableStateOf(0) }
        var importError by remember { mutableStateOf<StringResource?>(null) }

        fun openGame(next: FreecellStore) {
            store = next
            boardGeneration++
            backStack.clear()
            backStack.addAll(listOf(Destination.Menu, Destination.Game))
        }
        fun goBack() {
            if (backStack.last() == Destination.Game) library.leaveGame()
            if (backStack.size > 1) backStack.removeAt(backStack.lastIndex)
        }
        LaunchedEffect(Unit) {
            platformIncomingGameLink()?.let { link ->
                val game = decodeGameLink(link)
                if (game != null) openGame(library.importGame(game))
                else importError = Res.string.invalid_link
            }
        }

        CompositionLocalProvider(LocalAppLocale provides language.tag) {
            key(language) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(when (backStack.last()) {
                                Destination.Menu -> stringResource(Res.string.app_name)
                                Destination.Game -> stringResource(Res.string.game_number, library.activeId ?: "")
                                Destination.Settings -> stringResource(Res.string.settings)
                            }, fontFamily = FontFamily.Serif) },
                            navigationIcon = {
                                if (backStack.size > 1) IconButton(onClick = ::goBack) {
                                    Icon(ActionIcons.Back, contentDescription = stringResource(
                                        if (backStack.last() == Destination.Game) Res.string.menu else Res.string.back))
                                }
                            },
                            actions = {
                                if (backStack.last() != Destination.Settings) IconButton(onClick = {
                                    backStack.add(Destination.Settings)
                                }) { Icon(ActionIcons.Settings, contentDescription = stringResource(Res.string.settings)) }
                            },
                        )
                    },
                ) { padding ->
                    NavDisplay(
                        backStack = backStack,
                        onBack = ::goBack,
                        entryDecorators = emptyList(),
                        modifier = Modifier.fillMaxSize().padding(padding),
                        entryProvider = { destination ->
                            NavEntry(destination) {
                                when (destination) {
                                    Destination.Menu -> MainMenu(
                                        libraryState, importError,
                                        onStart = { openGame(library.start()) },
                                        onRetry = { openGame(library.retry(it)) },
                                        onImport = { link ->
                                            val game = decodeGameLink(link)
                                            if (game == null) importError = Res.string.enter_valid_link
                                            else {
                                                importError = null
                                                openGame(library.importGame(game))
                                            }
                                        },
                                    )
                                    Destination.Game -> store?.let { gameStore ->
                                        key(boardGeneration) {
                                            GameScreen(gameStore, libraryState, library.activeGame(), onNewGame = { openGame(library.start()) })
                                        }
                                    }
                                    Destination.Settings -> MenuPage {
                                        LanguageSettings(language) {
                                            saveAppLanguage(it)
                                            language = it
                                        }
                                        HorizontalDivider()
                                        Text(stringResource(Res.string.game_settings), style = MaterialTheme.typography.headlineMedium)
                                        Row(verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                            Text(stringResource(Res.string.automatic_safe_moves), modifier = Modifier.weight(1f))
                                            val automaticMovesLabel = stringResource(Res.string.automatic_safe_moves)
                                            Switch(checked = libraryState.automaticSafeMoves, onCheckedChange = library::setAutomaticSafeMoves,
                                                modifier = Modifier.semantics { contentDescription = automaticMovesLabel })
                                        }
                                        Text(stringResource(Res.string.automatic_safe_moves_help), style = MaterialTheme.typography.bodyMedium)
                                        if (backStack.contains(Destination.Game)) {
                                            Button(onClick = {
                                                store = library.restart()
                                                boardGeneration++
                                                goBack()
                                            }) { Text(stringResource(Res.string.restart_game)) }
                                            Text(stringResource(Res.string.restart_help))
                                            GameSharing(library.activeGame())
                                        }
                                    }
                                }
                            }
                        },
                    )
                }
            }
        }
    }
}

@Composable
private fun LanguageSettings(language: AppLanguage, onChange: (AppLanguage) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Text(stringResource(Res.string.language), style = MaterialTheme.typography.headlineMedium)
    Text(stringResource(Res.string.language_help))
    Box {
        OutlinedButton(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
            Text(if (language == AppLanguage.System) stringResource(Res.string.system_default) else language.label)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            AppLanguage.entries.forEach { option ->
                DropdownMenuItem(
                    text = { Text(if (option == AppLanguage.System) stringResource(Res.string.system_default) else option.label) },
                    onClick = { expanded = false; onChange(option) },
                )
            }
        }
    }
}

@Composable
private fun GameScreen(store: FreecellStore, libraryState: LibraryState, game: SavedGame?, onNewGame: () -> Unit) {
    var showCompletion by remember { mutableStateOf(false) }
    GameBoard(store, libraryState.automaticSafeMoves, onGameWon = { showCompletion = true })
    if (showCompletion) {
        AlertDialog(
            onDismissRequest = { showCompletion = false },
            title = { Text(stringResource(Res.string.you_won), fontFamily = FontFamily.Serif) },
            text = {
                Column(Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(stringResource(Res.string.win_message))
                    Text(stringResource(Res.string.overall_statistics), style = MaterialTheme.typography.titleMedium)
                    OverallStatistics(libraryState)
                    GameSharing(game)
                }
            },
            confirmButton = { Button(onClick = onNewGame) { Text(stringResource(Res.string.new_game)) } },
            dismissButton = { TextButton(onClick = { showCompletion = false }) { Text(stringResource(Res.string.view_board)) } },
        )
    }
}

@Composable
private fun GameSharing(game: SavedGame?) {
    if (game == null) return
    var link by remember(game.id) { mutableStateOf<String?>(null) }
    var field by remember(game.id) { mutableStateOf(TextFieldValue()) }
    var copyStatus by remember(game.id) { mutableStateOf<StringResource?>(null) }
    val focusRequester = remember { FocusRequester() }

    fun copyLink(value: String) {
        copyStatus = null
        copyGameLinkToClipboard(value) { copied ->
            copyStatus = if (copied) Res.string.copied else Res.string.copy_failed
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(onClick = {
            val value = gameShareLink(platformGameBaseUrl(), game.shared)
            link = value
            field = TextFieldValue(value, TextRange(0, value.length))
            copyLink(value)
        }) { Text(stringResource(Res.string.share_game)) }
        link?.let { value ->
            Text(stringResource(Res.string.share_help))
            Box {
                OutlinedTextField(
                    value = field,
                    onValueChange = { field = field.copy(selection = it.selection) },
                    readOnly = true,
                    label = { Text(stringResource(Res.string.game_link)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().focusRequester(focusRequester),
                )
                Box(Modifier.matchParentSize().clickable(onClickLabel = stringResource(Res.string.copy_game_link)) {
                    focusRequester.requestFocus()
                    field = TextFieldValue(value, TextRange(0, value.length))
                    copyLink(value)
                })
            }
            copyStatus?.let { status ->
                Text(stringResource(status), style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.semantics { liveRegion = LiveRegionMode.Polite })
            }
        }
    }
}

@Composable
private fun MenuPage(content: @Composable ColumnScope.() -> Unit) {
    Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Color(0xFF214F42), Color(0xFF102F28))))) {
        Column(
            Modifier.align(Alignment.TopCenter).widthIn(max = 600.dp).fillMaxWidth()
                .verticalScroll(rememberScrollState()).padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp), content = content,
        )
    }
}

@Composable
private fun MainMenu(
    state: LibraryState, error: StringResource?, onStart: () -> Unit,
    onRetry: (Int) -> Unit, onImport: (String) -> Unit,
) {
    var link by remember { mutableStateOf("") }
    MenuPage {
        Text(stringResource(Res.string.menu_heading), style = MaterialTheme.typography.headlineLarge, fontFamily = FontFamily.Serif)
        Text(stringResource(Res.string.menu_help))
        OverallStatistics(state)
        Button(onClick = onStart, modifier = Modifier.fillMaxWidth()) { Text(stringResource(Res.string.start)) }
        Text(stringResource(Res.string.abandoned_games), style = MaterialTheme.typography.titleLarge)
        if (state.abandoned.isEmpty()) Text(stringResource(Res.string.no_abandoned_games))
        else Text(stringResource(Res.string.retry_help))
        state.abandoned.asReversed().forEach { game ->
            OutlinedCard(Modifier.fillMaxWidth()) {
                Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Text(stringResource(Res.string.game_number, game.id), style = MaterialTheme.typography.titleMedium)
                        Text(stringResource(Res.string.cards_home, game.currentState.foundations.values.sumOf { it.size }))
                    }
                    TextButton(onClick = { onRetry(game.id) }) { Text(stringResource(Res.string.retry)) }
                }
            }
        }
        HorizontalDivider()
        Text(stringResource(Res.string.open_shared_game), style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(value = link, onValueChange = { link = it }, label = { Text(stringResource(Res.string.game_link)) }, modifier = Modifier.fillMaxWidth())
        error?.let { Text(stringResource(it), color = MaterialTheme.colorScheme.error) }
        OutlinedButton(onClick = { onImport(link) }, enabled = link.isNotBlank()) { Text(stringResource(Res.string.open_game)) }
    }
}

@Composable
private fun OverallStatistics(state: LibraryState) {
    Card(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            Statistic(stringResource(Res.string.played), state.played)
            Statistic(stringResource(Res.string.won), state.won)
            Statistic(stringResource(Res.string.abandoned), state.abandoned.size)
        }
    }
}

@Composable
private fun Statistic(label: String, count: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(count.toString(), style = MaterialTheme.typography.headlineMedium)
        Text(label, style = MaterialTheme.typography.labelMedium)
    }
}
