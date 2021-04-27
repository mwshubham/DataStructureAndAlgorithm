package leetcode.problems.category.array.easy

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3258/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
 * https://leetcode.com/submissions/detail/484990171/?from=explore&item_id=3248
 * https://leetcode.com/submissions/detail/484998546/?from=explore&item_id=3258
 */
class RemoveDuplicatesFromSortedArray {
    companion object {
        /**
         * Runtime: 216 ms, faster than 67.70% of Kotlin online submissions for Remove Duplicates from Sorted Array.
         * Memory Usage: 37.9 MB, less than 80.14% of Kotlin online submissions for Remove Duplicates from Sorted Array.
         */
        fun removeDuplicates(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            var index = 0
            nums.forEach {
                if (it != nums[index]) {
                    nums[++index] = it
                }
            }
            return ++index
        }
    }
}