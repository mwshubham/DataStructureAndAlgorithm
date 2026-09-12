package leetcode.problems.difficulty.medium

import datastructure.TreeNode
import kotlin1.println

/**
 * 1448. Count Good Nodes in Binary Tree
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 */
class CountGoodNodesInBinaryTree {

    fun goodNodes(root: TreeNode?): Int {
        return goodNodes(root, Int.MIN_VALUE)
    }

    fun goodNodes(root: TreeNode?, max: Int): Int {
        if (root == null) return 0
        return if (root.`val` >= max) {
            1 + goodNodes(root.left, root.`val`) + goodNodes(root.right, root.`val`)
        } else {
            goodNodes(root.left, max) + goodNodes(root.right, max)
        }
    }
}

fun main() {
    val root = TreeNode(3).apply {
        left = TreeNode(1).apply {
            left = TreeNode(3)
        }
        right = TreeNode(4).apply {
            left = TreeNode(1)
            right = TreeNode(5)
        }
    }
    CountGoodNodesInBinaryTree().goodNodes(root).println()
}
