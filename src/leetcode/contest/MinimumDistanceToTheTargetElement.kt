package leetcode.contest

import kotlin.math.abs
import kotlin.math.min

/**
 * 1848. Minimum Distance to the Target Element
 * https://leetcode.com/problems/minimum-distance-to-the-target-element/
 */
class MinimumDistanceToTheTargetElement {

    companion object {
        /**
         * Runtime: 172 ms, faster than 100.00% of Kotlin online submissions for Minimum Distance to the Target Element.
         * Memory Usage: 36.3 MB, less than 100.00% of Kotlin online submissions for Minimum Distance to the Target Element.
         */
        fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
            var result = Int.MAX_VALUE
            nums.forEachIndexed { index, item ->
                if (item == target) {
                    result = min(result, abs(index - start))
                }
            }
            return result
        }
    }
}