package net.dangertree.dangerbot
/*
 * author: Matthew Taylor
 */
class BotLoader {
    def bot

    def load(text) {
        def config = new ConfigSlurper().parse(text)
        config.catches.each { catchItem ->
            if (!bot.catches."${catchItem.key}") bot.catches."${catchItem.key}" = []
            catchItem.value.each {
                bot.catches[catchItem.key] << it
            }
        }
        config.responses.each { responseItem ->
            if (!bot.responses."${responseItem.key}") bot.responses."${responseItem.key}" = []
            responseItem.value.each {
                bot.responses[responseItem.key] << it
            }
        }
    }
}