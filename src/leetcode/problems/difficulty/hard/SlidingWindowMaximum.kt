package leetcode.problems.difficulty.hard

import java.util.*

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 */
class SlidingWindowMaximum {
    companion object {
        /**
         * Runtime: 896 ms, faster than 72.46% of Kotlin online submissions for Sliding Window Maximum.
         * Memory Usage: 58.2 MB, less than 36.23% of Kotlin online submissions for Sliding Window Maximum.
         */
        fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
            if (nums.isEmpty() || k <= 0) return IntArray(0)
            val n = nums.size
            val result = IntArray(n - k + 1)
            var resultIndex = 0
            val dq = LinkedList<Int>()
            nums.forEachIndexed { index, num ->
                // remove numbers out of range k
                while (dq.isNotEmpty() && dq.peek() < index - k + 1) {
                    dq.removeFirst()
                }
                // remove smaller numbers in k range as they are useless
                while (dq.isNotEmpty() && nums[dq.peekLast()] < num) {
                    dq.removeLast()
                }
                dq.addLast(index)
                // q contains index... r contains content
                if (index >= k - 1) {
                    result[resultIndex++] = nums[dq.peek()]
                }
            }
            return result
        }
    }
}