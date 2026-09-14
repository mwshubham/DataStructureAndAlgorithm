package leetcode.problems.difficulty.medium

import datastructure.TreeNode
import kotlin1.println
import java.util.LinkedList

/**
 * 1372. Longest ZigZag Path in a Binary Tree
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 */
class LongestZigzagPathInABinaryTree {

    var max = 0

    fun longestZigZag(root: TreeNode?): Int {
        if (root == null) return 0
        dfs(root.left, 1, true)
        dfs(root.right, 1, false)
        return max
    }

    fun dfs(root: TreeNode?, length: Int, isLeft: Boolean) {
        if (root == null) return
        max = maxOf(max, length)
        if (isLeft) {
            dfs(root.left, 1, true)
            dfs(root.right, length + 1, false)
        } else {
            dfs(root.left, length + 1, true)
            dfs(root.right, 1, false)
        }
    }
}

fun main() {
    val root = TreeNode(1).apply {
        right = TreeNode(1).apply {
            left = TreeNode(1)
            right = TreeNode(1).apply {
                left = TreeNode(1).apply {
                    right = TreeNode(1)
                }
                right = TreeNode(1)
            }
        }
    }
    LongestZigzagPathInABinaryTree().longestZigZag(root).println()
}
