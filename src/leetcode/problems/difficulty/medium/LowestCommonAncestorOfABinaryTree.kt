package leetcode.problems.difficulty.medium

import datastructure.TreeNode
import kotlin1.println

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 */
class LowestCommonAncestorOfABinaryTree {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return dfs(root, p, q)
    }

    fun dfs(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root == p || root == q) return root
        val left = dfs(root.left, p, q)
        val right = dfs(root.right, p, q)

        // Different Tree
        if (left != null && right != null) return root

        // Same tree
        return left ?: right
    }
}

fun main() {
    val pNode = TreeNode(5).apply {
        left = TreeNode(6)
        right = TreeNode(2).apply {
            left = TreeNode(7)
            right = TreeNode(4)
        }
    }
    val qNode = TreeNode(1).apply {
        left = TreeNode(0)
        right = TreeNode(8)
    }
    val root = TreeNode(3).apply {
        left = pNode
        right = qNode
    }
    LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, pNode, qNode)?.`val`.println()
}
