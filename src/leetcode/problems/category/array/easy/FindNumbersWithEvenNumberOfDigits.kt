package leetcode.problems.category.array.easy

/**
 * 1295. Find Numbers with Even Number of Digits
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
 *
 * https://leetcode.com/submissions/detail/484463436/?from=explore&item_id=3237
 */
class FindNumbersWithEvenNumberOfDigits {
    companion object {
        /**
         * Runtime: 180 ms, faster than 82.43% of Kotlin online submissions for Find Numbers with Even Number of Digits.
         * Memory Usage: 35.9 MB, less than 10.81% of Kotlin online submissions for Find Numbers with Even Number of Digits.
         */
        fun findNumbers(nums: IntArray): Int {
            var count = 0
            nums.forEach {
                if (it.toString().length % 2 == 0) count++
            }
            return count
        }


        /**
         * Runtime: 196 ms, faster than 38.74% of Kotlin online submissions for Find Numbers with Even Number of Digits.
         * Memory Usage: 35.2 MB, less than 10.81% of Kotlin online submissions for Find Numbers with Even Number of Digits.
         */
        fun findNumbers2(nums: IntArray): Int {
            var count = 0
            nums.forEach {
                if ((it in 10..99) || (it in 1000..9999) || it == 100000) {
                    count++
                }
            }
            return count
        }
    }
}