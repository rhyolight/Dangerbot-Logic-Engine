package net.dangertree.dangerbot
/*
 * author: Matthew Taylor
 */
class DangerbotTests extends GroovyTestCase {

    def bot = new Dangerbot()

    void setUp() {
        BotLoaderTests.loadForTest(bot)
    }

    void testDangerbotTalksBack_onCuss() {
        def response = bot.process("How the hell are you?")
        assertTrue response in bot.responses.cuss
    }

    void testDangerbotIsSilent_noCuss() {
        def response = bot.process("How are you?")
        assertNull response
    }

    void testDangerbot_randomResponses() {
        def responses = [] as Set
        100.times {
            responses << bot.process(' oh damn ')
        }
        assertTrue responses.size() > 1
    }

    void testDangerbot_replacesWords() {
        def response = bot.process("what a good pickle today")
        assertEquals 'that pickle is good', response
        response = bot.process("what a good hot dog today")
        assertEquals 'that hot dog is good', response
    }

}