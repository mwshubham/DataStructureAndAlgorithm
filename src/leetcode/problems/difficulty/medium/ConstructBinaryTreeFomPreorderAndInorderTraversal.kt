package leetcode.problems.difficulty.medium

import kotlin1.println

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/788/
 */
class ConstructBinaryTreeFomPreorderAndInorderTraversal {
    companion object {
        var root = 0
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            return buildTree(
                preorder = preorder,
                inorder = inorder,
                start = 0,
                end = preorder.lastIndex
            )
        }

        private fun buildTree(
            preorder: IntArray,
            inorder: IntArray,
            start: Int,
            end: Int
        ): TreeNode? {
            if (start > end) return null
            // Find the root in InOrder
            var pivot = start
            while (inorder[pivot] != preorder[root])
                pivot++

            root++
            return TreeNode(inorder[pivot]).apply {
                left = buildTree(
                    preorder = preorder,
                    inorder = inorder,
                    start = start,
                    end = pivot - 1
                )
                right = buildTree(
                    preorder = preorder,
                    inorder = inorder,
                    start = pivot + 1,
                    end = end
                )
            }
        }
    }
}

fun main() {
    ConstructBinaryTreeFomPreorderAndInorderTraversal.buildTree(
        intArrayOf(3, 9, 20, 15, 7),
        intArrayOf(9, 3, 15, 20, 7)
    ).println()
}