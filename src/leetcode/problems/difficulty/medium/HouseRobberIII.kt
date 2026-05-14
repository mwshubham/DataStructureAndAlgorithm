package leetcode.problems.difficulty.medium

import kotlin.math.max

/**
 * https://leetcode.com/problems/house-robber-iii/
 * 337. House Robber III
 */
class HouseRobberIII {

    fun rob(root: TreeNode?): Int {
        val (skip, rob) = robHelper(root)
        return max(skip, rob)
    }

    fun robHelper(node: TreeNode?): Pair<Int, Int> {
        node ?: return Pair(0, 0)

        val left = robHelper(node.left)
        val right = robHelper(node.right)

        val skip = max(left.first, left.second) + max(right.first, right.second)
        val rob = node.`val` + left.first + right.first

        return Pair(skip, rob)
    }
}