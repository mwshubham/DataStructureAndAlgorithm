package leetcode.problems.array.medium

import java.util.*

// https://leetcode.com/problems/reveal-cards-in-increasing-order/
class RevealCardIncreasingOrder {

    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val result = IntArray(deck.size)
        deck.sort()
        val queue = LinkedList<Int>()
        (deck.indices).forEach { queue.add(it) }
        deck.forEachIndexed { index, value ->
            result[queue.poll()] = value
            queue.add(queue.poll())
        }
        return result
    }
}