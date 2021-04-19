package leetcode.problems.difficulty

import java.util.*


class NumberOfGoodPairs {
    /**
     * Runtime: 140 ms, faster than 90.71% of Kotlin online submissions for Number of Good Pairs.
     * Memory Usage: 32.8 MB, less than 35.00% of Kotlin online submissions for Number of Good Pairs.
     */
    fun numIdenticalPairs(nums: IntArray): Int {
        var res = 0
        val count = IntArray(101)
        for (a in nums) {
            res += count[a]++
        }
        return res
    }


    /**
     * Runtime: 124 ms, faster than 100.00% of Kotlin online submissions for Number of Good Pairs.
     * Memory Usage: 32.6 MB, less than 42.14% of Kotlin online submissions for Number of Good Pairs.
     */
    fun numIdenticalPairs2(nums: IntArray): Int {
        val cnt = IntArray(101)
        var res = 0
        for (n in nums) ++cnt[n]
        for (i in 0..100) res += cnt[i] * (cnt[i] - 1) / 2
        return res
    }

    /**
     * Runtime: 140 ms, faster than 90.71% of Kotlin online submissions for Number of Good Pairs.
     * Memory Usage: 32.9 MB, less than 31.43% of Kotlin online submissions for Number of Good Pairs.
     */
    fun numIdenticalPairsHasMap(nums: IntArray): Int {
        var res = 0
        val map = HashMap<Int, Int>()
        for (n in nums) {
            map[n] = map.getOrDefault(n, 0) + 1
            res += map[n]!! - 1 // additional pair can be formed btw n and all previous v == n;
        }
        return res
    }
}