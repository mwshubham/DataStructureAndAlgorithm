package datastructure

class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun TreeNode.insert(value: Int) {
    if (value > `val`) {
        if (this.right == null) {
            this.right = TreeNode(value)
        } else {
            this.right?.insert(value)
        }
    } else if (value < `val`) {
        if (this.left == null) {
            this.left = TreeNode(value)
        } else {
            this.left?.insert(value)
        }
    }
}