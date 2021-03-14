package leetcode.problems.tree.easy

import com.sun.source.tree.Tree
import leetcode.problems.TreeNode

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 * https://leetcode.com/problems/increasing-order-search-tree/submissions/
 */
class IncreasingOrderSearchTree {
    var newRoot: TreeNode? = null
    var prev: TreeNode? = null

    /**
     * Runtime: 148 ms, faster than 35.71% of Kotlin online submissions for Increasing Order Search Tree.
     * Memory Usage: 33.7 MB, less than 78.57% of Kotlin online submissions for Increasing Order Search Tree.
     */
    fun increasingBST(root: TreeNode?): TreeNode? {
        if (root == null) return null
        increasingBST(root.left)

        prev?.let {
            root.left = null
            it.right = root
        }

        // record the most left node as it will be our root
        if (newRoot == null) {
            newRoot = root
        }
        //keep track of the prev node
        prev = root
        increasingBST(root.right)
        return newRoot
    }
}