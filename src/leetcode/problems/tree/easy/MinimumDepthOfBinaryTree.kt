package leetcode.problems.tree.easy

import com.sun.source.tree.Tree
import leetcode.problems.TreeNode
import java.lang.IllegalStateException
import java.util.*
import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
class MinimumDepthOfBinaryTree {
    // [3,9,20,null,null,15,7]
    // [2,null,3,null,4,null,5,null,6]
    // [1,2,3,4,null,null,5]
    companion object {
        /**
         * Using BFS
         * Runtime: 444 ms, faster than 89.16% of Kotlin online submissions for Minimum Depth of Binary Tree.
         * Memory Usage: 54.1 MB, less than 54.22% of Kotlin online submissions for Minimum Depth of Binary Tree.
         */
        fun minDepth(root: TreeNode?): Int {
            root ?: return 0
            val queue = LinkedList<TreeNode>()
            var minDepth = 0
            queue.addLast(root)
            while (queue.isNotEmpty()) {
                minDepth++
                val size = queue.size
                repeat(size) {
                    queue.pop().let {
                        if (it.left == null && it.right == null) {
                            return minDepth
                        }
                        it.left?.let {
                            queue.addLast(it)
                        }
                        it.right?.let {
                            queue.addLast(it)
                        }
                    }
                }
            }
            throw IllegalStateException("This will never happen")
        }

        /**
         * Using DFS
         * Runtime: 448 ms, faster than 83.13% of Kotlin online submissions for Minimum Depth of Binary Tree.
         * Memory Usage: 55.3 MB, less than 37.35% of Kotlin online submissions for Minimum Depth of Binary Tree.
         */
        fun minDepth2(root: TreeNode?): Int {
            root ?: return 0
            val minLeft = minDepth2(root.left)
            val minRight = minDepth2(root.right)
            return if (minLeft == 0 || minRight == 0) minLeft + minRight + 1
            else min(minLeft, minRight) + 1
        }
    }

}

//[3,9,20,null,null,15,7]
//[2,null,3,null,4,null,5,null,6]
fun main() {
//    val root = TreeNode(2).apply {
//        right = TreeNode(3).apply {
//            right = TreeNode(4).apply {
//                right = TreeNode(5).apply {
//                    right = TreeNode(6)
//                }
//            }
//        }
//    }

    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
    }
    MinimumDepthOfBinaryTree.minDepth(root)
}