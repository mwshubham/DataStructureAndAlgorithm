package leetcode.problems.category.binarysearch.medium

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3725/
 *
 * https://leetcode.com/submissions/detail/486630442/?from=explore&item_id=3725
 */
class FindFirstAndLastPositionOfElementInSortedArray {
    companion object {
        /**
         * Runtime: 216 ms, faster than 45.41% of Kotlin online submissions for Find First and Last Position of Element in Sorted Array.
         * Memory Usage: 40 MB, less than 32.37% of Kotlin online submissions for Find First and Last Position of Element in Sorted Array.
         */
        fun searchRange(nums: IntArray, target: Int): IntArray {
            val result = IntArray(2) { -1 }
            result[0] = findFirst(nums, target)
            if (result[0] != -1) {
                result[1] = findLast(nums, target, result[0])
            }
            return result
        }

        private fun findFirst(nums: IntArray, target: Int): Int {
            var left = 0
            var right = nums.lastIndex
            var index = -1
            while (left <= right) {
                val mid = (left + right) / 2
                if (nums[mid] >= target) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
                if (nums[mid] == target) {
                    index = mid
                }
            }
            return index
        }

        private fun findLast(nums: IntArray, target: Int, start: Int): Int {
            var left = start
            var right = nums.lastIndex
            var index = -1
            while (left <= right) {
                val mid = (left + right) / 2
                if (nums[mid] <= target) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
                if (nums[mid] == target) {
                    index = mid
                }
            }
            return index
        }
    }
}