package leetcode.problems.difficulty.medium

/**
 * 99. Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree
 */
class RecoverBinarySearchTree {
    var first: TreeNode? = null
    var second: TreeNode? = null
    var prev: TreeNode? = null

    fun recoverTree(root: TreeNode?) {
        inorder(root)
        println("first: ${first!!.`val`}")
        println("second: ${second!!.`val`}")
        val temp = first!!.`val`
        first!!.`val` = second!!.`val`
        second!!.`val` = temp
    }

    fun inorder(node: TreeNode?) {
        if (node == null) return
        inorder(node.left)
        if (prev != null && node.`val` < prev!!.`val`) {
            if (first == null) first = prev
            second = node
        }
        prev = node
        inorder(node.right)
    }
}