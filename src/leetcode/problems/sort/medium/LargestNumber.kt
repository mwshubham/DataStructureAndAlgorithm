package leetcode.problems.sort.medium

import java.util.*

/**
 * https://leetcode.com/problems/largest-number/
 * https://leetcode.com/problems/largest-number/submissions/
 *
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3472/
 * https://leetcode.com/submissions/detail/400841651/?from=/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3472/
 */
class LargestNumber {

    /**
     * Runtime: 188 ms, faster than 94.44% of Kotlin online submissions for Largest Number.
     * Memory Usage: 36.4 MB, less than 61.11% of Kotlin online submissions for Largest Number.
     */
    fun largestNumber(nums: IntArray): String {
        if (nums.isEmpty()) {
            return ""
        }
        val strArr = nums.map { it.toString() }.toTypedArray()
        Arrays.sort(strArr) { o1, o2 ->
            val s1 = o1 + o2
            val s2 = o2 + o1
            s2.compareTo(s1)
        }
        return strArr.let {
            if (it[0] == "0") {
                "0"
            } else {
                it.joinToString(separator = "")
            }
        }
    }
}