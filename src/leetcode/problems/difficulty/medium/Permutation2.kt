package leetcode.problems.difficulty.medium

import java.util.ArrayList

/**
 * 47. Permutations II
 */
class Permutation2 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        val visited = BooleanArray(nums.size)
        backtrack(
            path = path,
            nums = nums.sortedArray(),
            visited = visited,
            result = result
        )
        return result
    }
    fun backtrack(path: MutableList<Int>, nums: IntArray, visited: BooleanArray, result: MutableList<List<Int>>) {
        if (path.size == nums.size) {
            result.add(ArrayList(path))
            return
        }
        for (i in nums.indices) {
            if (visited[i]) continue
            if (i > 0 && nums[i] == nums[i-1] && !visited[i - 1]) continue
            visited[i] = true
            path.add(nums[i])
            backtrack(
                path = path,
                nums = nums,
                visited = visited,
                result = result
            )
            path.removeAt(path.lastIndex)
            visited[i] = false
        }
    }
}