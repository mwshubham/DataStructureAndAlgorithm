package leetcode.problems.category.tree.easy

import java.util.*

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/submissions/
 */
class NAryTreePostorderTraversal {
    var output = LinkedList<Int>()

    /**
     * Runtime: 196 ms, faster than 100.00% of Kotlin online submissions for N-ary Tree Postorder Traversal.
     * Memory Usage: 38.8 MB, less than 30.30% of Kotlin online submissions for N-ary Tree Postorder Traversal.
     */
    fun postorder(root: Node?): List<Int> {
        if (root == null) return output
        root.children.forEach {
            postorder(it)
        }
        output.add(root.`val`)
        return output
    }
}
