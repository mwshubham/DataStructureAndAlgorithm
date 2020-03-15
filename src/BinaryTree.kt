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
}
