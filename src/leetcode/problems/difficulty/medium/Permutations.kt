package leetcode.problems.difficulty.medium

import java.util.*

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/
 * https://leetcode.com/submissions/detail/603522507/?from=explore&item_id=795
 */
class Permutations {

    companion object {
        /**
         * Runtime: 200 ms, faster than 85.38% of Kotlin online submissions for Permutations.
         * Memory Usage: 36.2 MB, less than 97.23% of Kotlin online submissions for Permutations.
         */
        fun permute(nums: IntArray): List<List<Int>> {
            val res = LinkedList<LinkedList<Int>>()
            nums.forEach { num ->
                res.add(
                    LinkedList<Int>().apply {
                        add(num)
                    }
                )
            }
            while (res.peek().size != nums.size) {
                val firstArr = res.removeFirst()
                nums.forEach { num ->
                    if (!firstArr.contains(num)) {
                        res.addLast(
                            LinkedList<Int>().apply {
                                addAll(firstArr)
                                add(num)
                            }
                        )
                    }
                }
            }
            return res
        }
    }

    // 1,2,3
    // 1 = 1
    // 2 = 2
    // 3 = 6
    // 4 = 24
    // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        val used = BooleanArray(nums.size)

        fun backtrack() {
            if (path.size == nums.size) {
                result.add(ArrayList(path))
                return
            }
            for (i in nums.indices) {
                if (used[i]) continue
                used[i] = true
                path.add(nums[i])
                backtrack()
                path.removeAt(path.lastIndex)
                used[i] = false
            }
        }
        backtrack()
        return result
    }

    fun permute2(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        val visited = BooleanArray(nums.size)
        backtrack(
            path = path,
            nums = nums,
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

fun main() {
    Permutations().permute(intArrayOf(1, 2, 3))
}