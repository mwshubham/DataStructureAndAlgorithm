package leetcode.problems.difficulty.medium

import java.util.*

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/796/
 * https://leetcode.com/submissions/detail/603526853/?from=explore&item_id=796
 */
class Subsets {
    /**
     * Runtime: 168 ms, faster than 93.53% of Kotlin online submissions for Subsets.
     * Memory Usage: 35.7 MB, less than 93.53% of Kotlin online submissions for Subsets.
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        val res = LinkedList<LinkedList<Int>>()
        res.add(LinkedList())
        nums.forEach { num ->
            res.add(
                LinkedList<Int>().apply {
                    add(num)
                }
            )
        }
        var index = 1
        while (res.last().size != nums.size) {
            val firstArr = res[index++]
            var addNow = false
            nums.forEach { num ->
                if (addNow) {
                    res.addLast(
                        LinkedList<Int>().apply {
                            addAll(firstArr)
                            add(num)
                        }
                    )
                }
                addNow = firstArr.last() == num || addNow
            }
        }
        return res
    }


    fun subsets2(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        val visited = BooleanArray(nums.size)
        backtrack(
            path = path,
            nums = nums,
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
            visited[i] = true
            path.add(nums[i])
            backtrack(
                path = path,
                nums = nums,
                visited = visited,
                result = result,
                start = i
            )
            path.removeAt(path.lastIndex)
            visited[i] = false
        }
    }
}