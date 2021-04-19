package leetcode.problems.category.array.easy

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 */
class SortArrayByParity {

    /**
     * Runtime: 224 ms, faster than 80.18% of Kotlin online submissions for Sort Array By Parity.
     * Memory Usage: 39.2 MB, less than 36.04% of Kotlin online submissions for Sort Array By Parity.
     */
    fun sortArrayByParity(A: IntArray): IntArray {
        val output = IntArray(A.size)
        var start = 0
        var end = output.lastIndex
        A.forEach {
            if (it % 2 == 0) {
                output[start++] = it
            } else {
                output[end--] = it
            }
        }
        return output
    }

    /**
     * Runtime: 216 ms, faster than 93.69% of Kotlin online submissions for Sort Array By Parity.
     * Memory Usage: 36.3 MB, less than 99.10% of Kotlin online submissions for Sort Array By Parity.
     */
    fun sortArrayByParity2(A: IntArray): IntArray {
        var evenPos = 0
        A.forEachIndexed { index, value ->
            if (value % 2 == 0) {
                val temp = A[index]
                A[index] = A[evenPos]
                A[evenPos] = temp
                evenPos++
            }
        }
        return A
    }

}