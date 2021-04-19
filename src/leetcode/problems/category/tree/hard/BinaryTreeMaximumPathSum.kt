package leetcode.problems.category.tree.hard

import leetcode.problems.difficulty.TreeNode
import kotlin.math.max

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
class BinaryTreeMaximumPathSum {
    companion object {

        var maxValue = Int.MIN_VALUE

        /**
         * Runtime: 212 ms, faster than 69.23% of Kotlin online submissions for Binary Tree Maximum Path Sum.
         * Memory Usage: 38.9 MB, less than 55.56% of Kotlin online submissions for Binary Tree Maximum Path Sum.
         */
        fun maxPathSum(root: TreeNode?): Int {
            maxPathDown(root)
            return maxValue
        }

        fun maxPathDown(node: TreeNode?): Int {
            node ?: return 0
            val left = max(0, maxPathDown(node.left))
            val right = max(0, maxPathDown(node.right))
            maxValue = max(maxValue, left + right + node.`val`)
            return max(left, right) + node.`val`
        }
    }
}