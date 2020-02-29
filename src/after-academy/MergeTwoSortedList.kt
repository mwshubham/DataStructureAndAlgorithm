package `after-academy`

// https://afteracademy.com/blog/merge-two-sorted-lists
// Merge Two Sorted Lists
// Problem Description: Merge two sorted linked lists and return the head of the new sorted list.

fun main() {
    //val listA = listOf<Int>()
    //    val listA = listOf(1, 2, 4)
    val listA = listOf(6, 25)

    //val listB = listOf<Int>()
//    val listB = listOf(1, 3)
    val listB = listOf(1, 3, 4)

    println(" --------- START --------- ")
    if (listA.isEmpty()) {
        println(listB)
        return
    }
    if (listB.isEmpty()) {
        println(listA)
        return
    }
    twoPointersApproach(listA, listB)
    println(" --------- END --------- ")
}

fun twoPointersApproach(listA: List<Int>, listB: List<Int>) {
    var headA = 0
    var headB = 0

    val listC = mutableListOf<Int>()
    while (headA <= listA.lastIndex && headB <= listB.lastIndex) {
        when {
            listA[headA] == listB[headB] -> {
                listC.add(listA[headA])
                headA++
                listC.add(listB[headB])
                headB++
            }
            listA[headA] < listB[headB] -> {
                listC.add(listA[headA])
                headA++
            }
            listA[headA] > listB[headB] -> {
                listC.add(listB[headB])
                headB++
            }
        }
    }
    if (headA <= listA.lastIndex)
        listC.addAll(listA.subList(headA, listA.size))
    if (headB <= listB.lastIndex)
        listC.addAll(listB.subList(headB, listB.size))

    println(listC)
}