package leetcode.problems.tree.easy

import leetcode.problems.TreeNode
import java.util.*

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * https://leetcode.com/problems/invert-binary-tree/submissions/
 */
class InvertBinaryTree {
    /**
     * Runtime: 152 ms, faster than 33.61% of Kotlin online submissions for Invert Binary Tree.
     * Memory Usage: 33.8 MB, less than 18.85% of Kotlin online submissions for Invert Binary Tree.
     */
    fun invertTree(root: TreeNode?): TreeNode? {
        invert(root)
        return root
    }

    fun invert(root: TreeNode?) {
        if (root == null) return
        val temp = root.left
        root.left = root.right
        root.right = temp
        invertTree(root.left)
        invertTree(root.right)
    }


    /**
     * Runtime: 132 ms, faster than 96.72% of Kotlin online submissions for Invert Binary Tree.
     * Memory Usage: 33.7 MB, less than 35.25% of Kotlin online submissions for Invert Binary Tree.
     */
    fun invertTreeUsingBfs(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            val temp = node.left
            node.left = node.right
            node.right = temp

            node.left?.let {
                queue.add(it)
            }
            node.right?.let {
                queue.add(it)
            }
        }
        return root
    }

}