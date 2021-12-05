package leetcode.problems.category.array.medium

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 * https://leetcode.com/submissions/detail/597190928/?from=explore&item_id=776
 */
class `3Sum` {

    /**
     * Runtime: 376 ms, faster than 87.58% of Kotlin online submissions for 3Sum.
     * Memory Usage: 48.4 MB, less than 70.70% of Kotlin online submissions for 3Sum.
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        nums.sort()

        var i = 0
        while (i <= nums.lastIndex) {
            val target = -nums[i]
            var front = i + 1
            var back = nums.lastIndex

            while (front < back) {
                val sum = nums[front] + nums[back]

                if (sum < target) {
                    front++
                } else if (sum > target) {
                    back--
                } else {
                    val triplet = ArrayList<Int>().apply {
                        add(nums[i])
                        add(nums[front])
                        add(nums[back])
                    }
                    res.add(triplet)
                    while (front < back && nums[front] == triplet[1]) front++
                    while (front < back && nums[back] == triplet[2]) back--
                }
            }

            while (i + 1 <= nums.lastIndex && nums[i] == nums[i + 1]) {
                i++
            }

            i++
        }
        return res
    }
}