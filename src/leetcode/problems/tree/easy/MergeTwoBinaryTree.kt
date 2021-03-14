package leetcode.problems.tree.easy

import leetcode.problems.TreeNode

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 * https://leetcode.com/problems/merge-two-binary-trees/submissions/
 */
class MergeTwoBinaryTree {
    /**
     * Runtime: 236 ms, faster than 38.78% of Kotlin online submissions for Merge Two Binary Trees.
     * Memory Usage: 38.1 MB, less than 67.35% of Kotlin online submissions for Merge Two Binary Trees.
     */
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null && root2 == null) return null
        else if (root1 == null) return root2
        else if (root2 == null) return root1
        val treeNode = TreeNode(root1.`val` + root2.`val`)
        treeNode.left = mergeTrees(root1.left, root2.left)
        treeNode.right = mergeTrees(root1.right, root2.right)
        return treeNode
    }
}