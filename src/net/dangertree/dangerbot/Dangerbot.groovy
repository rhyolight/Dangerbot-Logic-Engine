package net.dangertree.dangerbot
/*
 * author: Matthew Taylor
 */
class Dangerbot {
    def responses = [:]
    def catches = [:]
    def random = new Random()

    def process(input) {
        def output
        catches.each { category, vals ->
            if (output) return
            vals.each { catchWord ->
                if (input.contains(catchWord)) {
                    output = doReplace(randomResponseFor(category), catchWord)
                }
            }
        }
        output
    }

    private randomResponseFor(category) {
        def randomIndex = random.nextInt(responses[category].size())
        responses[category][randomIndex]
    }

    private doReplace(input, catchWord) {
        if (!input) return
        input.replaceAll('%R%', catchWord)
    }
}