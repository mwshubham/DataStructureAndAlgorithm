package leetcode.problems.category.array.easy

import kotlin.math.abs

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3574/
 *
 * https://leetcode.com/submissions/detail/484478160/?from=explore&item_id=3240
 * https://leetcode.com/submissions/detail/484999061/?from=explore&item_id=3574
 */
class SquaresOfASortedArray {
    companion object {
        /**
         * Two Pointers approach
         * TC: O(n)
         * Runtime: 280 ms, faster than 91.00% of Kotlin online submissions for Squares of a Sorted Array.
         * Memory Usage: 40.3 MB, less than 90.66% of Kotlin online submissions for Squares of a Sorted Array.
         */
        fun sortedSquares(nums: IntArray): IntArray {
            val n: Int = nums.size
            val result = IntArray(n)
            var i = 0
            var j = n - 1
            for (p in n - 1 downTo 0) {
                if (abs(nums[i]) > abs(nums[j])) {
                    result[p] = nums[i] * nums[i]
                    i++
                } else {
                    result[p] = nums[j] * nums[j]
                    j--
                }
            }
            return result
        }
    }
}