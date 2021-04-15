package leetcode.challenge.april

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3709/
 * https://leetcode.com/problems/fibonacci-number/
 * 0 <= n <= 30
 */
class FibonacciNumber {

    companion object {
        /**
         * https://leetcode.com/submissions/detail/480908232/?from=explore&item_id=3709
         * Runtime: 144 ms, faster than 13.66% of Kotlin online submissions for Fibonacci Number.
         * Memory Usage: 32.4 MB, less than 95.15% of Kotlin online submissions for Fibonacci Number
         */
        fun fibUsingRecursion(n: Int): Int {
            if (n == 0) return 0
            if (n == 1) return 1
            return fibUsingRecursion(n - 1) + fibUsingRecursion(n - 2)
        }

        /**
         * Runtime: 108 ms, faster than 98.68% of Kotlin online submissions for Fibonacci Number.
         * Memory Usage: 32.6 MB, less than 59.47% of Kotlin online submissions for Fibonacci Number.
         */
        fun fibUsingIteration(n: Int): Int {
            var N = n
            if (n <= 1) return n
            var a = 0
            var b = 1
            var sum = 0
            while (N-- > 1) {
                sum = a + b
                a = b
                b = sum
            }
            return sum
        }
    }
}