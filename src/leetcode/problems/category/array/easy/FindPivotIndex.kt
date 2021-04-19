package leetcode.problems.category.array.easy

/**
 * https://leetcode.com/problems/find-pivot-index/
 */
class FindPivotIndex {

    /**
     * Runtime: 260 ms, faster than 36.92% of Kotlin online submissions for Find Pivot Index.
     * Memory Usage: 40.3 MB, less than 43.08% of Kotlin online submissions for Find Pivot Index.
     *
     *
     * Runtime: 228 ms, faster than 92.31% of Kotlin online submissions for Find Pivot Index.
     * Memory Usage: 37.9 MB, less than 100.00% of Kotlin online submissions for Find Pivot Index.
     */
    companion object {
        fun pivotIndex(nums: IntArray): Int {
            val totalSum = nums.sum()
            if (totalSum == 0) return 0
            var sum = 0
            nums.forEachIndexed { index, num ->
                if (sum == totalSum - sum - num) return index
                sum += num
            }
            return -1
        }
    }
}