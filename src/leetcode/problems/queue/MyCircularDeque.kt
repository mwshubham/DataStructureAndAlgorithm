package leetcode.problems.queue

class DequeueNode(
    var value: Int,
    var next: DequeueNode? = null,
    var prev: DequeueNode? = null
)

//Failed Test Case
//["MyCircularDeque","insertFront","insertFront","getFront","insertLast","insertLast","getFront","isFull","isEmpty","getFront","isFull","deleteLast","insertFront","deleteLast","insertLast","getRear","deleteLast","getFront","deleteFront","getFront","insertLast","getFront","insertFront","getRear","deleteFront","isFull","getRear","insertFront","insertFront","getRear","insertFront","getRear","getRear","getRear","isFull","insertFront","insertFront","getRear","isFull","deleteLast","getFront","getRear","isFull","deleteLast","insertFront","deleteLast","getFront","deleteLast","getRear","insertLast","deleteFront","getFront","getRear","insertLast","getRear","getFront","insertLast","getRear","getFront","getFront","deleteLast","insertLast","deleteFront","insertLast","getFront","insertFront","deleteLast","insertLast","getFront","getRear","insertLast","insertLast","insertFront","getFront","getFront","getRear","insertLast","deleteLast","deleteFront","insertLast","getFront","getRear","isFull","insertFront","getFront","insertLast","insertLast","getRear","getRear","deleteLast","insertFront","getFront","getFront","insertFront","insertLast","getRear","deleteLast","getFront","insertLast","insertLast","insertLast","deleteFront"]
//[[97],[35],[10],[],[17],[14],[],[],[],[],[],[],[6],[],[39],[],[],[],[],[],[8],[],[31],[],[],[],[],[91],[0],[],[57],[],[],[],[],[56],[28],[],[],[],[],[],[],[],[43],[],[],[],[],[85],[],[],[],[8],[],[],[84],[],[],[],[],[25],[],[26],[],[73],[],[39],[],[],[39],[8],[44],[],[],[],[43],[],[],[24],[],[],[],[81],[],[95],[91],[],[],[],[12],[],[],[3],[90],[],[],[],[32],[28],[64],[]]

// Passed Test Case
//["MyCircularDeque","insertFront","getFront","insertFront","getFront","deleteLast","insertFront","insertFront","getRear","getFront","getRear","getRear","insertLast","deleteFront","getFront","insertLast","getRear","insertLast","deleteFront","insertFront","isFull","getRear","deleteLast","insertLast","getRear","getFront","getFront","insertLast","insertFront","deleteFront","getRear","insertLast","deleteFront","insertFront","insertFront","getRear","getFront","insertFront","insertLast","getRear","getFront","insertFront","insertFront","insertLast","insertLast","getRear","isEmpty","deleteFront","getRear","getRear","getRear","insertLast","getFront","getFront","deleteLast","deleteLast","insertLast","getRear","getRear","insertLast","insertLast","insertFront","getFront","getRear","getFront","insertFront","insertFront","deleteFront","isEmpty","getFront","deleteFront","isFull","getFront","getRear","insertLast","getFront","insertLast","getRear","insertLast","insertFront","getRear","getFront","getFront","deleteLast","deleteLast","insertLast","getRear","getRear","getFront","deleteLast","isFull","insertLast","insertLast","insertFront","getFront","insertFront","isFull","getRear","insertFront","deleteLast","insertLast","insertLast"]
//[[52],[80],[],[27],[],[],[60],[81],[],[],[],[],[46],[],[],[98],[],[11],[],[51],[],[],[],[28],[],[],[],[28],[69],[],[],[11],[],[25],[74],[],[],[48],[7],[],[],[65],[59],[23],[32],[],[],[],[],[],[],[84],[],[],[],[],[64],[],[],[17],[34],[46],[],[],[],[6],[20],[],[],[],[],[],[],[],[34],[],[66],[],[54],[34],[],[],[],[],[],[43],[],[],[],[],[],[21],[93],[79],[],[8],[],[],[78],[],[7],[67]]

/**
 * https://leetcode.com/problems/design-circular-deque/
 * WRONG ANSWER
 */
class MyCircularDeque(val k: Int) {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    var front: DequeueNode? = null
    var rear: DequeueNode? = null
    var size: Int = 0

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    fun insertFront(value: Int): Boolean {
        when (size) {
            k -> {
                return false
            }
            0 -> {
                DequeueNode(value).let {
                    front = it
                    front?.prev = it
                    front?.next = it
                    rear = it
                }
            }
            else -> {
                DequeueNode(value).let {
                    it.prev = front?.prev
                    it.next = front
                    front = it
                }
            }
        }
        size++
        return true
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    fun insertLast(value: Int): Boolean {
        when (size) {
            k -> {
                return false
            }
            0 -> {
                DequeueNode(value).let {
                    front = it
                    front?.prev = it
                    front?.next = it
                    rear = it
                }
            }
            else -> {
                DequeueNode(value).let {
                    it.prev = rear
                    it.next = rear?.next
                    rear = it
                }
            }
        }
        size++
        return true
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    fun deleteFront(): Boolean {
        if (size == 0) {
            return false
        }
        if (size == 1) {
            front = null
            rear = null
            size--
            return true
        }
        if (size == 2) {
            rear?.next = rear
            rear?.prev = rear
            front = rear
            size--
            return true
        }
        val temp = front
        front = front?.next
        front?.prev = temp?.prev
        size--
        return true
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    fun deleteLast(): Boolean {
        if (size == 0) {
            return false
        }
        if (size == 1) {
            front = null
            rear = null
            size--
            return true
        }
        if (size == 2) {
            front?.next = front
            front?.prev = front
            rear = front
            size--
            return true
        }
        val temp = rear
        rear = rear?.prev
        rear?.next = temp?.next
        size--

        return true
    }

    /** Get the front item from the deque. */
    fun getFront(): Int {
        if (size == 0) {
            return -1
        }
        return front!!.value
    }

    /** Get the last item from the deque. */
    fun getRear(): Int {
        if (size == 0) {
            return -1
        }
        return rear!!.value
    }

    /** Checks whether the circular deque is empty or not. */
    fun isEmpty(): Boolean {
        return size == 0
    }

    /** Checks whether the circular deque is full or not. */
    fun isFull(): Boolean {
        return size == k
    }

}
