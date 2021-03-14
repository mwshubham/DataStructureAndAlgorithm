package leetcode.problems.tree.easy

import leetcode.problems.TreeNode

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * https://leetcode.com/problems/search-in-a-binary-search-tree/submissions/
 */
class SearchInABinarySearchTree {
    /**
     * Runtime: 228 ms, faster than 81.71% of Kotlin online submissions for Search in a Binary Search Tree.
     * Memory Usage: 36.5 MB, less than 76.83% of Kotlin online submissions for Search in a Binary Search Tree.
     */
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return root
        if (root.`val` == `val`) {
            return root
        }


        if (`val` < root.`val`) {
            if (root.left == null) {
                return null
            }
            return searchBST(root.left, `val`)
        }

        if (`val` > root.`val`) {
            if (root.right == null) {
                return null
            }
            return searchBST(root.right, `val`)
        }

        return null
    }
}