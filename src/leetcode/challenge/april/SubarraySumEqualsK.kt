package leetcode.challenge.april

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
class SubarraySumEqualsK {
    companion object {
        /**
         * Runtime: 840 ms, faster than 41.46% of Kotlin online submissions for Subarray Sum Equals K.
         * Memory Usage: 41.2 MB, less than 39.02% of Kotlin online submissions for Subarray Sum Equals K.
         */
        fun subarraySumUsingBruteForce(nums: IntArray, k: Int): Int {
            var counter = 0
            for (i in 0..nums.lastIndex) {
                var sum = 0
                for (j in i..nums.lastIndex) {
                    sum += nums[j]
                    if (sum == k) counter++
                }
            }
            return counter
        }

        /**
         *  sum[i, j] = sum[0, j] - sum[0, i - 1]
         *  sum[0, i - 1] = sum[0, j] - sum[i, j]
         *  k    =     sum   -  hashmap-key
         *  hashmap-key  =  sum - k
         *
         *  Runtime: 296 ms, faster than 85.37% of Kotlin online submissions for Subarray Sum Equals K.
         *  Memory Usage: 41.8 MB, less than 26.83% of Kotlin online submissions for Subarray Sum Equals K.
         */
        fun subarraySumUsingHashMapAndPrefixSum(nums: IntArray, k: Int): Int {
            var result = 0
            var sum = 0
            // Hashmap<sum[0,i - 1], frequency>
            val map = HashMap<Int, Int>()
            // since if difference is zero then number is present
            map[0] = 1
            for (num in nums) {
                sum += num
                if (map.containsKey(sum - k)) {
                    result += map[sum - k] ?: 0
                }
                map[sum] = map.getOrDefault(sum, 0) + 1
            }
            return result
        }

    }
}