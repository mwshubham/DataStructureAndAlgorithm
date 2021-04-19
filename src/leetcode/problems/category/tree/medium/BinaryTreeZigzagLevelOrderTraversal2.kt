package leetcode.problems.category.tree.medium

import leetcode.problems.difficulty.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
class BinaryTreeZigzagLevelOrderTraversal2 {

    /**
     * Runtime: 204 ms, faster than 33.33% of Kotlin online submissions for Binary Tree Level Order Traversal II.
     * Memory Usage: 35.7 MB, less than 79.49% of Kotlin online submissions for Binary Tree Level Order Traversal II.
     */
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        root ?: return result

        result.add(listOf(root.`val`))

        val listOfTreeNodes = LinkedList<TreeNode>()
        listOfTreeNodes.add(root)
        while (listOfTreeNodes.isNotEmpty()) {
            val listOfValues = ArrayList<Int>()
            repeat(listOfTreeNodes.size) {
                listOfTreeNodes.removeFirst().let { node ->
                    node.left?.let { child ->
                        listOfValues.add(child.`val`)
                        listOfTreeNodes.add(child)
                    }
                    node.right?.let { child ->
                        listOfValues.add(child.`val`)
                        listOfTreeNodes.add(child)
                    }
                }
            }
            if (listOfValues.isNotEmpty()) {
                result.add(0, listOfValues)
            }
        }
        return result
    }
}