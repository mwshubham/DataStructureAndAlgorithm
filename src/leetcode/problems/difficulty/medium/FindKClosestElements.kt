package leetcode.problems.difficulty.medium

import kotlin1.println
import kotlin.math.abs

/**
 * 658. Find K Closest Elements
 * https://leetcode.com/problems/find-k-closest-elements/
 */
class FindKClosestElements {

    companion object {
        /**
         * Runtime: 784 ms, faster than 70.93% of Kotlin online submissions for Find K Closest Elements.
         * Memory Usage: 71 MB, less than 58.14% of Kotlin online submissions for Find K Closest Elements.
         */
        fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
            var left = 0
            var right = arr.lastIndex
            while (right - left >= k) {
                if (abs(arr[left] - x) > abs(arr[right] - x)) {
                    left++
                } else {
                    right--
                }
            }
            val res = ArrayList<Int>()
            for (i in left..right) {
                res.add(arr[i])
            }
            return res
        }
    }
}


fun main() {
    FindKClosestElements.findClosestElements(
        intArrayOf(1, 2, 3, 4, 5),
        4,
        3
    ).println()
}