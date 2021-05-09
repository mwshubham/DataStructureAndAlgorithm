package leetcode.problems.category.bitmanipulation.medium

/**
 * 201. Bitwise AND of Numbers Range
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */
class BitwiseANDOfNumbersRange {

    companion object {

        /**
         * Runtime: 188 ms, faster than 100.00% of Kotlin online submissions for Bitwise AND of Numbers Range.
         * Memory Usage: 34.8 MB, less than 66.67% of Kotlin online submissions for Bitwise AND of Numbers Range.
         */
        fun rangeBitwiseAnd(left: Int, right: Int): Int {
            if (left == 0) return 0
            var left = left
            var right = right
            var mask = 1
            while (left != right) {
                left = left shr 1
                right = right shr 1
                mask = mask shl 1
            }
            return left * mask
        }
    }
}