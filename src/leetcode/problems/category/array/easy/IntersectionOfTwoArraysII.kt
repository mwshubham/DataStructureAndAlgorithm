package leetcode.problems.category.array.easy

/**
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
class IntersectionOfTwoArraysII {

    companion object{
        /**
         * Runtime: 200 ms, faster than 74.82% of Kotlin online submissions for Intersection of Two Arrays II.
         * Memory Usage: 35.8 MB, less than 98.95% of Kotlin online submissions for Intersection of Two Arrays II.
         */
        fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
            val numCountMap1 = buildNumCountMap(nums1)
            val numCountMap2 = buildNumCountMap(nums2)
            val intersect: MutableList<Int> = mutableListOf()
            numCountMap1.forEach { (num, numCount) ->
                val commonCount = kotlin.math.min(numCount, numCountMap2.getOrDefault(num, 0))
                repeat(commonCount) {
                    intersect.add(num)
                }
            }
            return intersect.toIntArray()
        }

        private fun buildNumCountMap(nums: IntArray): Map<Int, Int> {
            val map: MutableMap<Int, Int> = mutableMapOf()
            nums.forEach {
                map[it] = map.getOrDefault(it, 0) + 1
            }
            return map
        }
    }
}