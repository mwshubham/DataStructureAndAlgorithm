package leetcode.problems.difficulty.medium

import kotlin.math.abs

/**
 * 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/description/
 * https://leetcode.com/problems/divide-two-integers/submissions/1138365153/
 */
class DivideTwoIntegers {

    companion object {
        fun divide(dividend: Int, divisor: Int): Int {
            var sign = 1
            if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
                sign = -1
            }
            val lDividend = abs(dividend.toLong())
            val lDivisor = abs(divisor.toLong())

            if (lDividend == 0L || lDividend < lDivisor) return 0
            if (lDivisor == 0L || (dividend == Int.MIN_VALUE && divisor == -1)) return Int.MAX_VALUE

            val res = divideHelper(lDividend, lDivisor)
            return if (res > Int.MAX_VALUE) {
                if (sign == 1) {
                    Int.MAX_VALUE
                } else {
                    Int.MIN_VALUE
                }
            } else {
                sign * res.toInt()
            }
        }

        private fun divideHelper(lDividend: Long, lDivisor: Long): Long {
            if (lDividend < lDivisor) return 0
            var sum = lDivisor
            var mult = 1
            while ((sum + sum) <= lDividend) {
                sum += sum
                mult += mult
            }
            return mult + divideHelper(lDividend - sum, lDivisor)
        }
    }
}

fun main() {
    DivideTwoIntegers.divide(Int.MIN_VALUE, -1)
}