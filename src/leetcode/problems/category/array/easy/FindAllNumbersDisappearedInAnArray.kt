package leetcode.problems.category.array.easy

import java.util.*


/**
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3270/
 * https://leetcode.com/submissions/detail/485773655/?from=explore&item_id=3270
 */
class FindAllNumbersDisappearedInAnArray {
    companion object {
        /**
         * Runtime: 360 ms, faster than 93.28% of Kotlin online submissions for Find All Numbers Disappeared in an Array.
         * Memory Usage: 46.3 MB, less than 64.71% of Kotlin online submissions for Find All Numbers Disappeared in an Array.
         */
        fun findDisappearedNumbers(nums: IntArray): List<Int> {
            for (i in nums.indices) {
                while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                    val tmp = nums[i]
                    nums[i] = nums[tmp - 1]
                    nums[tmp - 1] = tmp
                }
            }
            val res: MutableList<Int> = ArrayList()
            for (i in nums.indices) {
                if (nums[i] != i + 1) {
                    res.add(i + 1)
                }
            }
            return res
        }
    }
}


fun main() {
    FindAllNumbersDisappearedInAnArray.findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))
}