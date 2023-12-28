package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 371. Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/
 * https://leetcode.com/submissions/detail/1130393432/?from=explore&item_id=822
 */
class SumOfTwoIntegers {
    companion object {
        @Suppress("NAME_SHADOWING")
        fun getSum(a: Int, b: Int): Int {
            var a = a
            var b = b
            while (b != 0) {
                val carry = a and b
                a = a xor b
                b = carry shl 1

            }
            return a
        }
    }
}

fun main() {
    SumOfTwoIntegers.getSum(1, 2).println()
    SumOfTwoIntegers.getSum(2, 3).println()
}