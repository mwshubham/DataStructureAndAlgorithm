package leetcode.problems.category.tree.hard

import datastructure.TreeNode
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 987. Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
class VerticalOrderTraversalOfABinaryTree {

    /**
     * Runtime: 188 ms, faster than 70.00% of Kotlin online submissions for Vertical Order Traversal of a Binary Tree.
     * Memory Usage: 35.6 MB, less than 100.00% of Kotlin online submissions for Vertical Order Traversal of a Binary Tree.
     */
    companion object {
        val map = HashMap<Int, TreeMap<Int, PriorityQueue<Int>>>()
        var minX = 0
        var maxX = 0

        fun verticalTraversal(root: TreeNode?): List<List<Int>> {
            helper(root, 0, 0)
            val result = ArrayList<ArrayList<Int>>()
            for (i in minX..maxX) {
                val list = ArrayList<Int>()
                map[i]?.let { treeMap ->
                    treeMap.forEach { (_, pq) ->
                        while (pq.isNotEmpty()) {
                            list.add(pq.poll())
                        }
                    }
                }
                result.add(list)
            }
            return result
        }

        private fun helper(node: TreeNode?, x: Int, y: Int) {
            node ?: return
            minX = Math.min(minX, x)
            maxX = Math.max(maxX, x)
            if (!map.containsKey(x)) {
                map[x] = TreeMap()
            }
            if (!map[x]!!.contains(y)) {
                map[x]!![y] = PriorityQueue()
            }
            map[x]!![y]!!.add(node.`val`)

            helper(node.left, x - 1, y + 1)
            helper(node.right, x + 1, y + 1)
        }
    }
}

fun main() {
    val treeNode = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    VerticalOrderTraversalOfABinaryTree.verticalTraversal(treeNode)
}