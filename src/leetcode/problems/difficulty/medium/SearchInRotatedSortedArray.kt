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
    }
}