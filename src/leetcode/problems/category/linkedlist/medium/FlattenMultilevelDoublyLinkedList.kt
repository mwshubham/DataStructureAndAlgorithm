package leetcode.problems.category.linkedlist.medium

// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
class FlattenMultilevelDoublyLinkedList {

    fun flatten(head: Node?): Node? {
        if (head == null) return head
        // Pointer
        var p: Node? = head
        while (p != null) {
            if (p.child == null) {
                p = p.next
                continue
            }
            var temp: Node = p.child!!
            // Find the tail of the child
            while (temp.next != null) temp = temp.next!!
            // Connect tail with p.next, if it is not null
            temp.next = p.next
            if (p.next != null) p.next!!.prev = temp
            // Connect p with p.child, and remove p.child
            p.next = p.child
            p.child!!.prev = p
            p.child = null
        }
        return head
    }
}

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}
