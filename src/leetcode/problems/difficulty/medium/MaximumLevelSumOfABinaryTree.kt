package leetcode.problems.difficulty.medium

import datastructure.TreeNode
import kotlin1.println
import java.util.LinkedList

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 */
class MaximumLevelSumOfABinaryTree {

    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) return 0
        var maxSum = Int.MIN_VALUE
        var maxLevel = 0
        var level = 1
        val queue = ArrayDeque<TreeNode>()
        queue.addFirst(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            var newSum = 0
            repeat(size) {
                val node = queue.removeFirst()
                newSum += node.`val`
                node.left?.let {
                    queue.addLast(it)
                }
                node.right?.let {
                    queue.addLast(it)
                }
            }
            if (newSum > maxSum) {
                maxSum = newSum
                maxLevel = level
            }
            level++
        }
        return maxLevel
    }
}

fun main() {
    val root = TreeNode(1).apply {
        left = TreeNode(7).apply {
            left = TreeNode(7)
            right = TreeNode(-8)
        }
        right = TreeNode(0)
    }
    MaximumLevelSumOfABinaryTree().maxLevelSum(root).println()
}
