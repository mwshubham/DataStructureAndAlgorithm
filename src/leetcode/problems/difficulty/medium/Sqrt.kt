package leetcode.problems.difficulty.medium

/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/description/
 * https://leetcode.com/submissions/detail/1138303979/?from=explore&item_id=819
 */
class Sqrt {

    companion object {
        fun mySqrt(x: Int): Int {
            if (x == 0 || x == 1) return x
            var start = 1
            var end = (x / 2) + 1
            var mid: Int
            while (start <= end) {
                mid = start + (end - start) / 2
                val midDouble = mid.toLong() * mid
                if (mid > x / mid) {
                    end = mid - 1
                } else if (midDouble == x.toLong()) {
                    return mid
                } else {
                    start = mid + 1
                }
            }
            return end
        }
    }
}