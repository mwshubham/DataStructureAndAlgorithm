package leetcode.challenge.april

/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/
 *
 * https://leetcode.com/explore/featured/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3722/
 * https://leetcode.com/submissions/detail/485817720/?from=explore&item_id=3722
 */
class PowerOfThree {
    companion object {
        /**
         * Runtime: 240 ms, faster than 53.45% of Kotlin online submissions for Power of Three.
         * Memory Usage: 35.3 MB, less than 96.55% of Kotlin online submissions for Power of Three.
         */
        fun isPowerOfThree(n: Int): Boolean {
            return n > 0 && 1162261467 % n == 0
        }
    }
}