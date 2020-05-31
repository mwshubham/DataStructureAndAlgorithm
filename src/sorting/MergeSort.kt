package sorting

// https://www.geeksforgeeks.org/merge-sort/

private val arr = intArrayOf(38, 27, 43, 3, 9, 82, 10)

fun main() {
    println(" --------- START --------- ")
    println("Input:" + arr.toList())
    sort(0, arr.lastIndex)
    println("Output:" + arr.toList())
    println(" --------- END --------- ")
}

fun sort(l: Int, r: Int) {
//    println("l: $l, r: $r")
    if (l < r) {
        val m: Int = (l + r) / 2
//        println("m: $m")
        sort(l, m)
        sort(m + 1, r)
        merge(l, m, r)
    }
}

fun merge(l: Int, m: Int, r: Int) {
    val sizeOfLeft = m - l + 1
    val sizeOfRight = r - m

    val leftArr = IntArray(sizeOfLeft)
    val rightArr = IntArray(sizeOfRight)


    for (index in 0 until sizeOfLeft) {
        leftArr[index] = arr[l + index]
    }
    for (index in 0 until sizeOfRight) {
        rightArr[index] = arr[m + 1 + index]
    }

    var headOfLeft = 0
    var headOfRight = 0

    var temp = l

    while (headOfLeft < sizeOfLeft && headOfRight < sizeOfRight) {
        if (leftArr[headOfLeft] <= rightArr[headOfRight]) {
            arr[temp] = leftArr[headOfLeft]
            headOfLeft++
        } else {
            arr[temp] = rightArr[headOfRight]
            headOfRight++
        }
        temp++
    }

    while (headOfLeft < sizeOfLeft) {
        arr[temp] = leftArr[headOfLeft]
        headOfLeft++
        temp++
    }
    while (headOfRight < sizeOfRight) {
        arr[temp] = rightArr[headOfRight]
        headOfRight++
        temp++
    }
}