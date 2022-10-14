package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.*

/**
 * 503. Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/
 */
class NextGreaterElementII {

    companion object {
        /**
         * Runtime: 352 ms, faster than 100.00% of Kotlin online submissions for Next Greater Element II.
         * Memory Usage: 40.8 MB, less than 95.24% of Kotlin online submissions for Next Greater Element II.
         */
        fun nextGreaterElements(nums: IntArray): IntArray {
            val map = IntArray(nums.size) { -1 }
            val stack = ArrayDeque<Pair<Int, Int>>()
            nums.forEachIndexed { index, num ->
                while (!stack.isEmpty() && stack.peek().second < num) {
                    map[stack.pop().first] = num
                }
                stack.push(Pair(index, num))
            }
            for (i in 0 until stack.peek().first) {
                val num = nums[i]
                while (!stack.isEmpty() && stack.first().second < num && stack.first().first > i) {
                    map[stack.removeFirst().first] = num
                }
            }
            return map
        }
    }
}

fun main() {
    NextGreaterElementII.nextGreaterElements(intArrayOf(1, 2, 1)).println()
    // [2,-1,2]
    NextGreaterElementII.nextGreaterElements(intArrayOf(1, 2, 3, 4, 3)).println()
    // [2,3,4,-1,4]
    NextGreaterElementII.nextGreaterElements(intArrayOf(1, 2, 4, 3)).println()
    // [2,4,-1,4]
    NextGreaterElementII.nextGreaterElements(intArrayOf(100, 1, 11, 1, 120, 111, 123, 1, -1, -100)).println()
    // [120,11,120,120,123,123,-1,100,100,100]
}