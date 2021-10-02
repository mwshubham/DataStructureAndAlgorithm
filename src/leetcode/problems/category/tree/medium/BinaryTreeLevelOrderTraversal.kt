package leetcode.problems.category.tree.medium

import datastructure.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = LinkedList<List<Int>>()
        root ?: return res
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()){
            val list = LinkedList<Int>()
            repeat(queue.size){
                queue.poll()?.apply {
                    list.add(`val`)
                    left?.let { queue.add(it) }
                    right?.let { queue.add(it) }
                }
            }
            res.add(list)
        }
        return res
    }
}