package leetcode.problems.category.array.easy

/**
 * 1051. Height Checker
 * https://leetcode.com/problems/height-checker/
 *
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3228/
 * https://leetcode.com/submissions/detail/485754427/?from=explore&item_id=3228
 */
class HeightChecker {
    companion object {

        /**
         * Count the frequency of each height (using HashMap or int[] as the height is promised to be within range[1, 100])
         * and use 2 pointers to make comparison:
         *
         * Runtime: 148 ms, faster than 92.42% of Kotlin online submissions for Height Checker.
         * Memory Usage: 33.8 MB, less than 95.45% of Kotlin online submissions for Height Checker.
         */
        fun heightChecker(heights: IntArray): Int {
            val heightToFreq = IntArray(101)

            for (height in heights) {
                heightToFreq[height]++
            }

            var result = 0
            var curHeight = 0

            for (height in heights) {
                while (heightToFreq[curHeight] == 0) {
                    curHeight++
                }
                if (curHeight != height) {
                    result++
                }
                heightToFreq[curHeight]--
            }

            return result
        }
    }
}