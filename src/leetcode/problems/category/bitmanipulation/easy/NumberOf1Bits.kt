package leetcode.problems.category.bitmanipulation.easy

import kotlin1.println

/**
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/565/
 */
class NumberOf1Bits {
    companion object {
        fun hammingWeight(n: Int): Int {
            var out = 0
            var num = n
            while (num != 0) {
                out += (num and 1)
                num = num ushr 1
            }
            return out
        }
    }
}

fun main() {
    NumberOf1Bits.hammingWeight(521).println()
}