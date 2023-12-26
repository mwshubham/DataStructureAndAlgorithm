package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 * https://leetcode.com/problems/happy-number/submissions/
 * https://leetcode.com/problems/happy-number/submissions/1128788753/
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/815/
 */
class HappyNumber {

    companion object {

        private val set = HashSet<Int>()

        fun isHappy(n: Int): Boolean {
            val sum = digitSumSquare(n)
            if (sum == 1) return true
            if (set.contains(sum)) return false
            set.add(sum)
            return isHappy(sum)
        }

        fun isHappyWithoutSet(n: Int): Boolean {
            var slow = n
            var fast = n
            do {
                slow = digitSumSquare(slow)
                fast = digitSumSquare(fast)
                fast = digitSumSquare(fast)
            } while (slow != fast)
            // No Cycle
            return slow == 1
        }

        private fun digitSumSquare(num: Int): Int {
            var sum = 0
            @Suppress("NAME_SHADOWING") var num = num
            while (num != 0) {
                (num % 10).run {
                    sum += this * this
                }
                num /= 10
            }
            return sum
        }
    }
}

fun main() {
    HappyNumber.isHappyWithoutSet(19).println()
}