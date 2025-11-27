import java.util.*
import kotlin.collections.HashSet


class Node(var key: Int, var value: Int) {
    var prev: Node? = null
    var next: Node? = null
}

class LRUCache(private val capacity: Int) {

    /*[1, 2, 5, 4]*/
//    private val queue = LinkedList<Int>()
    private val queue = ArrayDeque<Int>()
    private val hashset = HashSet<Int>()

    var tail: Node? = Node(0, 0).apply {
        prev = null
    }

    var head = Node(0, 0).apply {
        next = tail
    }

    var map = HashMap<Int, Node>()

    fun get(key: Int): Int {
        return if (map.containsKey(key)) {
            val node = map[key]!!
            remove(node)
            insert(node)
            node.value
        } else {
            -1
        }
    }
    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            remove(map[key]!!)
        }
        if (map.size == capacity) {
            remove(tail!!.prev!!)
        }
        insert(Node(key, value))
    }

    private fun remove(node: Node) {
        map.remove(node.key)
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun insert(node: Node) {
        map[node.key] = node
        val headNext = head.next
        head.next = node
        node.prev = head
        headNext?.prev = node
        node.next = headNext
    }

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