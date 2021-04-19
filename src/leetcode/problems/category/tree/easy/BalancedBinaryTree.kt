package leetcode.problems.category.tree.easy

import leetcode.problems.difficulty.TreeNode
import kotlin.math.abs
import kotlin.math.max

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
class BalancedBinaryTree {

    companion object {
        /**
         * Runtime: 172 ms, faster than 91.55% of Kotlin online submissions for Balanced Binary Tree.
         * Memory Usage: 39.1 MB, less than 26.76% of Kotlin online submissions for Balanced Binary Tree.
         */
        fun isBalanced(root: TreeNode?): Boolean {
            try {
                getHeight(root)
            } catch (e: IllegalStateException) {
                return false
            }
            return true
        }

        @Throws(IllegalStateException::class)
        fun getHeight(root: TreeNode?): Int {
            root ?: return 0
            val left = getHeight(root.left)
            val right = getHeight(root.right)
            if (abs(left - right) > 1) {
                throw IllegalStateException("Is Not Balanced Tree")
            }
            return max(left, right) + 1
        }
    }
}