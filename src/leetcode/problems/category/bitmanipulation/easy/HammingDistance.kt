package leetcode.problems.category.bitmanipulation.easy

import kotlin1.println

/**
 * 461. Hamming Distance
 * https://leetcode.com/problems/hamming-distance/
 * https://leetcode.com/problems/hamming-distance/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/762/
 * https://leetcode.com/submissions/detail/597151607/?from=explore&item_id=762
 */
class HammingDistance {
    companion object {
        /**
         * Runtime: 112 ms, faster than 99.46% of Kotlin online submissions for Hamming Distance.
         * Memory Usage: 33.2 MB, less than 43.48% of Kotlin online submissions for Hamming Distance.
         */
        fun hammingDistance(x: Int, y: Int): Int {
            var x1 = x
            var y1 = y
            var res = 0
            while (x1 != 0 || y1 != 0) {
                if (x1 and 1 != y1 and 1) {
                    res++
                }
                x1 = x1 shr 1
                y1 = y1 shr 1
            }
            return res
        }
    }
}

fun main() {
    HammingDistance.hammingDistance(1, 4).println()
}