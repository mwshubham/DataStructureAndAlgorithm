package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println

/**
 * 698. Partition to K Equal Subset Sum
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets
 */
class PartitionToKEqualSubsetSum {
    companion object {
        fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
            val sum = nums.sum()
            if (sum % k != 0) return false
            val target = sum / k
            nums.sort()
            if (nums.last() > target) return false
            val visited = BooleanArray(nums.size)
            return backtrack(
                nums = nums,
                visited = visited,
                startIndex = 0,
                currentSum = 0,
                target = target,
                k = k
            )
        }

        fun backtrack(
            nums: IntArray,
            visited: BooleanArray,
            startIndex: Int,
            currentSum: Int,
            target: Int,
            k: Int
        ): Boolean {
            if (k == 1) return true

            // If the current bucket is full, move on to building the next bucket (k - 1)
            if (currentSum == target) {
                return backtrack(
                    nums = nums,
                    visited = visited,
                    startIndex = 0,
                    currentSum = 0,
                    target = target,
                    k = k - 1
                )
            }

            for (i in startIndex until nums.size) {
                // Skip if the element is already used in another subset, or if it exceeds target
                if (visited[i] || currentSum + nums[i] > target) continue

                // Mark element as used
                visited[i] = true

                // Recurse to keep filling the current bucket
                if (backtrack(
                        nums = nums,
                        visited = visited,
                        startIndex = i + 1,
                        currentSum = currentSum + nums[i],
                        target = target,
                        k = k
                    )
                ) {
                    return true
                }

                // Backtrack: Mark element as unused if this path didn't work out
                visited[i] = false
            }

            return false
        }
    }

    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {

        val total = nums.sum()
        if (total % k != 0) return false
        val target = total / k
        nums.sortDescending()
        val buckets = IntArray(k)

        fun dfs(index: Int): Boolean {
            if (index > nums.lastIndex) return true
            for (i in 0 until k) {
                if (buckets[i] + nums[index] > target) continue

                if (i > 0 && buckets[i] == buckets[i - 1]) continue

                buckets[i] += nums[index]
                if (dfs(index + 1)) return true
                buckets[i] -= nums[index]
            }
            return false
        }

        return dfs(0)
    }
}

fun main() {
//    PartitionToKEqualSubsetSum().canPartitionKSubsets(intArrayOf(4,3,2,3,5,2,1), 4).println()
    // Undo operation
    PartitionToKEqualSubsetSum().canPartitionKSubsets(intArrayOf(4,3,3,2,2,2), 2).println()
}