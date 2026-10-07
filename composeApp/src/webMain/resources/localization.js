// Compose resources read navigator.languages. Preserve the browser's native
// languages for System default and expose the saved app override before startup.
(function () {
    var descriptor = Object.getOwnPropertyDescriptor(Navigator.prototype, 'languages');
    var supported = ['en', 'de', 'pt-BR', 'es'];
    var customLocale = null;
    try {
        var saved = localStorage.getItem('freecell-compose.language');
        if (supported.indexOf(saved) !== -1) customLocale = saved;
    } catch (_) {}
    if (descriptor && descriptor.get) {
        Object.defineProperty(Navigator.prototype, 'languages', Object.assign({}, descriptor, {
            get: function () { return customLocale ? [customLocale] : descriptor.get.call(this); }
        }));
    }
    function language() {
        var tag = (customLocale || navigator.languages[0] || navigator.language || 'en').toLowerCase();
        var code = tag.split('-')[0];
        return ['en', 'de', 'pt', 'es'].indexOf(code) !== -1 ? code : 'en';
    }
    function updateDocumentLanguage() {
        document.documentElement.lang = language() === 'pt' ? 'pt-BR' : language();
    }
    window.setFreecellLocale = function (value) {
        if (customLocale !== value) {
            customLocale = value;
            window.dispatchEvent(new Event('languagechange'));
        }
        updateDocumentLanguage();
    };
    var texts = {
        en: ['A new version of FreeCell is available. Reload now?', "You're offline", "FreeCell can still work offline once it's been loaded at least once while connected.", 'Try opening FreeCell', 'Retry', "Tip: When you're back online, the app will pick up new releases automatically.", 'FreeCell (Offline)'],
        de: ['Eine neue Version von FreeCell ist verfügbar. Jetzt neu laden?', 'Du bist offline', 'FreeCell funktioniert auch offline, nachdem es mindestens einmal mit Internetverbindung geladen wurde.', 'FreeCell öffnen', 'Erneut versuchen', 'Tipp: Sobald du wieder online bist, lädt die App neue Versionen automatisch.', 'FreeCell (Offline)'],
        pt: ['Uma nova versão do FreeCell está disponível. Recarregar agora?', 'Você está offline', 'O FreeCell funciona offline depois de ser carregado pelo menos uma vez com conexão à internet.', 'Tentar abrir o FreeCell', 'Tentar novamente', 'Dica: Quando você voltar a ficar online, o aplicativo receberá novas versões automaticamente.', 'FreeCell (Offline)'],
        es: ['Hay una nueva versión de FreeCell. ¿Recargar ahora?', 'Estás sin conexión', 'FreeCell funciona sin conexión después de haberse cargado al menos una vez con conexión a internet.', 'Intentar abrir FreeCell', 'Reintentar', 'Consejo: Cuando vuelvas a tener conexión, la aplicación recibirá nuevas versiones automáticamente.', 'FreeCell (Sin conexión)']
    };
    var keys = ['update', 'offline', 'offline_help', 'open', 'retry', 'hint', 'offline_title'];
    window.freecellWebText = function (key) { return texts[language()][keys.indexOf(key)]; };
    updateDocumentLanguage();
    window.addEventListener('languagechange', updateDocumentLanguage);
    document.querySelectorAll('[data-i18n]').forEach(function (node) {
        node.textContent = window.freecellWebText(node.dataset.i18n);
    });
    if (document.body.dataset.offline !== undefined) document.title = window.freecellWebText('offline_title');
})();
