package leetcode.problems.category.tree.medium

/**
 * 116. Populating Next Right Pointers in Each Node
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/789/
 * https://leetcode.com/submissions/detail/600598675/?from=explore&item_id=789
 */
class PopulatingNextRightPointersInEachNode {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    companion object {
        /**
         * Runtime: 204 ms, faster than 59.31% of Kotlin online submissions for Populating Next Right Pointers in Each Node.
         * Memory Usage: 36.9 MB, less than 76.55% of Kotlin online submissions for Populating Next Right Pointers in Each Node.
         */
        fun connect(root: Node?): Node? {
            root ?: return null
            connect(root.left, root.right, root.next)
            return root
        }

        fun connect(left: Node?, right: Node?, parentNext: Node?) {
            if (left == null || right == null) return
            left.next = right
            right.next = parentNext?.left
            connect(left.left, left.right, left.next)
            connect(right.left, right.right, right.next)
        }
    }
}