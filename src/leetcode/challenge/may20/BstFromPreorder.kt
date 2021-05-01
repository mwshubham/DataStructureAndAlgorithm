package leetcode.challenge.may20

import datastructure.TreeNode

/**
 *
 * Constraints
 * 1 <= preorder.length <= 100
 * 1 <= preorder value <= 10^8
 * The values of preorder are distinct.
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/
 * https://leetcode.com/submissions/detail/344302395/?from=/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/
 */
class BstFromPreorder {
//    private lateinit var treeNode: TreeNode

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
//        preorder.forEachIndexed { index, value ->
//            if (index == 0) {
//                treeNode = TreeNode(value)
//            } else {
//                treeNode.insert(value)
//            }
//        }
//        return treeNode
        return bstFromPreorder(preorder, 0, preorder.size)
    }

    /**
     * Runtime: 152 ms
     * Memory Usage: 33.6 MB
     */
    private fun bstFromPreorder(preorder: IntArray, start: Int, end: Int): TreeNode? {
        if (start >= end || start == preorder.size) {
            return null
        }
        val node = TreeNode(preorder[start])
        var index = start + 1
        while (index < end && preorder[index] < preorder[start]) {
            index++
        }
        node.left = bstFromPreorder(preorder, start + 1, index)
        node.right = bstFromPreorder(preorder, index, end)
        return node
    }
}

fun main() {
    val inputArr = intArrayOf(8, 5, 1, 7, 10, 12)
    val instance = BstFromPreorder()
    instance.bstFromPreorder(inputArr)
    println(instance.bstFromPreorder(inputArr))
}
