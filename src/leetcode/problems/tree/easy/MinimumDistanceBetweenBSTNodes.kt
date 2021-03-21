package leetcode.problems.tree.easy

import leetcode.problems.TreeNode
import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/submissions/
 */
class MinimumDistanceBetweenBSTNodes {

    //    [4,2,6,1,3]
    //    [1,0,48,null,null,12,49]
    //    [27,null,34,null,58,50,null,44]
    private var firstMin = -1
    var secondMin = -1
    var minDiff = Int.MAX_VALUE

    /**
     * Runtime: 140 ms, faster than 93.75% of Kotlin online submissions for Minimum Distance Between BST Nodes.
     * Memory Usage: 33.6 MB, less than 68.75% of Kotlin online submissions for Minimum Distance Between BST Nodes.
     */
    fun minDiffInBST(root: TreeNode?): Int {
        root ?: return -1
        inorder(root)
        return minDiff
    }

    private fun inorder(root: TreeNode?) {
        if (root == null) return
        inorder(root.left)
        secondMin = firstMin
        firstMin = root.`val`
        if (firstMin != -1 && secondMin != -1) {
            minDiff = min(minDiff, firstMin - secondMin)
        }
//        println(root.`val`)
//        println("secondMin: $secondMin")
//        println("firstMin: $firstMin")
//        println("minDiff: $minDiff")
        inorder(root.right)
    }
}