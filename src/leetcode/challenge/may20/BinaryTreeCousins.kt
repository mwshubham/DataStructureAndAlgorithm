package leetcode.challenge.may20

import datastructure.TreeNode
import java.util.*
import kotlin.collections.ArrayList


class BinaryTreeCousins {

    /**
     * Runtime: 144 ms, faster than 100.00% of Kotlin online submissions for Cousins in Binary Tree.
     * Memory Usage: 33.8 MB, less than 100.00% of Kotlin online submissions for Cousins in Binary Tree.
     */
    fun isCousinsUsingBFS(root: TreeNode?, x: Int, y: Int): Boolean {
        root ?: return false
        val queue = LinkedList<TreeNode>()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            var isXexist = false
            var isYexist = false
            repeat(size) {
                val current = queue.poll()
                if (current.`val` == x) isXexist = true
                if (current.`val` == y) isYexist = true
                if (current.left != null && current.right != null) {
                    if (current.left!!.`val` == x && current.right!!.`val` == y) {
                        return false
                    }
                    if (current.left!!.`val` == y && current.right!!.`val` == x) {
                        return false
                    }
                }
                current.left?.let { queue.offer(it) }
                current.right?.let { queue.offer(it) }
            }
            if (isXexist && isYexist) return true
        }
        return false
    }

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        root ?: return false
        val height = getHeight(root)
        println("height: $height")
        val intList = ArrayList<Int>()
        var index = 3
        while (index <= height) {
            intList.clear()
            updateElementInSameLevel(root, index, intList)
            println(intList)
            if (intList.contains(x) && intList.contains(y)) {
                var flagShouldNotBeAdjacent = true
                intList.forEachIndexed { position, _ ->
                    if (flagShouldNotBeAdjacent
                        && ((intList[position] == x && intList.getOrNull(position + 1) == y)
                                || (intList[position] == y && intList.getOrNull(position + 1) == x))
                    ) {
                        return false
                    }
                    flagShouldNotBeAdjacent = flagShouldNotBeAdjacent == false
                }
                return true
            }
            index++
        }
        return false
    }

    private fun updateElementInSameLevel(node: TreeNode?, level: Int, intList: MutableList<Int>) {
        if (node == null) {
            if (level == 1) {
                intList.add(0)
            }
            return
        }
        if (level == 1)
            intList.add(node.`val`)
        else if (level > 1) {
            updateElementInSameLevel(node.left, level - 1, intList)
            updateElementInSameLevel(node.right, level - 1, intList)
        }
    }

    private fun getHeight(node: TreeNode?): Int {
        return if (node == null) 0
        else {
            val leftHeight = getHeight(node.left)
            val rightHeight = getHeight(node.right)
            if (leftHeight > rightHeight)
                leftHeight + 1
            else
                rightHeight + 1
        }
    }
}

fun main() {
    val root = TreeNode(1)

//    root.left = TreeNode(0)
    root.right = TreeNode(2)

//    root.left!!.left = TreeNode(0)
//    root.left!!.right = TreeNode(4)
    root.right!!.left = TreeNode(3)
    root.right!!.right = TreeNode(5)

    root.right!!.left!!.left = TreeNode(4)
//    root.right!!.left!!.right = TreeNode(5)
//    root.right!!.right!!.left = TreeNode(4)
//    root.right!!.right!!.right = TreeNode(5)

//    root.right!!.left!!.left!!.left = TreeNode(4)
    root.right!!.left!!.left!!.right = TreeNode(4)
    println(BinaryTreeCousins().isCousins(root, 5, 3))
}

