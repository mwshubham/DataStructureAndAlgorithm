package leetcode.problems.category.tree.medium

import datastructure.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/
 * https://leetcode.com/submissions/detail/600577880/?from=explore&item_id=786
 */
class BinaryTreeInorderTraversal {


    companion object {
        /**
         * Runtime: 148 ms, faster than 90.83% of Kotlin online submissions for Binary Tree Inorder Traversal.
         * Memory Usage: 34.1 MB, less than 70.83% of Kotlin online submissions for Binary Tree Inorder Traversal.
         */
        fun inorderTraversal(root: TreeNode?): List<Int> {
            val res = ArrayList<Int>()
            inorderTraversal(root, res)
            return res
        }

        fun inorderTraversal(root: TreeNode?, res: ArrayList<Int>) {
            root ?: return
            inorderTraversal(root.left, res)
            res.add(root.`val`)
            inorderTraversal(root.right, res)
        }

        fun inorderTraversalIteratively(root: TreeNode?): List<Int> {
            val res = ArrayList<Int>()
            var curr = root

            val stack = Stack<TreeNode>()

            while (curr != null || stack.isNotEmpty()) {
                while (curr != null) {
                    stack.push(root)
                    curr = curr.left
                }
                curr = stack.pop()
                res.add(curr.`val`)
                curr = curr.right
            }
            return res
        }

    }
}