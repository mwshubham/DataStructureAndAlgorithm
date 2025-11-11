package gfg

import datastructure.TreeNode
import kotlin1.println

/**
 * Boundary Traversal of a Binary Tree
 * Asked in Adobe CS2 Interviews
 *
 * https://www.geeksforgeeks.org/dsa/boundary-traversal-of-binary-tree/
 * https://leetcode.com/problems/boundary-of-binary-tree/ (Premium)
 */
class BoundaryTraversalOfBinaryTree {
    companion object {
        fun boundaryTraversal(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()
            val result = mutableListOf<Int>()
            result.add(root.`val`)
            fillBoundaryItems(
                node = root.left,
                isLeftChild = true,
                isRightChild = false,
                result = result
            )
            fillBoundaryItems(
                node = root.right,
                isLeftChild = false,
                isRightChild = true,
                result = result
            )
            return result
        }


        fun fillBoundaryItems(
            node: TreeNode?,
            isLeftChild: Boolean,
            isRightChild: Boolean,
            result: MutableList<Int>
        ) {
            node ?: return
            if (isLeftChild) {
                result.add(node.`val`)
            } else if (isRightChild) {
                result.add(node.`val`)
            } else if (isLeaf(node)) {
                result.add(node.`val`)
                return
            }
            fillBoundaryItems(
                node = node.left,
                isLeftChild = isLeftChild,
                isRightChild = false,
                result = result
            )
            fillBoundaryItems(
                node = node.right,
                isLeftChild = false,
                isRightChild = isRightChild,
                result = result
            )
        }

        fun isLeaf(node: TreeNode): Boolean {
            return node.left == null && node.right == null
        }
    }
}

fun main() {
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5).apply {
                left = TreeNode(8)
                right = TreeNode(9)
            }
        }
        right = TreeNode(3).apply {
            left = TreeNode(6)
            right = TreeNode(7)
        }
    }
    BoundaryTraversalOfBinaryTree.boundaryTraversal(root).println()
}