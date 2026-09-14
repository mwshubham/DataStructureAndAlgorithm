package leetcode.problems.difficulty.medium

import datastructure.TreeNode
import kotlin1.println

/**
 * 450. Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/description/?envType=study-plan-v2&envId=leetcode-75
 */
class DeleteNodeInABst {

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        } else {
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            }
            val minNode = findMinNode(root.right!!)
            root.`val` = minNode.`val`
            root.right = deleteNode(minNode.right, root.`val`)
        }
        return root
    }

    fun findMinNode(node: TreeNode): TreeNode {
        var current = node

        while (current.left != null) {
            current = current.left!!
        }

        return current
    }
}

fun main() {
    val root = TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(4)
        }
        right = TreeNode(6).apply {
            right = TreeNode(7)
        }
    }
    DeleteNodeInABst().deleteNode(root, 3).println()
}
