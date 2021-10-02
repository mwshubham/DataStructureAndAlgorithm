package leetcode.problems.category.array.easy

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 */
class PlusOne {
    companion object{
        /**
         * Runtime: 176 ms, faster than 59.76% of Kotlin online submissions for Plus One.
         * Memory Usage: 36.7 MB, less than 22.93% of Kotlin online submissions for Plus One.
         */
        fun plusOne(digits: IntArray): IntArray {
            var carry = 1
            for (i in digits.lastIndex downTo 0){
                if (carry == 0) break
                if (digits[i] == 9){
                    digits[i] = 0
                    carry = 1
                } else {
                    digits[i] += 1
                    carry = 0
                }
            }
            return if (carry == 0) digits
            else IntArray(digits.size + 1).apply {
                set(0, 1)
                for (i in digits.indices){
                    set(i + 1, digits[i])
                }
            }
        }
    }
}