package leetcode.problems.difficulty.easy

/**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree
 */
import datastructure.TreeNode

class SubtreeOfAnotherTree {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        root ?: return false
        if (isSameTree(root, subRoot)) return true
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    fun isSameTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        if (root == null) return false
        if (subRoot == null) return false
        if (root.`val` != subRoot.`val`) return false
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right)
    }
}