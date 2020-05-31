package random

import java.lang.StringBuilder
import java.util.*
import kotlin.math.pow


class Node(
    val data: Int,
    var next: Node? = null
) {

    fun getSum(): Int {
        var tempNode: Node? = this
        var sum = 0.0
        val stack = Stack<Int>()
        while (tempNode != null) {
            stack.push(tempNode.data)
            tempNode = tempNode.next
        }
        var counter = 0.0
        while (stack.isNotEmpty()) {
            sum += stack.pop() * 10.0.pow(counter)
            counter++
        }
        return sum.toInt()
    }
}

fun main() {

//    6, 1, 2
//    7, 9, 3
    val string = "aaabc"
    var lastKnownChar: Char? = null
//    aaabc
//    a -> 2
//    b -> 0
//    c -> 0
//    abaca

    val result = StringBuilder()
//  result.append(lastKnownChar)
    string.toCharArray().forEachIndexed { index, char ->
        if (char != lastKnownChar){
            result.append(char)
            lastKnownChar = char
        }
    }
    println(result)
    println()
    println()
    println()

    val list1 = Node(
        data = 6,
        next = Node(
            data = 1,
            next = Node(
                data = 2
            )
        )
    )

    val list2 = Node(
        data = 7,
        next = Node(
            data = 9,
            next = Node(
                data = 3
            )
        )
    )
    println(list1.getSum() + list2.getSum())
}