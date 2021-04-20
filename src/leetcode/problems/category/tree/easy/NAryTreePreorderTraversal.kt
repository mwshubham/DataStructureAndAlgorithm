package leetcode.problems.category.tree.easy

import java.util.*

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/submissions/
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3714/
 * https://leetcode.com/submissions/detail/482938756/?from=explore&item_id=3714
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