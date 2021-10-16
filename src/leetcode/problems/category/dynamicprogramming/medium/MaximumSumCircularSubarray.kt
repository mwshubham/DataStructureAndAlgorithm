package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println
import kotlin.math.max
import kotlin.math.min

/**
 * 918. Maximum Sum Circular Subarray
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 */
class MaximumSumCircularSubarray {
    /**
     * Runtime: 308 ms, faster than 95.65% of Kotlin online submissions for Maximum Sum Circular Subarray.
     * Memory Usage: 46.7 MB, less than 73.91% of Kotlin online submissions for Maximum Sum Circular Subarray.
     */
    companion object{
        fun maxSubarraySumCircular(nums: IntArray): Int {
            var maxStraightSum = Int.MIN_VALUE
            var tempMaxStraightSum = 0

            var minStraightSum = Int.MAX_VALUE
            var tempMinStraightSum = 0

            var arraySum = 0

            nums.forEach {
                arraySum += it

                tempMaxStraightSum += it
                maxStraightSum = max(maxStraightSum, tempMaxStraightSum)
                if (tempMaxStraightSum < 0)  {
                    tempMaxStraightSum = 0
                }

                tempMinStraightSum += it
                minStraightSum = min(minStraightSum, tempMinStraightSum)
                if (tempMinStraightSum > 0)  {
                    tempMinStraightSum = 0
                }
            }
            if (arraySum == minStraightSum) {
                return maxStraightSum
            }
            return max(maxStraightSum, arraySum - minStraightSum)
        }
    }
}

fun main(){
    MaximumSumCircularSubarray.maxSubarraySumCircular(intArrayOf(5, -3, 5)).println()
}