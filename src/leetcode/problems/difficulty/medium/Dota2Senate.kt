package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 649. Dota2 Senate
 * https://leetcode.com/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Dota2Senate {

    fun predictPartyVictory3(senate: String): String {
        val mainQ = ArrayDeque<Char>()
        var numR = 0
        var banR = 0
        var numD = 0
        var banD = 0
        for (c in senate) {
            if (c == 'R') numR++ else numD++
            mainQ.addLast(c)
        }

        while (numR > 0 && numD > 0) {
            val main = mainQ.removeFirst()
            if (main == 'R') {
                if (banR > 0) {
                    banR--
                } else {
                    banD++
                    numD--
                    mainQ.addLast('R')
                }
            } else {
                if (banD > 0) {
                    banD--
                } else {
                    banR++
                    numR--
                    mainQ.addLast('D')
                }
            }
        }
        return if (numR > 0) "Radiant" else "Dire"
    }

    fun predictPartyVictory2(senate: String): String {
        val mainQ = ArrayDeque<Char>()
        val rQ = ArrayDeque<Char>()
        val dQ = ArrayDeque<Char>()

        for (c in senate) {
            mainQ.addLast(c)
        }

        while (mainQ.isNotEmpty()) {
            val main = mainQ.removeFirst()
            if (main == 'R') {
                if (dQ.isEmpty()) {
                    rQ.addLast(main)
                } else {
                    mainQ.addLast(dQ.removeFirst())
                }
            } else {
                if (rQ.isEmpty()) {
                    dQ.addLast(main)
                } else {
                    mainQ.addLast(rQ.removeFirst())
                }
            }
        }
        return if (dQ.isEmpty()) "Radiant" else "Dire"
    }

    // This might work in case of next item only.
    fun predictPartyVictory(senate: String): String {
        val queue = ArrayDeque<Char>()
        if (senate.length == 1) return if (senate == "R") "Radiant" else "Dire"
        if (senate.length == 2) return if (senate[0] == 'R') "Radiant" else "Dire"

        var rCount = 0
        var dCount = 0

        for (c in senate) {
            queue.addLast(c)

            if (c == 'R') rCount++
            else dCount++
        }

        if (dCount == 0) return "Radiant"
        if (rCount == 0) return "Dire"

        while (rCount > 0 && dCount > 0) {
            val current = queue.removeFirst()
            var opponent = queue.removeFirst()
            while (opponent == current) {
                queue.addLast(opponent)
                opponent = queue.removeFirst()
            }
            if (current == 'R') {
                dCount--
            } else {
                rCount--
            }
            queue.addLast(current)
        }
        return if (dCount == 0) "Radiant" else "Dire"
    }
}

fun main() {
    Dota2Senate().apply {
//        predictPartyVictory("RD").println()
//        predictPartyVictory("DRD").println()
        predictPartyVictory("DDRRR").println()
    }
}
