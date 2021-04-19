package leetcode.problems.category.tree.easy

import leetcode.problems.difficulty.TreeNode

/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/submissions/
 */
class SumOfRootToLeafBinaryNumbers {
    var ans = 0

    /**
     * Runtime: 168 ms, faster than 76.92% of Kotlin online submissions for Sum of Root To Leaf Binary Numbers.
     * Memory Usage: 36 MB, less than 53.85% of Kotlin online submissions for Sum of Root To Leaf Binary Numbers.
     */
    fun sumRootToLeaf(root: TreeNode?): Int {
        sumRootToLeaf(root, 0)
        return ans
    }

    fun sumRootToLeaf(root: TreeNode?, number: Int) {
        if (root == null) return
        val newNumber = number shl 1 or root.`val`
        if (root.left == null && root.right == null) {
            ans += newNumber
            return
        }
        sumRootToLeaf(root.left, newNumber)
        sumRootToLeaf(root.right, newNumber)
    }
}