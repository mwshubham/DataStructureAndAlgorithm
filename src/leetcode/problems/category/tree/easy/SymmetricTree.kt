package leetcode.problems.category.tree.easy

import leetcode.problems.difficulty.TreeNode

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
class SymmetricTree {

    companion object {
        /**
         * Runtime: 164 ms, faster than 83.64% of Kotlin online submissions for Symmetric Tree.
         * Memory Usage: 38.6 MB, less than 9.55% of Kotlin online submissions for Symmetric Tree.
         */
        fun isSymmetric(root: TreeNode?): Boolean {
            root ?: return true
            return isSymmetric(root.left, root.right)
        }

        fun isSymmetric(p: TreeNode?, q: TreeNode?): Boolean {
            if (p == null && q == null) return true
            if (p == null || q == null) return false
            return if (p.`val` == q.`val`) {
                isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left)
            } else false
        }
    }
}