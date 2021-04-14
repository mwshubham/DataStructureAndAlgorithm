package leetcode.problems.greedy.medium

import kotlin1.println

/**
 * https://leetcode.com/problems/jump-game-ii/submissions/
 */
//[2,3,1,1,4]
//[2,3,0,1,4]
//[1]
//[3, 2, 1]
//[1, 2, 3]
//[1, 1, 1, 1]
class JumpGame2 {
    companion object {
        /**
         * Runtime: 156 ms, faster than 55.42% of Kotlin online submissions for Jump Game II.
         * Memory Usage: 35.8 MB, less than 33.74% of Kotlin online submissions for Jump Game II.
         */
        fun jump(nums: IntArray): Int {
            var jumps = 0
            var currentFarthest = 0
            var currentEnd = 0
            for (i in 0 until nums.lastIndex) {
                currentFarthest = currentFarthest.coerceAtLeast(i + nums[i])
                if (i == currentEnd) {
                    jumps++
                    currentEnd = currentFarthest
                }
            }
            return jumps
        }
    }
}

fun main() {
    JumpGame2.jump(intArrayOf(1, 1, 1, 1)).apply {
        "${if (this == 3) "SUCCESS" else "FAILURE"} Output: $this Expected: 3".println()
    }
    JumpGame2.jump(intArrayOf(1, 2, 3)).apply {
        "${if (this == 2) "SUCCESS" else "FAILURE"} Output: $this Expected: 2".println()
    }
    JumpGame2.jump(intArrayOf(3, 2, 1)).apply {
        "${if (this == 1) "SUCCESS" else "FAILURE"} Output: $this Expected: 1".println()
    }
}