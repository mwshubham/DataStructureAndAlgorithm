package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println
import kotlin.math.max
import kotlin.math.min

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 */
class MinimumOperationsToReduceXToZero {
    companion object {

        val map = hashMapOf<String, Int>()

        /**
         * Time Limit Exceeded
         */
        fun minOperations(nums: IntArray, x: Int): Int {
            return minOperations(nums, x, 0, nums.lastIndex, 0)
                .takeIf { it != Int.MAX_VALUE }
                ?: -1
        }

        private fun minOperations(nums: IntArray, x: Int, left: Int, right: Int, count: Int): Int {
            if (x == 0) return count
            if (x < 0 || left > right) return Int.MAX_VALUE
            val key = "$left:$right:$x"
            if (map.containsKey(key)) return map[key]!!

            return min(
                minOperations(nums, x - nums[left], left + 1, right, count + 1),
                minOperations(nums, x - nums[right], left, right - 1, count + 1)
            ).also {
                map[key] = it
            }
        }

        /**
         * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/935935/Java-Detailed-Explanation-O(N)-Prefix-SumMap-Longest-Target-Sub-Array
         * Runtime: 776 ms, faster than 50.00% of Kotlin online submissions for Minimum Operations to Reduce X to Zero.
         * Memory Usage: 52.1 MB, less than 100.00% of Kotlin online submissions for Minimum Operations to Reduce X to Zero.
         */
        fun minOperations2(nums: IntArray, x: Int): Int {
            val target = nums.sum() - x
            if (target == 0) return nums.size
            var res = Int.MIN_VALUE
            var sum = 0
            val map = hashMapOf<Int, Int>()
            map[0] = -1
            nums.forEachIndexed { index,  num ->
                sum += num
                if (map.containsKey(sum - target)){
                    res = max(res, index - map[sum - target]!!)
                }
                map[sum] = index
            }
            return (nums.size - res)
                .takeIf { res != Int.MIN_VALUE }
                ?: -1
        }
    }
}

fun main(){
    MinimumOperationsToReduceXToZero.minOperations(intArrayOf(1, 1, 4, 2, 3), 5).println()
    MinimumOperationsToReduceXToZero.minOperations2(intArrayOf(5, 6, 7, 8, 9), 4).println()
}