package leetcode.problems.category.tree.easy

import java.util.*

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/submissions/
 */
class NAryTreePreorderTraversal {
    var output = LinkedList<Int>()

    /**
     * Runtime: 220 ms, faster than 57.58% of Kotlin online submissions for N-ary Tree Preorder Traversal.
     * Memory Usage: 38.5 MB, less than 54.55% of Kotlin online submissions for N-ary Tree Preorder Traversal.
     */
    fun preorder(root: Node?): List<Int> {
        if (root == null) return output
        output.add(root.`val`)
        root.children.forEach {
            preorder(it)
        }
        return output
    }
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}