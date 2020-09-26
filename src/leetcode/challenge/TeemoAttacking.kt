package leetcode.challenge

/**
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3473/
 * https://leetcode.com/submissions/detail/400864405/?from=/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3473/
 */
class TeemoAttacking {
    /**
     * Runtime: 268 ms, faster than 33.33% of Kotlin online submissions for Teemo Attacking.
     * Memory Usage: 36.6 MB, less than 33.33% of Kotlin online submissions for Teemo Attacking.
     */
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        var output = 0
        var maxTimeShaded = 0
        timeSeries.forEach {
            output += if (it >= maxTimeShaded) {
                duration
            } else {
                duration - (maxTimeShaded - it)
            }
            maxTimeShaded = it + duration
        }
        return output
    }
}