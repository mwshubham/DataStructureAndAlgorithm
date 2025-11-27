package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.LinkedList

/**
 * 1823. Find the Winner of the Circular Game
 * https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/
 */
class WinnerOfTheCircularGame {
    fun findTheWinner(n: Int, k: Int): Int {
        if (n == 1) return 1
        val list = LinkedList<Int>()
        for (i in 1..n) list.add(i)
        var start = 0
        repeat(n - 1) {
            "Current List: $list".println()
            start = (start + k - 1) % list.size
            "Index to remove: $start".println()
            list.removeAt(start)
            "After Removal List: $list".println()
        }
        return list.first()
    }
}

fun main() {
    WinnerOfTheCircularGame().apply {
        findTheWinner(5, 2).apply {
            "$this == 3, ${this == 3}".println()
        }
        findTheWinner(6, 5).apply {
            "$this == 1, ${this == 1}".println()
        }
    }
}



// 0, 1, 2, 3, 4
// 1, 2, 3, 4, 5, k = 2

// 0, 1, 2, 3
// 1, 3, 4, 5

// 0, 1, 2
// 1, 3, 5

// 0, 1
// 3, 5

// 0
// 3

// 1, 2, 3, 4, 5

// 1, 2, k = 2
// 2
