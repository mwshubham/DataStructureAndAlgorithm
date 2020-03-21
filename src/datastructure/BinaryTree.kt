package datastructure

import kotlin.math.max
import kotlin.math.min

open class BinaryTree {
    open var root: TreeNode? = null

    fun insert(value: Int) {
        if (root == null) {
            root = TreeNode(value)
            return
        }
        insert(root!!, value)
    }

    open fun insert(node: TreeNode, value: Int) {
        if (node.left == null) {
            node.left = TreeNode(value)
            return
        }

        if (node.right == null) {
            node.right = TreeNode(value)
            return
        }

        if (node.left!!.left == null || node.left!!.right == null) {
            insert(node.left!!, value)
            return
        }

        if (node.right!!.left == null || node.right!!.right == null) {
            insert(node.right!!, value)
            return
        }
        insert(node.left!!, value)
    }

    fun traverse() {
        println("traverse()")
        if (root == null) {
            println("Empty Tree")
            return
        }
        root?.let { traverse(it) }
    }

    open fun traverse(node: TreeNode) {
        println(node.value)
        node.left?.let { traverse(it) }
        node.right?.let { traverse(it) }
    }

    fun minDepth(): Int {
        return minDepth(root!!)
    }

    /**
     * Depth first approach...
     *
     * Time Complexity: O(n)
     * Space Complexity:  O(h) for recursion call stack.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun minDepth(node: TreeNode? = null): Int {
        if (node == null) {
            return 0
        }
        if (node.left == null && node.right == null) {
            return 1
        }

        if (node.left == null) {
            return 1 + minDepth(node.right)
        }

        if (node.right == null) {
            return 1 + minDepth(node.left)
        }
        return 1 + min(minDepth(node.left), minDepth(node.right))
    }

    fun maxDepth(): Int {
        return maxDepth(root!!)
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun maxDepth(node: TreeNode? = null): Int {
        if (node == null) {
            return 0
        }
        if (node.left == null && node.right == null) {
            return 1
        }

        if (node.left == null) {
            return 1 + maxDepth(node.right)
        }

        if (node.right == null) {
            return 1 + maxDepth(node.left)
        }
        return 1 + max(maxDepth(node.left), maxDepth(node.right))
    }
}
