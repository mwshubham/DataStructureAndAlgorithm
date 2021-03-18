import java.util.*
import kotlin.collections.HashSet

class LRUCache(private val capacity: Int) {

    /*[1, 2, 5, 4]*/
//    private val queue = LinkedList<Int>()
    private val queue = ArrayDeque<Int>()
    private val hashset = HashSet<Int>()

    fun refer(element: Int) {
        if (hashset.contains(element)) {
            queue.remove(element)
        } else {
            if (queue.size == capacity) {
                hashset.remove(queue.removeLast())
            }
        }
        hashset.add(element)
        queue.push(element)
    }

    fun display() {
        print(queue.toString())
    }

}

fun main() {
    val cache = LRUCache(4)
    cache.refer(1)
    cache.refer(2)
    cache.refer(3)
    cache.refer(1)
    cache.refer(4)
    cache.refer(5)
    cache.refer(2)
    cache.refer(2)
    cache.refer(1)
    cache.display()

}