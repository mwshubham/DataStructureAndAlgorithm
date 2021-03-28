package leetcode.problems.tree.easy

import leetcode.problems.TreeNode

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
class ConvertSortedArrayToBinarySearchTree {

    /**
     * Constraints
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums is sorted in a strictly increasing order.
     */
    companion object {
        /**
         * Runtime: 192 ms, faster than 40.29% of Kotlin online submissions for Convert Sorted Array to Binary Search Tree.
         * Memory Usage: 37.1 MB, less than 48.20% of Kotlin online submissions for Convert Sorted Array to Binary Search Tree.
         *
         *
         * Runtime: 200 ms, faster than 29.50% of Kotlin online submissions for Convert Sorted Array to Binary Search Tree.
         * Memory Usage: 36.1 MB, less than 75.54% of Kotlin online submissions for Convert Sorted Array to Binary Search Tree.
         *
         *
         * Runtime: 184 ms, faster than 56.12% of Kotlin online submissions for Convert Sorted Array to Binary Search Tree.
         * Memory Usage: 36.3 MB, less than 64.03% of Kotlin online submissions for Convert Sorted Array to Binary Search Tree.
         *
         *
         * Runtime: 180 ms, faster than 66.91% of Kotlin online submissions for Convert Sorted Array to Binary Search Tree.
         * Memory Usage: 36 MB, less than 84.89% of Kotlin online submissions for Convert Sorted Array to Binary Search Tree.
         */
        @Suppress("unused")
        fun sortedArrayToBST(nums: IntArray): TreeNode? {
            return makeTree(nums, 0, nums.lastIndex)
        }

        private fun makeTree(nums: IntArray, left: Int, right: Int): TreeNode? {
            if (left > right) {
                return null
            }
            if (left == right) {
                return TreeNode(nums[left])
            }
            val mid = (left + right) / 2
            val node = TreeNode(nums[mid])
            node.left = makeTree(nums, left, mid - 1)
            node.right = makeTree(nums, mid + 1, right)
            return TreeNode(nums[mid])
        }
    }
}