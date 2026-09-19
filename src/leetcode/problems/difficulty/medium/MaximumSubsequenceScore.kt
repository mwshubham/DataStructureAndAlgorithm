package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.PriorityQueue

/**
 * 2542. Maximum Subsequence Score
 * https://leetcode.com/problems/maximum-subsequence-score/?envType=study-plan-v2&envId=leetcode-75
 */
class MaximumSubsequenceScore {


    fun maxScore2(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val n = nums1.size
        if (k == n) {
            return nums1.sumOf { it.toLong() } * nums2.min()
        }
        val indices = nums1.indices.sortedByDescending { nums2[it] }
        val nums1Sorted = IntArray(nums1.size) { nums1[indices[it]] }
        val nums2Sorted = IntArray(nums2.size) { nums2[indices[it]] }

        val minHeap = PriorityQueue<Int>()
        var sum = 0L
        var answer = 0L

        repeat(nums2Sorted.size) {
            val num1 = nums1Sorted[it]
            val num2 = nums2Sorted[it]
            minHeap.offer(num1)
            sum += num1

            if (minHeap.size > k) {
                sum -= minHeap.poll()
            }

            if (minHeap.size == k) {
                answer = maxOf(answer, sum * num2)
            }
        }

        return answer
    }

    private var maxScore = 0L

    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val n = nums1.size
        if (k == n) {
            return nums1.sumOf { it.toLong() } * nums2.min()
        }
        dfs(
            nums1,
            nums2,
            k,
            0,
            0,
            0,
            Int.MAX_VALUE
        )
        return maxScore
    }

    fun dfs(
        nums1: IntArray,
        nums2: IntArray,
        k: Int,
        index: Int,
        count: Int,
        sum: Long,
        min: Int,
    ) {
        if (count == k) {
            maxScore = maxOf(maxScore, sum * min)
            return
        }

        if (index == nums1.size) return

        // Skip
        dfs(
            nums1,
            nums2,
            k,
            index + 1,
            count,
            sum,
            min
        )

        // Pick
        dfs(
            nums1,
            nums2,
            k,
            index + 1,
            count + 1,
            sum + nums1[index],
            minOf(min, nums2[index])
        )
    }
}

fun main() {
    MaximumSubsequenceScore().apply {
        maxScore2(intArrayOf(1, 3, 3, 2), intArrayOf(2, 1, 3, 4), 3).println()
//        maxScore(intArrayOf(4,2,3,1,1), intArrayOf(7,5,10,9,6), 1).println()
    }
}
