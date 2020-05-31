package sorting


class QuickSort {

    fun sort(arr: IntArray, low: Int, high: Int) {
        println("low: $low , high: $high")

        if (low < high) {
            val pivot = partition(arr, low, high)
            println("pivot: $pivot")
            println("arr: ${arr.asList()}")
            println()
            println()
            println("- left -")
            sort(arr, low, pivot - 1)
            println("- right -")
            sort(arr, pivot + 1, high)
        }
    }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1
        println("i: $i , j: $low")
        for (j in low until high) {
            if (arr[j] < pivot) {
                i++
                swap(arr, i, j)
//                println("arr: ${arr.asList()}")
            }
        }
        swap(arr, i + 1, high)
        return i + 1
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}

fun main() {
//    val arr = intArrayOf(10, 16, 8, 12, 15, 6, 3, 9, 5)
//    val arr = intArrayOf(38, 27, 43, 3, 9, 82, 10)
    val arr = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
    println(" --------- START --------- ")
    println("Input:" + arr.toList())
    println()
    println()
    println()
    val instance = QuickSort()
    instance.sort(arr, 0, arr.lastIndex)
    println()
    println()
    println()
    println("Output:" + arr.toList())
    println(" --------- END --------- ")
}
