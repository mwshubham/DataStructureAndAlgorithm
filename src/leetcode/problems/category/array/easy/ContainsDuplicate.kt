package leetcode.problems.category.array.easy

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 */
class ContainsDuplicate {
    companion object{
        /**
         * Runtime: 248 ms, faster than 72.52% of Kotlin online submissions for Contains Duplicate.
         * Memory Usage: 44.6 MB, less than 44.37% of Kotlin online submissions for Contains Duplicate.
         */
        fun containsDuplicate(nums: IntArray): Boolean {
          return  nums.distinct().size != nums.size
        }
    }
}