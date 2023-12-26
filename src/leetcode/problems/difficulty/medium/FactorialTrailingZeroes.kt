package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 172. Factorial Trailing Zeroes
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/816/
 * https://leetcode.com/submissions/detail/1128798426/?from=explore&item_id=816
 */
class FactorialTrailingZeroes {

    companion object {
//        fun trailingZeroes(n: Int): Int {
//            if (n == 0) return 0
//            return (n / 5).run {
//                this + trailingZeroes(this)
//            }
//        }

        fun trailingZeroes(n: Int): Int {
            var res = 0
            @Suppress("NAME_SHADOWING")
            var n = n
            while (n > 0) {
                res += n / 5
                n /= 5
            }
            return res
        }
    }
}

fun main() {
    FactorialTrailingZeroes.trailingZeroes(0).println()
    FactorialTrailingZeroes.trailingZeroes(4).println()
    FactorialTrailingZeroes.trailingZeroes(5).println()
    FactorialTrailingZeroes.trailingZeroes(6).println()
    FactorialTrailingZeroes.trailingZeroes(7).println()
    FactorialTrailingZeroes.trailingZeroes(10).println()
}