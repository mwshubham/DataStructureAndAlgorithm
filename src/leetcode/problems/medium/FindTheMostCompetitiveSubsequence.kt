package leetcode.problems.medium

import java.util.*


/**
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/
 *
 * Runtime: 852 ms, faster than 52.38% of Kotlin online submissions for Find the Most Competitive Subsequence.
 * Memory Usage: 56.4 MB, less than 88.10% of Kotlin online submissions for Find the Most Competitive Subsequence.
 */
object FindTheMostCompetitiveSubsequence {

    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val stack = Stack<Int>()
        for (i in nums.indices) {
            while (!stack.empty() && nums[i] < nums[stack.peek()] && nums.size - i + stack.size > k) {
                stack.pop()
            }
            if (stack.size < k) {
                stack.push(i)
            }
        }
        val output = IntArray(k)
        for (i in k - 1 downTo 0) {
            output[i] = nums[stack.pop()]
        }
        return output
    }

}


fun main() {
//    FindTheMostCompetitiveSubsequence
//        .mostCompetitive(intArrayOf(3, 5, 2, 6), 2)
//        .apply {
//            println(this.asList())
//        }
    FindTheMostCompetitiveSubsequence
        .mostCompetitive(intArrayOf(2, 4, 3, 3, 5, 9, 6), 4)
        .apply {
            println(this.asList())
        }

//    FindTheMostCompetitiveSubsequence
//        .mostCompetitive(intArrayOf(71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2), 3)
//        .apply {
//            // [8,80,2]
//            println(this.asList())
//        }
}