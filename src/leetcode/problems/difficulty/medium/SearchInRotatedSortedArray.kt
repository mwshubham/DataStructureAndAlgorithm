package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/804/
 * https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425/Concise-O(log-N)-Binary-search-solution
 */
class SearchInRotatedSortedArray {

    companion object {
        fun search(nums: IntArray, target: Int): Int {
            if (nums.isEmpty()) return -1
            var start = 0
            var end = nums.lastIndex

            // find min
            while (start < end) {
                val mid = start + (end - start) / 2
                if (nums[mid] > nums[end]) start = mid + 1
                else end = mid
            }

            val indexOfRotation = start
            start = 0
            end = nums.lastIndex

            // find min
            while (start <= end) {
                val mid = start + (end - start) / 2
                val realMid = (mid + indexOfRotation) % nums.size
                if (nums[realMid] == target) return realMid
                else if (nums[realMid] < target) start = mid + 1
                else end = mid - 1
            }
            return -1
        }

        fun search2(nums: IntArray, target: Int): Int {
            var left = 0
            var right = nums.lastIndex

            while (left <= right) {
                val mid = left + (right - left) / 2

                //            println("left: $left, mid: $mid, right: $right")
                if (nums[mid] == target) return mid


                // Sorted Left
                if (nums[left] <= nums[mid]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1
                    } else {
                        left = mid + 1
                    }
                }
                // Sorted Right
                else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1
                    } else {
                        right = mid - 1
                    }
                }
            }
            return -1
        }
    }
}


fun main() {
    SearchInRotatedSortedArray.apply {
        search2(intArrayOf(1, 2, 3, 4, 5), 1).println()
        search(intArrayOf(1, 2, 3, 4, 5), 2).println()
        search(intArrayOf(1, 2, 3, 4, 5), 3).println()
        search(intArrayOf(1, 2, 3, 4, 5), 4).println()
        search(intArrayOf(1, 2, 3, 4, 5), 5).println()

        search(intArrayOf(5, 1, 2, 3, 4), 1).println()
        search(intArrayOf(5, 1, 2, 3, 4), 2).println()
        search(intArrayOf(5, 1, 2, 3, 4), 3).println()
        search(intArrayOf(5, 1, 2, 3, 4), 4).println()
        search(intArrayOf(5, 1, 2, 3, 4), 5).println()
    }
}