package leetcode.problems.tree.medium

import leetcode.problems.TreeNode

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
class ValidateBinarySearchTree {
    companion object {
        /**
         * Runtime: 176 ms, faster than 78.31% of Kotlin online submissions for Validate Binary Search Tree.
         * Memory Usage: 36 MB, less than 58.46% of Kotlin online submissions for Validate Binary Search Tree.
         */
        fun isValidBST(root: TreeNode?): Boolean {
            root ?: return false
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
        }

        private fun isValidBST(root: TreeNode?, minVal: Long, maxVal: Long): Boolean {
            root ?: return true
            if (root.`val` >= maxVal || root.`val` <= minVal) return false
            return isValidBST(root.left, minVal, root.`val`.toLong()) && isValidBST(
                root.right,
                root.`val`.toLong(),
                maxVal
            )
        }
    }
}