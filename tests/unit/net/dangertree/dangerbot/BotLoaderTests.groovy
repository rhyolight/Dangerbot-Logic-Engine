package net.dangertree.dangerbot
/*
 * author: Matthew Taylor
 */
class BotLoaderTests extends GroovyTestCase {

    void testLoadText() {
        def bot = new Dangerbot()
        loadForTest(bot)
        assertEquals 3, bot.catches.size()
        assertEquals 2, bot.catches.cuss.size()
        assertEquals 3, bot.responses.size()
        assertEquals 5, bot.responses.cuss.size()
    }

    static void loadForTest(bot) {
        def botLoader = new BotLoader(bot:bot)
        botLoader.load(TEXT)
    }

    static final TEXT = """\
catches {
    cuss = ['damn', 'hell']
    insult = ['bastard']
    food = ['pickle', 'hot dog']
}
responses {
    cuss = ['cuss 1', 'cuss 2', 'cuss 3', 'cuss 4', 'cuss 5']
    insult = ['insult 1', 'insult 2', 'insult 3', 'insult 4', 'insult 5']
    food = ['that %R% is good']
}
"""
}