package de.dukat.freecell_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import de.dukat.freecell_compose.freecell.*

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
        val library = remember { GameLibrary() }
        val libraryState by library.state.collectAsState()
        val backStack = remember { mutableStateListOf(Destination.Menu) }
        var store by remember { mutableStateOf<FreecellStore?>(null) }
        var boardGeneration by remember { mutableStateOf(0) }
        var sharedLink by remember { mutableStateOf<String?>(null) }
        var importError by remember { mutableStateOf<String?>(null) }
        val clipboard = LocalClipboardManager.current

        fun openGame(next: FreecellStore) {
            store = next
            boardGeneration++
            sharedLink = null
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
                else importError = "This game link is invalid or uses an unsupported format."
            }
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(when (backStack.last()) {
                        Destination.Menu -> "FreeCell"
                        Destination.Game -> "Game ${library.activeId ?: ""}"
                        Destination.Settings -> "Settings"
                    }, fontFamily = FontFamily.Serif) },
                    navigationIcon = {
                        if (backStack.size > 1) TextButton(onClick = ::goBack) {
                            Text(if (backStack.last() == Destination.Game) "Menu" else "Back")
                        }
                    },
                    actions = {
                        if (backStack.last() == Destination.Game) TextButton(onClick = {
                            sharedLink = null
                            backStack.add(Destination.Settings)
                        }) { Text("Settings") }
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
                                onStart = { openGame(library.start(it)) },
                                onRetry = { openGame(library.retry(it)) },
                                onImport = { link ->
                                    val game = decodeGameLink(link)
                                    if (game == null) importError = "Enter a valid FreeCell game link."
                                    else {
                                        importError = null
                                        openGame(library.importGame(game))
                                    }
                                },
                            )
                            Destination.Game -> store?.let { gameStore ->
                                key(boardGeneration) { GameBoard(gameStore, libraryState.automaticSafeMoves) }
                            }
                            Destination.Settings -> MenuPage {
                                Text("Game settings", style = MaterialTheme.typography.headlineMedium)
                                Row(verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text("Automatic safe moves", modifier = Modifier.weight(1f))
                                    Switch(checked = libraryState.automaticSafeMoves, onCheckedChange = library::setAutomaticSafeMoves)
                                }
                                Text("Move safe cards to the foundations automatically.", style = MaterialTheme.typography.bodyMedium)
                                Button(onClick = {
                                    store = library.restart()
                                    boardGeneration++
                                    sharedLink = null
                                    goBack()
                                }) { Text("Restart game") }
                                Text("Restart from the original deal. This remains the same game in your statistics.")
                                Button(onClick = {
                                    library.activeGame()?.let { sharedLink = gameShareLink(platformGameBaseUrl(), it.shared) }
                                }) { Text("Share game") }
                                sharedLink?.let { link ->
                                    Text("The link includes the original deal and your current position.")
                                    SelectionContainer { Text(link, style = MaterialTheme.typography.bodySmall) }
                                    Button(onClick = { clipboard.setText(AnnotatedString(link)) }) { Text("Copy link") }
                                }
                            }
                        }
                    }
                },
            )
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
    state: LibraryState, error: String?, onStart: (Int?) -> Unit,
    onRetry: (Int) -> Unit, onImport: (String) -> Unit,
) {
    var seed by remember { mutableStateOf("") }
    var link by remember { mutableStateOf("") }
    MenuPage {
        Text("A little space to play.", style = MaterialTheme.typography.headlineLarge, fontFamily = FontFamily.Serif)
        Text("Start a fresh deal or return to an unfinished game.")
        Card(Modifier.fillMaxWidth()) {
            Row(Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                Statistic("Played", state.played)
                Statistic("Won", state.won)
                Statistic("Abandoned", state.abandoned.size)
            }
        }
        OutlinedTextField(value = seed, onValueChange = { seed = it }, label = { Text("Seed (optional)") },
            singleLine = true, modifier = Modifier.fillMaxWidth(),
            isError = seed.isNotBlank() && seed.toIntOrNull() == null)
        Button(onClick = { onStart(seed.toIntOrNull()) }, modifier = Modifier.fillMaxWidth(),
            enabled = seed.isBlank() || seed.toIntOrNull() != null) { Text("Start") }
        Text("Abandoned games", style = MaterialTheme.typography.titleLarge)
        if (state.abandoned.isEmpty()) Text("No abandoned games yet.")
        else Text("Retry from the saved position. Winning removes the game from this list.")
        state.abandoned.asReversed().forEach { game ->
            OutlinedCard(Modifier.fillMaxWidth()) {
                Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Text("Game ${game.id}", style = MaterialTheme.typography.titleMedium)
                        Text("${game.currentState.foundations.values.sumOf { it.size }} / 52 cards home")
                    }
                    TextButton(onClick = { onRetry(game.id) }) { Text("Retry") }
                }
            }
        }
        HorizontalDivider()
        Text("Open a shared game", style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(value = link, onValueChange = { link = it }, label = { Text("Game link") }, modifier = Modifier.fillMaxWidth())
        error?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        OutlinedButton(onClick = { onImport(link) }, enabled = link.isNotBlank()) { Text("Open game") }
    }
}

@Composable
private fun Statistic(label: String, count: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(count.toString(), style = MaterialTheme.typography.headlineMedium)
        Text(label, style = MaterialTheme.typography.labelMedium)
    }
}
