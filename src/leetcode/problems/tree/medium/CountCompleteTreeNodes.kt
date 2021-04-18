package leetcode.problems.tree.medium

import leetcode.problems.TreeNode
import kotlin.math.max

/**
 * 222. Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
class CountCompleteTreeNodes {
    companion object {
        /**
         * Runtime: 204 ms, faster than 72.92% of Kotlin online submissions for Count Complete Tree Nodes.
         * Memory Usage: 39.4 MB, less than 31.25% of Kotlin online submissions for Count Complete Tree Nodes.
         */
        fun countNodesNaiveApproach(root: TreeNode?): Int {
            root ?: return 0
            return 1 + countNodesNaiveApproach(root.left) + countNodesNaiveApproach(root.right)
        }

        /**
         * Runtime: 204 ms, faster than 72.92% of Kotlin online submissions for Count Complete Tree Nodes.
         * Memory Usage: 39.3 MB, less than 50.00% of Kotlin online submissions for Count Complete Tree Nodes.
         */
        fun countNodes(root: TreeNode?): Int {
            val height = height(root)
            return if (height < 0) {
                return 0
            } else {
                if (height(root?.right) == height - 1) {
                    (1 shl height) + countNodes(root?.right)
                } else {
                    (1 shl (height - 1)) + countNodes(root?.left)
                }
            }
        }

        private fun height(node: TreeNode?): Int {
            node ?: return -1
            return 1 + height(node.left)

        }
    }
}