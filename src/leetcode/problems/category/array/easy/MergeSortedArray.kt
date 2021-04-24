package leetcode.problems.category.array.easy

import kotlin.math.max

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
 *
 * https://leetcode.com/submissions/detail/484486172/?from=explore&item_id=3253
 */
class MergeSortedArray {
    companion object {
        /**
         * Runtime: 176 ms, faster than 35.85% of Kotlin online submissions for Merge Sorted Array.
         * Memory Usage: 36.3 MB, less than 19.50% of Kotlin online submissions for Merge Sorted Array.
         */
        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
            var i = m - 1
            var j = n - 1
            var k = nums1.lastIndex
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[k--] = nums1[i--]
                } else {
                    nums1[k--] = nums2[j--]
                }
            }
            while (j >= 0) {
                nums1[k--] = nums2[j--]
            }
        }
    }
}