package leetcode.problems.tree.easy

import leetcode.problems.TreeNode

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
class SumOfLeftLeaves {
    companion object {
        /**
         * Runtime: 156 ms, faster than 82.86% of Kotlin online submissions for Sum of Left Leaves.
         * Memory Usage: 33.8 MB, less than 94.29% of Kotlin online submissions for Sum of Left Leaves.
         */
        fun sumOfLeftLeaves(root: TreeNode?): Int {
            return sumOfLeftLeaves(root, false)
        }

        private fun sumOfLeftLeaves(root: TreeNode?, isLeft: Boolean): Int {
            root ?: return 0
            if (isLeft && root.left == null && root.right == null) {
                return root.`val`
            }
            return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false)
        }
    }
}