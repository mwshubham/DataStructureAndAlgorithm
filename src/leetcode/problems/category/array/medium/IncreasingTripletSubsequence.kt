package leetcode.problems.category.array.medium

import kotlin1.println

/**
 * 334. Increasing Triplet Subsequence
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/
 * https://leetcode.com/submissions/detail/598319479/?from=explore&item_id=781
 */
class IncreasingTripletSubsequence {

    companion object {
        /**
         * Runtime: 412 ms, faster than 87.10% of Kotlin online submissions for Increasing Triplet Subsequence.
         * Memory Usage: 81.3 MB, less than 51.61% of Kotlin online submissions for Increasing Triplet Subsequence.
         */
        fun increasingTriplet(nums: IntArray): Boolean {
            var small = Int.MAX_VALUE
            var big = Int.MAX_VALUE
            nums.forEach {
                if (it <= small) small = it
                else if (it <= big) big = it
                else return true
            }
            return false
        }
    }
}

fun main() {
    IncreasingTripletSubsequence.increasingTriplet(intArrayOf(1, 5, 0, 4, 1, 3)).println()
}