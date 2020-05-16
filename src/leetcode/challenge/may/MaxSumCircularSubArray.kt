@file:Suppress("SpellCheckingInspection")

package leetcode.challenge.may

@Suppress("LocalVariableName")
class MaxSumCircularSubArray {


    fun maxSubarraySumCircular(A: IntArray): Int {
        val N: Int = A.size

        var ans = A[0]
        var current_max = A[0]
        for (i in 1 until N) {
            current_max = A[i] + current_max.coerceAtLeast(0)
            ans = ans.coerceAtLeast(current_max)
        }

        val rightsums = IntArray(N)
        rightsums[N - 1] = A[N - 1]
        for (i in N - 2 downTo 0) rightsums[i] = rightsums[i + 1] + A[i]

        val maxright = IntArray(N)
        maxright[N - 1] = A[N - 1]
        for (i in N - 2 downTo 0) maxright[i] = maxright[i + 1].coerceAtLeast(rightsums[i])

        var leftsum = 0
        for (i in 0 until N - 2) {
            leftsum += A[i]
            ans = ans.coerceAtLeast(leftsum + maxright[i + 2])
        }
        return ans
    }
}

fun main() {
    val instance = MaxSumCircularSubArray()
//    println(instance.maxSubarraySumCircular(intArrayOf(1, 2, 3, 4, 5))) // 15
//    println(instance.maxSubarraySumCircular(intArrayOf(1, -2, 3, -2))) // 3
//    println(instance.maxSubarraySumCircular(intArrayOf(5, -3, 5))) // 10
//    println(instance.maxSubarraySumCircular(intArrayOf(3, -1, 2, -1))) // 4
//    println(instance.maxSubarraySumCircular(intArrayOf(3, -2, 2, -3))) // 3
    println(instance.maxSubarraySumCircular(intArrayOf(-2, -3, -1))) // -1
//    println(instance.maxSubarraySumCircular(intArrayOf(-2, 4, 4, 4, 6))) // 18
//    println(instance.maxSubarraySumCircular(intArrayOf(2, -2, 2, 7, 8, 0))) // 19
}