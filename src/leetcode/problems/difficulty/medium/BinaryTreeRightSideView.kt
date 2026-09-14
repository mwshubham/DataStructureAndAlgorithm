package leetcode.problems.difficulty.medium

import datastructure.TreeNode
import kotlin1.println
import java.util.LinkedList

/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75
 */
class BinaryTreeRightSideView {

    fun rightSideView(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        if (root == null) return res
        var parentQ = LinkedList<TreeNode>()
        parentQ.offer(root)
        while (!parentQ.isEmpty()) {
            res.add(parentQ.peekLast().`val`)
            val childQ = LinkedList<TreeNode>()
            while (!parentQ.isEmpty()) {
                val node = parentQ.removeFirst()
                node.left?.let {
                    childQ.addLast(it)
                }
                node.right?.let {
                    childQ.addLast(it)
                }
            }
            parentQ = childQ
        }
        return res
    }

    fun rightSideView2(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        if (root == null) return res
        val queue = ArrayDeque<TreeNode>()
        queue.addFirst(root)
        while (!queue.isEmpty()) {
            val size = queue.size


            repeat(size) {
                val node = queue.removeFirst()
                if (it == size - 1) {
                    res.add(node.`val`)
                }
                node.left?.let {
                    queue.addLast(it)
                }
                node.right?.let {
                    queue.addLast(it)
                }
            }
        }
        return res
    }
}

fun main() {
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            right = TreeNode(5)
        }
        right = TreeNode(3).apply {
            right = TreeNode(4)
        }
    }
    BinaryTreeRightSideView().rightSideView(root).println()
}
