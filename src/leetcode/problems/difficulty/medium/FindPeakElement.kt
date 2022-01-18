package leetcode.problems.difficulty.medium

/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/801/
 */
class FindPeakElement {

    companion object {
        fun findPeakElement(nums: IntArray): Int {
            if (nums.size == 1) return 0
            if (nums[0] > nums[1]) return 0
            if (nums[nums.lastIndex] > nums[nums.lastIndex - 1]) return nums.lastIndex

            var start = 1
            var end = nums.lastIndex - 1

            while (start <= end) {
                val mid = start + (end - start) / 2
                when {
                    nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1] -> return mid
                    nums[mid] < nums[mid - 1] -> end = mid - 1
                    nums[mid] < nums[mid + 1] -> start = mid + 1
                }
            }

            return -1
        }
    }
}