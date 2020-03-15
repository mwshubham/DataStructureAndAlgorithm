@file:Suppress("unused")

class SortedBinaryTree : BinaryTree() {

    override fun insert(node: TreeNode, value: Int) {
        if (value <= node.value) {
            if (node.left == null) {
                node.left = TreeNode(value)
            } else {
                insert(node.left!!, value)
            }
        } else {
            if (node.right == null) {
                node.right = TreeNode(value)
            } else {
                insert(node.right!!, value)
            }
        }
    }
}
