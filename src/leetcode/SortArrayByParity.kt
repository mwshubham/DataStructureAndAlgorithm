package leetcode

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431/
class SortArrayByParity {
    fun sortArrayByParity(A: IntArray): IntArray {
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