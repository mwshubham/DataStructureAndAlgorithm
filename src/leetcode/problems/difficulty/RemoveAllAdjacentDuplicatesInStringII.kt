package leetcode.problems.difficulty

import java.lang.StringBuilder
import java.util.*

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3710/
 */

class CustomPair(
    val char: Char,
    var count: Int
)

class RemoveAllAdjacentDuplicatesInStringII {
    /**
     * Using CustomPair
     * Runtime: 212 ms, faster than 73.33% of Kotlin online submissions for Remove All Adjacent Duplicates in String II.
     * Memory Usage: 36.3 MB, less than 73.33% of Kotlin online submissions for Remove All Adjacent Duplicates in String II.
     *
     * https://leetcode.com/submissions/detail/481293190/?from=explore&item_id=3710
     */
    fun removeDuplicates2(s: String, k: Int): String {
        val stack = Stack<CustomPair>()
        s.forEach {
            if (stack.isEmpty()) {
                stack.push(CustomPair(it, 1))
            } else {
                val peek = stack.peek()
                if (peek.char == it) {
                    if (peek.count == k - 1) {
                        stack.pop()
                    } else {
                        peek.count++
                    }
                } else {
                    stack.push(CustomPair(it, 1))
                }
            }
        }
        val stringBuilder = StringBuilder()
        stack.forEach {
            for (count in 1..it.count) {
                stringBuilder.append(it.char)
            }
        }
        return stringBuilder.toString()
    }


    /**
     * Using Stack and Pair
     * Runtime: 248 ms, faster than 60.00% of Kotlin online submissions for Remove All Adjacent Duplicates in String II.
     * Memory Usage: 36.9 MB, less than 60.00% of Kotlin online submissions for Remove All Adjacent Duplicates in String II.
     */
    fun removeDuplicates(s: String, k: Int): String {
        val stack = Stack<Pair<Char, Int>>()
        s.forEach {
            if (stack.isEmpty()) {
                stack.push(Pair(it, 1))
            } else {
                val peek = stack.peek()
                if (peek.first == it) {
                    if (peek.second == k - 1) {
                        stack.pop()
                    } else {
                        stack.pop()
                        stack.push(Pair(it, peek.second + 1))
                    }
                } else {
                    stack.push(Pair(it, 1))
                }
            }
        }
        val stringBuilder = StringBuilder()
        stack.forEach {
            for (count in 1..it.second) {
                stringBuilder.append(it.first)
            }
        }
        return stringBuilder.toString()
    }
}