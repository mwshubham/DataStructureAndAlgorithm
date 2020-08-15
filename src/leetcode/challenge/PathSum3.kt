package leetcode.challenge

import datastructure.TreeNode
import kotlin.math.abs

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3417/
class PathSum3 {
    private var _sum = 0
    var result = 0
    private val dp1 = arrayListOf<Int>()

    fun pathSum(root: TreeNode?, sum: Int): Int {
        result = 0
        _sum = sum
        dp1.clear()
        pathSum(root)
        return result
    }

    private fun pathSum(root: TreeNode?) {
//        println("Result: $result")
//        println("Traversing: ${root?.`val`}")
//        println("dp1: $dp1")
//        println("")
        if (root == null) return
        if (root.`val` == _sum) {
            result++
        }
        dp1.add(root.`val` + dp1.getOrElse(dp1.lastIndex) { 0 })
        pathSum(root.left)
        pathSum(root.right)
        pathFound()
        dp1.removeAt(dp1.lastIndex)
    }

    private fun pathFound() {
        (1..dp1.lastIndex).forEach {
            if (dp1[it] == _sum) {
                result++
            }
        }
        for (i in 0 until dp1.lastIndex) {
            if (abs(dp1[dp1.lastIndex] - dp1[i]) == _sum) {
                if (dp1[i] == 0) {
                    result++
                } else if (dp1.lastIndex - i > 1) {
                    result++
                }
            }
        }
    }
}

//[10,5,-3,3,2,null,11,3,-2,null,1]
//6
//[10,5,-3,3,2,null,11,3,-2,null,1]
//8
//[5,4,8,11,null,13,4,7,2,null,null,5,1]
//22
//[-2,null,-3]
//-3
//[-2,null,-3]
//-2
//[-2,null,-3]
//1
//[0,0,0]
//0
//[0,0]
//0
//[0]
//0
//[1,2]
//2
//[1,-2,-3,1,3,-2,null,-1]
//2
fun main() {
    val instance = PathSum3()
    val result = instance.pathSum(TreeNode(-2).apply {
        right = TreeNode(-3)
    }, -2)
    println(result)
}

//val result = instance.pathSum(TreeNode(1).apply {
//    left = TreeNode(2)
//}, 2)

//[5,4,8,11,null,13,4,7,2,null,null,5,1]
//val result = instance.pathSum(TreeNode(5).apply {
//    left = TreeNode(4).apply {
//        left = TreeNode(11).apply {
//            left = TreeNode(7)
//            right = TreeNode(2)
//        }
//        right = null
//    }
//    right = TreeNode(8).apply {
//        left = TreeNode(13).apply {
//            left = TreeNode(5)
//            right = TreeNode(1)
//        }
//        right = TreeNode(4)
//    }
//}, 22)

// [10,5,-3,3,2,null,11,3,-2,null,1]
//    val result = instance.pathSum(TreeNode(10).apply {
//        left = TreeNode(5).apply {
//            left = TreeNode(3).apply {
//                left = TreeNode(3)
//                right = TreeNode(-2)
//            }
//            right = TreeNode(2).apply {
//                left = null
//                right = TreeNode(1)
//            }
//        }
//        right = TreeNode(-3).apply {
//            left = null
//            right = TreeNode(11)
//        }
//    }, 8)