package leetcode.problems.queue


//Failed Test Case
//["MyCircularDeque","insertFront","insertFront","getFront","insertLast","insertLast","getFront","isFull","isEmpty","getFront","isFull","deleteLast","insertFront","deleteLast","insertLast","getRear","deleteLast","getFront","deleteFront","getFront","insertLast","getFront","insertFront","getRear","deleteFront","isFull","getRear","insertFront","insertFront","getRear","insertFront","getRear","getRear","getRear","isFull","insertFront","insertFront","getRear","isFull","deleteLast","getFront","getRear","isFull","deleteLast","insertFront","deleteLast","getFront","deleteLast","getRear","insertLast","deleteFront","getFront","getRear","insertLast","getRear","getFront","insertLast","getRear","getFront","getFront","deleteLast","insertLast","deleteFront","insertLast","getFront","insertFront","deleteLast","insertLast","getFront","getRear","insertLast","insertLast","insertFront","getFront","getFront","getRear","insertLast","deleteLast","deleteFront","insertLast","getFront","getRear","isFull","insertFront","getFront","insertLast","insertLast","getRear","getRear","deleteLast","insertFront","getFront","getFront","insertFront","insertLast","getRear","deleteLast","getFront","insertLast","insertLast","insertLast","deleteFront"]
//[[97],[35],[10],[],[17],[14],[],[],[],[],[],[],[6],[],[39],[],[],[],[],[],[8],[],[31],[],[],[],[],[91],[0],[],[57],[],[],[],[],[56],[28],[],[],[],[],[],[],[],[43],[],[],[],[],[85],[],[],[],[8],[],[],[84],[],[],[],[],[25],[],[26],[],[73],[],[39],[],[],[39],[8],[44],[],[],[],[43],[],[],[24],[],[],[],[81],[],[95],[91],[],[],[],[12],[],[],[3],[90],[],[],[],[32],[28],[64],[]]

// Passed Test Case
//["MyCircularDeque","insertFront","getFront","insertFront","getFront","deleteLast","insertFront","insertFront","getRear","getFront","getRear","getRear","insertLast","deleteFront","getFront","insertLast","getRear","insertLast","deleteFront","insertFront","isFull","getRear","deleteLast","insertLast","getRear","getFront","getFront","insertLast","insertFront","deleteFront","getRear","insertLast","deleteFront","insertFront","insertFront","getRear","getFront","insertFront","insertLast","getRear","getFront","insertFront","insertFront","insertLast","insertLast","getRear","isEmpty","deleteFront","getRear","getRear","getRear","insertLast","getFront","getFront","deleteLast","deleteLast","insertLast","getRear","getRear","insertLast","insertLast","insertFront","getFront","getRear","getFront","insertFront","insertFront","deleteFront","isEmpty","getFront","deleteFront","isFull","getFront","getRear","insertLast","getFront","insertLast","getRear","insertLast","insertFront","getRear","getFront","getFront","deleteLast","deleteLast","insertLast","getRear","getRear","getFront","deleteLast","isFull","insertLast","insertLast","insertFront","getFront","insertFront","isFull","getRear","insertFront","deleteLast","insertLast","insertLast"]
//[[52],[80],[],[27],[],[],[60],[81],[],[],[],[],[46],[],[],[98],[],[11],[],[51],[],[],[],[28],[],[],[],[28],[69],[],[],[11],[],[25],[74],[],[],[48],[7],[],[],[65],[59],[23],[32],[],[],[],[],[],[],[84],[],[],[],[],[64],[],[],[17],[34],[46],[],[],[],[6],[20],[],[],[],[],[],[],[],[34],[],[66],[],[54],[34],[],[],[],[],[],[43],[],[],[],[],[],[21],[93],[79],[],[8],[],[],[78],[],[7],[67]]

class DequeueNode(
    var value: Int,
    var next: DequeueNode? = null,
    var prev: DequeueNode? = null
)

/**
 * https://leetcode.com/problems/design-circular-deque/
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3696/
 * https://leetcode.com/submissions/detail/476328874/?from=explore&item_id=3696
 *
 */
class MyCircularDeque(val k: Int) {
    /** Initialize your data structure here. Set the size of the deque to be k. */
    var front: DequeueNode? = null
    var rear: DequeueNode? = null
    var size: Int = 0

    val capacity = k
    val head = DequeueNode(-1)
    val tail = DequeueNode(-1)

    init {
        head.next = tail
        tail.prev = head
    }


    fun enQueue(value: Int): Boolean {
        if (isFull()) return false

        val node = DequeueNode(value)
        val temp = tail.prev!!

        tail.prev = node
        node.next = tail

        node.prev = temp
        temp.next = node

        size++

        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false

        val node = head.next!!
        val temp = node.next!!

        head.next = temp
        temp.prev = head

        size--

        return true
    }

    fun Front(): Int {
        return if (isEmpty()) -1 else head.next!!.value
    }

    fun Rear(): Int {
        return if (isEmpty()) -1 else tail.prev!!.value
    }

    fun isEmpty(): Boolean {
        return head.next == tail
    }

    fun isFull(): Boolean {
        return size == capacity
    }
}
