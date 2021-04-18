package leetcode.problems.tree.medium

import leetcode.problems.TreeNode

/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
class SumRootToLeafNumbers {
    companion object {
        var ans = 0

        /**
         * Runtime: 148 ms, faster than 79.41% of Kotlin online submissions for Sum Root to Leaf Numbers.
         * Memory Usage: 33.7 MB, less than 47.06% of Kotlin online submissions for Sum Root to Leaf Numbers.
         */
        fun sumNumbers(root: TreeNode?): Int {
            sumRootToLeaf(root, 0)
            return ans
        }

        fun sumRootToLeaf(root: TreeNode?, number: Int) {
            if (root == null) return
            val newNumber = number * 10 + root.`val`
            if (root.left == null && root.right == null) {
                ans += newNumber
                return
            }
            sumRootToLeaf(root.left, newNumber)
            sumRootToLeaf(root.right, newNumber)
        }
    }
}