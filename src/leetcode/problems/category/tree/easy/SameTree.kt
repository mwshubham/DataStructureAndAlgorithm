package leetcode.problems.category.tree.easy

import leetcode.problems.difficulty.TreeNode

/**
 * https://leetcode.com/problems/same-tree/
 */
class SameTree {
    companion object {
        /**
         * Runtime: 132 ms, faster than 94.85% of Kotlin online submissions for Same Tree.
         * Memory Usage: 33.5 MB, less than 54.64% of Kotlin online submissions for Same Tree.
         */
        private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
            if (p == null && q == null) return true
            if (p == null || q == null) return false
            return if (p.`val` == q.`val`) {
                isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
            } else false
        }
    }
}