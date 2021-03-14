package leetcode.problems.tree.easy

import leetcode.problems.TreeNode
import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
 */
class MaximumDepthOfBinaryTree {
    /**
     * Runtime: 184 ms, faster than 27.93% of Kotlin online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 35.4 MB, less than 90.39% of Kotlin online submissions for Maximum Depth of Binary Tree.
     */
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + max(maxDepth(root.left), maxDepth(root.right))
    }
}
