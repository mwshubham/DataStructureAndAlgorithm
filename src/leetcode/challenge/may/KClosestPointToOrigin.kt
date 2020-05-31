package leetcode.challenge.may

import kotlin.math.sqrt

class KClosestPointToOrigin {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        points.forEach {
            println(it.asList())
        }
        ksort(points, 0, points.lastIndex, K)
        points.forEach {
            println(it.asList())
        }
        return points.copyOfRange(0, K)
    }


    private fun ksort(arr: Array<IntArray>, low: Int, high: Int, K: Int) {
        if (low < high) {
            val pivot = partition(arr, low, high)
            println("pivot: $pivot")
            println("arr: ${arr.asList()}")
            ksort(arr, low, pivot - 1, K)
            if (pivot < K) {
                ksort(arr, pivot + 1, high, K)
            }
        }
    }


//    fun sort(arr: Array<IntArray>, low: Int, high: Int) {
//        if (low < high) {
//            val pivot = partition(arr, low, high)
//            // println("pivot: $pivot")
//            // println("arr: ${arr.asList()}")
//            sort(arr, low, pivot - 1)
//            sort(arr, pivot + 1, high)
//        }
//    }

    private fun IntArray.dist() = sqrt((get(0) * get(0) + get(1) * get(1)).toDouble())

    private fun partition(arr: Array<IntArray>, low: Int, high: Int): Int {
//        println("low: $low")
//        println("high: $high")
        val pivot = arr[high].dist()
        println("pivot: $pivot")
        var i = low - 1
        for (j in low until high) {
            if (arr[j].dist() < pivot) {
                i++
                swap(arr, i, j)
//                println("arr: ${arr.asList()}")
            }
        }
        swap(arr, i + 1, high)
        return i + 1
    }

    private fun swap(arr: Array<IntArray>, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}

fun main() {
//    val instance = KClosestPointToOrigin()
}