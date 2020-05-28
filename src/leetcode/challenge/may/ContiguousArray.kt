package leetcode.challenge.may

import java.util.*


class ContiguousArray {
    fun findMaxLength(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        var maxlen = 0
        var count = 0
        for (i in nums.indices) {
            count += if (nums[i] == 1) 1 else -1
            if (count == 0) maxlen = maxlen.coerceAtLeast(i + 1)
            if (map.containsKey(count)) {
                maxlen = maxlen.coerceAtLeast(i - map[count]!!)
            } else map[count] = i
        }
        return maxlen
    }
}

private val testCases = arrayOf(
    Pair(intArrayOf(0, 1), 2),
    Pair(intArrayOf(0, 1, 0), 2),
    Pair(intArrayOf(0, 0, 1, 1, 1, 0, 1, 0, 0, 1), 10),
    Pair(intArrayOf(0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0), 6),
    Pair(intArrayOf(0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0), 8),
    Pair(intArrayOf(1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0), 8),
    Pair(intArrayOf(0, 1, 1, 0, 1, 1, 1, 0), 4)
)

fun main() {
    val instance = ContiguousArray()
    for (testCase in testCases) {
        val calculatedAns = instance.findMaxLength(testCase.first)
        println("correctAns: ${testCase.second}")
        println("calculatedAns: $calculatedAns")
        println(testCase.second == calculatedAns)
    }
}