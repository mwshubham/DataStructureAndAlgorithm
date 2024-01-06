package leetcode.problems.difficulty.medium

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/description/
 * https://leetcode.com/submissions/detail/1138268965/?from=explore&item_id=818
 */
class Pow {

    companion object {
        fun myPow(x: Double, n: Int): Double {
            val result = myPowHelper(x, n)
            return if (n < 0) 1 / result else result
        }

        private fun myPowHelper(x: Double, n: Int): Double {
            if (x == 0.0) return 0.0
            if (n == 0) return 1.0
            var res = myPowHelper(x, n / 2)
            res *= res
            return if (n % 2 == 0) res
            else res * x
        }
    }
}