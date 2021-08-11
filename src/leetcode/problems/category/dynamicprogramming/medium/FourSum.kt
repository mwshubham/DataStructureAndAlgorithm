package leetcode.problems.category.dynamicprogramming.medium

import kotlin1.println

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/
 */
class FourSum {

    companion object {

        /**
         * Set will take care of the distict nums.
         *
         * Problem: Time Limit Exceeded
         * [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2]
         * 8
         */
        fun fourSumUsingSimpleSet(nums: IntArray, target: Int): List<List<Int>> {
            val n = nums.size
            val ans = hashSetOf<ArrayList<Int>>()

            // In-place algo
            nums.sort()

            var sum: Int
            for (i in 0 until n - 3) {
                for (j in i + 1 until n - 2) {
                    for (k in j + 1 until n - 1) {
                        for (l in k + 1 until n) {
                            sum = nums[i] + nums[j] + nums[k] + nums[l]
                            if (sum > target) {
                                break
                            } else if (sum == target) {
                                ans.add(
                                    ArrayList<Int>().apply {
                                        add(nums[i])
                                        add(nums[j])
                                        add(nums[k])
                                        add(nums[l])
                                    }
                                )
                            }
                        }
                    }
                }
            }
            return ans.map { it }
        }

        /**
         * Runtime: 780 ms, faster than 24.12% of Kotlin online submissions for 4Sum.
         * Memory Usage: 42.9 MB, less than 45.73% of Kotlin online submissions for 4Sum.
         */
        fun fourSumUsingSimpleSetWithSkippingAdjacentOptimisation(nums: IntArray, target: Int): List<List<Int>> {
            val n = nums.size
            val ans = hashSetOf<ArrayList<Int>>()

            // In-place algo
            nums.sort()

            var sum: Int
            for (i in 0 until n - 3) {
                if (i > 0 && nums[i] == nums[i - 1]) continue
                for (j in i + 1 until n - 2) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue
                    for (k in j + 1 until n - 1) {
                        if (k > j + 1 && nums[k] == nums[k - 1]) continue
                        for (l in k + 1 until n) {
                            if (l > k + 1 && nums[l] == nums[l - 1]) continue
                            sum = nums[i] + nums[j] + nums[k] + nums[l]
                            if (sum > target) {
                                break
                            } else if (sum == target) {
                                ans.add(
                                    ArrayList<Int>().apply {
                                        add(nums[i])
                                        add(nums[j])
                                        add(nums[k])
                                        add(nums[l])
                                    }
                                )
                            }
                        }
                    }
                }
            }
            return ans.map { it }
        }

        /**
         * Runtime: 304 ms, faster than 64.82% of Kotlin online submissions for 4Sum.
         * Memory Usage: 40.8 MB, less than 50.75% of Kotlin online submissions for 4Sum.
         */
        fun fourSumUsingTwoPointers(nums: IntArray, target: Int): List<List<Int>> {
            val n = nums.size
            val ans = hashSetOf<ArrayList<Int>>()

            // In-place algo
            nums.sort()
            var sum: Int
            for (i in 0 until n - 3) {
                if (i > 0 && nums[i] == nums[i - 1]) continue
                for (j in i + 1 until n - 2) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue
                    var left = j + 1
                    var right = n - 1

                    while (left < right) {
                        sum = nums[i] + nums[j] + nums[left] + nums[right]
                        if (sum > target) {
                            right--
                        } else if (sum == target) {
                            ans.add(
                                ArrayList<Int>().apply {
                                    add(nums[i])
                                    add(nums[j])
                                    add(nums[left])
                                    add(nums[right])
                                }
                            )
                            left++
                        } else {
                            left++
                        }
                    }
                }
            }
            return ans.map { it }
        }

        /**
         * Runtime: 320 ms, faster than 56.28% of Kotlin online submissions for 4Sum.
         * Memory Usage: 43.5 MB, less than 44.22% of Kotlin online submissions for 4Sum.
         */
        fun fourSumUsingUsingHashMap(nums: IntArray, target: Int): List<List<Int>> {
            val n = nums.size
            val ans = ArrayList<ArrayList<Int>>()

            if (n < 4) return ans

            val map = HashMap<Int, ArrayList<Pair<Int, Int>>>()

            // In-place algo
            nums.sort()

            for (i in 0 until n - 1) {
                for (j in i + 1 until n) {
                    val sum = nums[i] + nums[j]
                    val pair = Pair(i, j)
                    map[sum]?.add(pair) ?: map.put(
                      sum, ArrayList<Pair<Int, Int>>().apply { add(pair) }
                    )
                }
            }

            for (i in 0 until n - 1) {
                if (i > 0 && nums[i] == nums[i - 1]) continue
                for (j in i + 1 until n) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue
                    val sum = target - nums[i] - nums[j]
                    map[sum]?.forEach { pair ->
                        val k = pair.first
                        val l = pair.second

                        // for maintaining order i < j < k < l
                        if (k > j) {
                            if (ans.isNotEmpty()
                                && ans.last()[0] == nums[i]
                                && ans.last()[1] == nums[j]
                                && ans.last()[2] == nums[k]
                                && ans.last()[3] == nums[l]
                            ) {
                                // Do Nothing
                            } else {
                                ans.add(
                                    ArrayList<Int>().apply {
                                        add(nums[i])
                                        add(nums[j])
                                        add(nums[k])
                                        add(nums[l])
                                    }
                                )
                            }
                        }

                    }
                }
            }
            return ans.map { it }
        }
    }
}

fun main(){
    FourSum.fourSumUsingUsingHashMap(intArrayOf(1,0,-1,0,-2,2), 0).println()
}