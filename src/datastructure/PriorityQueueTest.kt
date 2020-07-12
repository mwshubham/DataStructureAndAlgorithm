package datastructure

import java.util.*

fun main() {
    val pQueue = PriorityQueue<Int>()
    pQueue.add(1)
    pQueue.add(3)
    pQueue.add(5)
    pQueue.add(7)

    println("pQueue: $pQueue")
    println("pQueue.peek(): ${pQueue.peek()}")
    println("pQueue.remove(): ${pQueue.remove()}")
    println("pQueue: $pQueue")

    println("pQueue: $pQueue")
    println("pQueue.peek(): ${pQueue.peek()}")
    println("pQueue.remove(): ${pQueue.remove()}")
    println("pQueue: $pQueue")

    pQueue.add(2)
    pQueue.add(3)
    pQueue.add(1)
    println("pQueue: $pQueue")
    println("pQueue.peek(): ${pQueue.peek()}")
    println("pQueue.remove(): ${pQueue.remove()}")
    println("pQueue: $pQueue")

}