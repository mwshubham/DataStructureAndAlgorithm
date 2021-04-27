package leetcode.problems.category.array.easy

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/
 *
 * https://leetcode.com/submissions/detail/485751751/?from=explore&item_id=3157
 */
class MoveZeroes {
    companion object {
        /**
         * Shift non-zero values as far forward as possible
         * Fill remaining space with zeros
         *
         * Runtime: 184 ms, faster than 86.75% of Kotlin online submissions for Move Zeroes.
         * Memory Usage: 38.2 MB, less than 35.54% of Kotlin online submissions for Move Zeroes.
         */
        fun moveZeroes(nums: IntArray) {
            if (nums.isEmpty()) return
            var insertPos = 0
            for (num in nums) {
                if (num != 0) nums[insertPos++] = num
            }
            while (insertPos < nums.size) {
                nums[insertPos++] = 0
            }
        }
    }
}