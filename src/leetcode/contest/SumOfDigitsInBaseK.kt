package leetcode.contest

import kotlin1.println

/**
 * 5738. Sum of Digits in Base K
 * https://leetcode.com/contest/weekly-contest-238/problems/sum-of-digits-in-base-k/
 * https://leetcode.com/contest/weekly-contest-238/submissions/detail/484827731/
 */
class SumOfDigitsInBaseK {
    companion object {
        fun sumBase(n: Int, k: Int): Int {
            var sum = 0
            var num = Integer.parseInt(n.toString(), 10).toString(k).toInt()
            while (num > 0) {
                sum += num % 10
                num /= 10
            }
            return sum
        }
    }
}

fun main() {
    SumOfDigitsInBaseK.sumBase(34, 6).println()
    SumOfDigitsInBaseK.sumBase(10, 10).println()
}