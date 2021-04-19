package leetcode.problems.category.tree.easy

import leetcode.problems.difficulty.TreeNode
import kotlin.math.max

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
class DiameterOfBinaryTree {

    companion object {
        private var max = Int.MIN_VALUE

        /**
         * Runtime: 192 ms, faster than 25.53% of Kotlin online submissions for Diameter of Binary Tree.
         * Memory Usage: 35.6 MB, less than 64.54% of Kotlin online submissions for Diameter of Binary Tree.
         */
        fun diameterOfBinaryTree(root: TreeNode?): Int {
            diameter(root)
            return max
        }

        private fun diameter(root: TreeNode?): Int {
            root ?: return 0
            val left = diameter(root.left)
            val right = diameter(root.right)
            max = max(max, left + right)
            return max(left, right) + 1
        }
    }
}