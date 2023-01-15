package leetcode.problems.difficulty.medium

import java.lang.StringBuilder
import java.util.LinkedList

/**
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
class SerializeAndDeserializeBinaryTree {
    companion object {

        private val ID_NULL = "X"
        private val SEPARATOR = ","

        // Encodes a URL to a shortened URL.
        fun serialize(root: TreeNode?): String {
            root ?: return ""
            val sb = StringBuilder()
            buildString(sb, root)
            return sb.toString()
        }

        private fun buildString(sb: StringBuilder, root: TreeNode?) {
            if (sb.isNotEmpty()) {
                sb.append(SEPARATOR)
            }
            if (root == null) {
                sb.append(ID_NULL)
            } else {
                sb.append(root.`val`)
                buildString(sb, root.left)
                buildString(sb, root.right)
            }
        }

        // Decodes your encoded data to tree.
        fun deserialize(data: String): TreeNode? {
            if (data.isEmpty()) return null
            val nodes = LinkedList<String>()
            nodes.addAll(data.split(SEPARATOR))
            return buildTree(nodes)
        }

        private fun buildTree(nodes: LinkedList<String>): TreeNode? {
            val value = nodes.poll()
            return if (value == ID_NULL) {
                null
            } else {
                TreeNode(value.toInt()).apply {
                    left = buildTree(nodes)
                    right = buildTree(nodes)
                }
            }
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
