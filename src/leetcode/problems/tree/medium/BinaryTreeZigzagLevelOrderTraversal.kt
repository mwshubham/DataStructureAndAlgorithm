package leetcode.problems.tree.medium

import leetcode.problems.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
//[3,9,20,null,null,15,7]
//[1]
//[]
//[1,2,3,4,null,null,5]
class BinaryTreeZigzagLevelOrderTraversal {
    companion object {

        /**
         * Runtime: 172 ms, faster than 75.70% of Kotlin online submissions for Binary Tree Zigzag Level Order Traversal.
         * Memory Usage: 35.8 MB, less than 50.47% of Kotlin online submissions for Binary Tree Zigzag Level Order Traversal.
         */
        fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
            val result = ArrayList<List<Int>>()
            root ?: return result

            result.add(listOf(root.`val`))

            val listOfTreeNodes = LinkedList<TreeNode>()
            listOfTreeNodes.add(root)
            var readReverse = true
            while (listOfTreeNodes.isNotEmpty()) {
                val listOfValues = ArrayList<Int>()
                repeat(listOfTreeNodes.size) {
                    listOfTreeNodes.removeFirst().let { node ->
                        node.left?.let { child ->
                            if (readReverse) {
                                listOfValues.add(0, child.`val`)
                            } else {
                                listOfValues.add(child.`val`)
                            }
                            listOfTreeNodes.add(child)
                        }
                        node.right?.let { child ->
                            if (readReverse) {
                                listOfValues.add(0, child.`val`)
                            } else {
                                listOfValues.add(child.`val`)
                            }
                            listOfTreeNodes.add(child)
                        }
                    }
                }
                readReverse = !readReverse
                if (listOfValues.isNotEmpty()) {
                    result.add(listOfValues)
                }
            }
            return result
        }
    }
}