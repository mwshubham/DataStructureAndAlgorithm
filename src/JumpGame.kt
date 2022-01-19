import kotlin1.println
import kotlin.math.max

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/807/
 * https://leetcode.com/submissions/detail/623216801/?from=explore&item_id=807
 */
//[2,3,1,1,4]
//[0,1]
//[0]
//[3, 2, 1, 0, 4]
class JumpGame {
    companion object {
        /**
         * Iterate and update the maximal index that you can reach
         *
         * Runtime: 204 ms, faster than 62.63% of Kotlin online submissions for Jump Game.
         * Memory Usage: 37.2 MB, less than 61.58% of Kotlin online submissions for Jump Game.
         */
        fun canJump(nums: IntArray): Boolean {
            var i = 0
            var reach = 0
            while (i <= nums.lastIndex && i <= reach) {
                reach = max(i + nums[i], reach)
                i++
            }
            return i == nums.size
        }

        fun canJump2(nums: IntArray): Boolean {
            if (nums.size == 1) return true
            var index = 0
            var reach = 0

            while (index in 0 until nums.lastIndex && index <= reach) {
                reach = max(reach, index + nums[index])
                if (reach >= nums.lastIndex) return true
                index++
            }

            return false
        }
    }
}

fun main() {
    JumpGame.canJump(intArrayOf(2, 0, 0)).println()
}