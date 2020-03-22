package datastructure

data class Queue(val list: MutableList<Any>) {

    constructor() : this(mutableListOf())

    fun isEmpty(): Boolean = list.isEmpty()
    fun size(): Int = list.size

    fun peek(): Any? = list.firstOrNull()
    fun enqueue(element: Any) {
        list.add(element)
    }

    fun dequeue(): Any? {
        return if (isEmpty()) {
            null
        } else {
            list.removeAt(0)
        }
    }
}


fun main() {
    val queue = Queue()
//    val queue = Queue(mutableListOf(1, 3, 4, 5, 7))
    println(queue)
    queue.enqueue(1)
    queue.enqueue(3)
    queue.enqueue(4)
    queue.enqueue(5)
    queue.enqueue(7)
    println("queue.isEmpty(): ${queue.isEmpty()}")
    println("queue.size(): ${queue.size()}")
    println("queue.peek(): ${queue.peek()}")
    println(queue)
    queue.dequeue()
    queue.dequeue()
    queue.dequeue()
    queue.dequeue()
    println("queue.isEmpty(): ${queue.isEmpty()}")
    println("queue.size(): ${queue.size()}")
    println("queue.peek(): ${queue.peek()}")
    println(queue)
    queue.dequeue()
    queue.dequeue() // dequeue would be unsuccessful...
    println("queue.isEmpty(): ${queue.isEmpty()}")
    println("queue.size(): ${queue.size()}")
    println("queue.peek(): ${queue.peek()}")
}
