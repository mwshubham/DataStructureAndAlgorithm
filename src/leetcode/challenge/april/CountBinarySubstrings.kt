package leetcode.challenge.april

import kotlin.math.min

/**
 * 696. Count Binary Substrings
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3718/
 * https://leetcode.com/problems/count-binary-substrings/
 *
 * https://leetcode.com/submissions/detail/484188104/?from=explore&item_id=3718
 */
class CountBinarySubstrings {

    companion object {
        /**
         * Runtime: 220 ms, faster than 80.00% of Kotlin online submissions for Count Binary Substrings.
         * Memory Usage: 36.7 MB, less than 40.00% of Kotlin online submissions for Count Binary Substrings.
         */
        fun countBinarySubstrings(s: String): Int {
            var pre = 0
            var curr = 1
            var res = 0
            for (i in 1..s.lastIndex) {
                if (s[i] == s[i - 1]) {
                    curr++
                } else {
                    res += min(pre, curr)
                    pre = curr
                    curr = 1
                }
            }
            return res + min(pre, curr)
        }
    }
}