package leetcode.problems.category.array.medium

import kotlin1.println
import kotlin.math.abs

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest
 */
class `3SumClosest` {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closestSum = nums[0] + nums[1] + nums[2]

        for (first in 0..nums.size - 3) {
            // Optimization: Skip duplicates for 'first'
            if (first > 0 && nums[first] == nums[first - 1]) continue

            var second = first + 1
            var third = nums.size - 1

            while (second < third) {
                val sum = nums[first] + nums[second] + nums[third]

                if (sum == target) return sum

                if (abs(target - sum) < abs(target - closestSum)) {
                    closestSum = sum
                }

                if (sum < target) {
                    second++
                    // Optimization: Skip duplicates for 'second'
                    while (second < third && nums[second] == nums[second - 1]) second++
                } else {
                    third--
                    // Optimization: Skip duplicates for 'third'
                    while (second < third && nums[third] == nums[third + 1]) third--
                }
            }
        }
        return closestSum
    }
}

fun main() {
    `3SumClosest`().apply {
        threeSumClosest(intArrayOf(-84, 92, 26, 19, -7, 9, 42, -51, 8, 30, -100, -13, -38), 78).println()
    }
}