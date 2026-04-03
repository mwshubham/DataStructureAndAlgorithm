package leetcode.problems.difficulty.easy

import datastructure.TreeNode
import java.util.LinkedList

/**
 * 872. Leaf Similar Trees
 */
class LeafSimilarTrees {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val leafs1 = getLeafs(root1)
        val leafs2 = getLeafs(root2)
        return leafs1 == leafs2
    }

    fun getLeafs(root: TreeNode?): LinkedList<Int> {
        val leafs = LinkedList<Int>()
        dfs(root, leafs)
        return leafs
    }

    fun dfs(root: TreeNode?, leafs: LinkedList<Int>) {
        if (root == null) return
        if (root.left == null && root.right == null) {
            leafs.add(root.`val`)
            return
        }
        dfs(root.left, leafs)
        dfs(root.right, leafs)
    }
}