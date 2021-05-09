package leetcode.problems.category.bitmanipulation.easy

/**
 * 476. Number Complement
 * https://leetcode.com/problems/number-complement/
 *
 * 1009. Complement of Base 10 Integer
 * https://leetcode.com/problems/complement-of-base-10-integer/
 */
class NumberComplement {
    companion object {
        /**
         * Runtime: 132 ms, faster than 66.67% of Kotlin online submissions for Number Complement.
         * Memory Usage: 32.5 MB, less than 83.33% of Kotlin online submissions for Number Complement.
         */
        fun findComplement(num: Int): Int {
            var num = num
            if (num == 0) return 1
            var out = 0
            var mask = 1

            while (num != 0) {
                if (num % 2 == 0) {
                    out = out or mask
                }
                num = num shr 1
                mask = mask shl 1
            }
            return out
        }
    }
}