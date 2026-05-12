package leetcode.problems.difficulty.medium

import java.util.*

/**
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/
 */
class Subsets2 {

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        val visited = BooleanArray(nums.size)
        backtrack(
            path = path,
            nums = nums.sortedArray(),
            visited = visited,
            result = result,
            start = 0
        )
        return result
    }

    fun backtrack(
        path: MutableList<Int>,
        nums: IntArray,
        visited: BooleanArray,
        result: MutableList<List<Int>>,
        start: Int
    ) {
        result.add(ArrayList(path))
        for (i in start until nums.size) {
            if (visited[i]) continue
            if (i > start && nums[i] == nums[i - 1]) continue
            visited[i] = true
            path.add(nums[i])
            backtrack(
                path = path,
                nums = nums,
                visited = visited,
                result = result,
                start = i + 1
            )
            path.removeAt(path.lastIndex)
            visited[i] = false
        }
    }
}