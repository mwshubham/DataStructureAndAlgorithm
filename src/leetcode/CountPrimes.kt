package leetcode

/**
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/
 * https://leetcode.com/submissions/detail/596807394/?from=explore&item_id=744
 */
class CountPrimes {

    /**
     * Runtime: 204 ms, faster than 100.00% of Kotlin online submissions for Count Primes.
     * Memory Usage: 40 MB, less than 71.11% of Kotlin online submissions for Count Primes.
     */
    fun countPrimes(n: Int): Int {
        if (n <= 1) return 0

        val isPrime = BooleanArray(n) { true }

        isPrime[0] = false
        isPrime[1] = false

        var i = 2
        while (i * i < n) {
            if (isPrime[i]) {
                var j = i * i
                while (j < n) {
                    isPrime[j] = false
                    j += i
                }
            }
            i++
        }
        return isPrime.count { it }
    }
}