package leetcode.problems.category.array.medium

import kotlin.random.Random

/**
 * 384. Shuffle an Array
 * https://leetcode.com/problems/shuffle-an-array/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/670/
 * https://leetcode.com/submissions/detail/596793287/?from=explore&item_id=670
 *
 * Runtime: 500 ms, faster than 90.00% of Kotlin online submissions for Shuffle an Array.
 * Memory Usage: 61.2 MB, less than 73.33% of Kotlin online submissions for Shuffle an Array.
 */
class ShuffleAnArray(nums: IntArray) {

    val a = nums

    fun reset(): IntArray {
        return a
    }

    fun shuffle(): IntArray {
        val out = a.copyOf()
        out.forEachIndexed { index, i ->
            swap(out, index, Random.nextInt(a.size))
        }
        return out
    }

    fun swap(arr: IntArray, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }
}