package leetcode.problems.difficulty

import java.util.*
import kotlin.collections.ArrayList

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
class BinaryTreeRightSideView {
    /**
     * Runtime: 180 ms, faster than 55.50% of Kotlin online submissions for Binary Tree Right Side View.
     * Memory Usage: 36 MB, less than 19.72% of Kotlin online submissions for Binary Tree Right Side View.
     */
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val output = ArrayList<Int>()

        val parentQueue = LinkedList<TreeNode>()
        val childQueue = LinkedList<TreeNode>()

        parentQueue.add(root)
        while (parentQueue.isNotEmpty()) {
            output.add(parentQueue.peek().`val`)
            childQueue.clear()
            while (parentQueue.isNotEmpty()) {
                parentQueue.poll()?.let {
                    it.right?.let { rightChild ->
                        childQueue.add(rightChild)
                    }
                    it.left?.let { leftChild ->
                        childQueue.add(leftChild)
                    }
                }
            }
            parentQueue.addAll(childQueue)
        }
        return output
    }

    /**
     * Iteration 2: Using 1 Queue
     * Runtime: 172 ms, faster than 69.27% of Kotlin online submissions for Binary Tree Right Side View.
     * Memory Usage: 35.9 MB, less than 27.98% of Kotlin online submissions for Binary Tree Right Side View.
     */
    fun rightSideView2(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val output = ArrayList<Int>()
        val parentQueue = PriorityQueue<TreeNode>()
        parentQueue.add(root)
        while (parentQueue.isNotEmpty()) {
            output.add(parentQueue.peek().`val`)
            val size = parentQueue.size
            repeat(size) {
                parentQueue.poll()?.let {
                    it.right?.let { rightChild ->
                        parentQueue.add(rightChild)
                    }
                    it.left?.let { leftChild ->
                        parentQueue.add(leftChild)
                    }
                }
            }
        }
        return output
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}