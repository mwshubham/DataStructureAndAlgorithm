import kotlin1.println
import kotlin.math.max

/**
 * https://leetcode.com/problems/jump-game/
 */
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
    }
}

fun main() {
    JumpGame.canJump(intArrayOf(2, 0, 0)).println()
}