package leetcode.problems.category.array.easy

/**
 * 412. Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/743/
 * https://leetcode.com/submissions/detail/596796346/?from=explore&item_id=743
 */
class FizzBuzz {

    companion object {
        /**
         * Runtime: 168 ms, faster than 90.30% of Kotlin online submissions for Fizz Buzz.
         * Memory Usage: 36.5 MB, less than 71.52% of Kotlin online submissions for Fizz Buzz.
         */
        fun fizzBuzz(n: Int): List<String> {
            var n15 = 0
            var n5 = 0
            var n3 = 0

            val items = ArrayList<String>()
            for (i in 1..n) {
                n15++
                n5++
                n3++
                if (n15 == 15) {
                    items.add("FizzBuzz")
                    n15 = 0
                    n5 = 0
                    n3 = 0
                } else if (n3 == 3) {
                    items.add("Fizz")
                    n3 = 0
                } else if (n5 == 5) {
                    items.add("Buzz")
                    n5 = 0
                } else {
                    items.add(i.toString())
                }
            }
            return items
        }
    }
}