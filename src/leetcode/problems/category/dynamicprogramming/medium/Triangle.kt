package leetcode.problems.category.dynamicprogramming.medium

/**
 * 120. Triangle
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3715/
 * https://leetcode.com/problems/triangle/
 */
class Triangle {
    companion object {

        /**
         * Recursion Solution Without DP causing TLE
         */
//        fun minimumTotal(triangle: List<List<Int>>): Int {
//            return minimumTotal(triangle, 0, 0)
//        }
//
//        private fun minimumTotal(triangle: List<List<Int>>, index: Int, height: Int): Int {
//            if (height > triangle.lastIndex) return 0
//            if (index > triangle[height].lastIndex) return 0
//            return min(
//                triangle[height][index] + minimumTotal(triangle, index, height + 1),
//                triangle[height][index] + minimumTotal(triangle, index + 1, height + 1)
//            )
//        }

        /**
         * Runtime: 168 ms, faster than 89.19% of Kotlin online submissions for Triangle.
         * Memory Usage: 36.1 MB, less than 59.46% of Kotlin online submissions for Triangle.
         */
        fun minimumTotal(triangle: List<List<Int>>): Int {
            val A = IntArray(triangle.size + 1)
            for (i in triangle.size - 1 downTo 0) {
                for (j in triangle[i].indices) {
                    A[j] = A[j].coerceAtMost(A[j + 1]) + triangle[i][j]
                }
            }
            return A[0]
        }
    }
}