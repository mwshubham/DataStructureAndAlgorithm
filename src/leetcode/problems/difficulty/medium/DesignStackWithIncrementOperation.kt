package leetcode.problems.difficulty.medium

import kotlin.math.min


/**
 * 1381. Design a stack with increment operation
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/
 */
class CustomStack(val maxSize: Int) {

    var size = 0
    var start: Node? = null
    var end: Node? = null

    fun push(x: Int) {
        if (size == maxSize) {
            return
        }
        val newNode = Node(x)
        if (start == null) {
            start = newNode
            end = start
        } else {
            newNode.left = end
            end?.right = newNode
            end = newNode
        }
        size++
    }

    fun pop(): Int {
        if (size == 0) return -1
        println("pop: size: $size")
        var increment = 0
        var pointer = end
        println("end val: ${pointer!!.`val`}")
        println("end k: ${pointer.k}")
        while (pointer?.k != null) {
            println("pointer val: ${pointer.`val`}")
            println("pointer k: ${pointer.k}")

            if (pointer.k!! == size) {
                println("k >= size, increment is required")
                pointer.k = pointer.k!! - 1
                increment += pointer.`val`
                println("pop increment: $increment")
                if (pointer.k == 0) {
                    println("remove increment node")
                    val left = pointer.left
                    val right = pointer.right
                    left?.right = right
                    right?.left = left

                    // If we delete the 'end' or 'start' increment node, update class pointers
                    if (pointer == end) end = left
                    if (pointer == start) start = right

                    pointer = left
                } else {
                    pointer = pointer.left
                }
            } else {
                println("k < size, skip increment")
                pointer = pointer.left
            }
        }
        val left = pointer?.left
        val right = pointer?.right
        left?.right = right
        right?.left = left

        // If we delete the 'end' or 'start' increment node, update class pointers
        if (pointer == end) end = left
        if (pointer == start) start = right

        size--
        println("pop item val: ${pointer!!.`val`}")
        println("pop total increment: $increment")
        println("pop returns: ${pointer.`val` + increment}")
        println()
        return pointer.`val` + increment
    }

    fun increment(k: Int, `val`: Int) {
        if (`val` == 0) return
        if (size == 0) return
        if (k == 0) return
        val newNode = Node(
            `val` = `val`,
            k = min(size, k),
            left = end
        )
        end?.right = newNode
        end = newNode
    }
}

class Node(
    val `val`: Int,
    var k: Int? = null,
    var left: Node? = null,
    var right: Node? = null
)


class CustomStack2(val maxSize: Int) {
    private val stack = IntArray(maxSize)
    private val inc = IntArray(maxSize)
    private var top = -1

    fun push(x: Int) {
        if (top < maxSize - 1) {
            top++
            stack[top] = x
        }
    }

    fun pop(): Int {
        if (top < 0) return -1

        val result = stack[top] + inc[top]

        if (top > 0) {
            inc[top - 1] += inc[top]
        }

        inc[top] = 0
        top--

        return result
    }

    fun increment(k: Int, `val`: Int) {
        val idx = Math.min(top, k - 1)
        if (idx >= 0) {
            inc[idx] += `val`
        }
    }
}
