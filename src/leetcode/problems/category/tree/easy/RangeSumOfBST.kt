package leetcode.problems.category.tree.easy

import leetcode.problems.difficulty.TreeNode

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * https://leetcode.com/problems/range-sum-of-bst/submissions/
 */
class RangeSumOfBST {
    /**
     * Runtime: 336 ms, faster than 37.16% of Kotlin online submissions for Range Sum of BST.
     * Memory Usage: 44.6 MB, less than 58.78% of Kotlin online submissions for Range Sum of BST.
     */
    fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
        if (root == null) return 0
        // Exclude Left Node
        if (root.`val` < L) return rangeSumBST(root.right, L, R)
        // Exclude Right Node
        if (root.`val` > R) return rangeSumBST(root.left, L, R)
        return root.`val` + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
    }

    /**
     * Runtime: 312 ms, faster than 89.19% of Kotlin online submissions for Range Sum of BST.
     * Memory Usage: 44.1 MB, less than 99.32% of Kotlin online submissions for Range Sum of BST.
     */
    fun rangeSumBST2(root: TreeNode?, L: Int, R: Int): Int {
        if (root == null) return 0
        return (
                if (root.`val` in L..R) {
                    root.`val`
                } else {
                    0
                }
                        + rangeSumBST(root.left, L, R)
                        + rangeSumBST(root.right, L, R)
                )
    }
}