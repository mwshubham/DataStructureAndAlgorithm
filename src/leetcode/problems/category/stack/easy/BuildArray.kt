package leetcode.problems.category.stack.easy

import java.util.*

/**
 * https://leetcode.com/problems/build-an-array-with-stack-operations/
 */
class BuildArray {

    /**
     * Using simple array check
     * Runtime: 164 ms, faster than 90.00% of Kotlin online submissions for Build an Array With Stack Operations.
     * Memory Usage: 34.8 MB, less than 60.00% of Kotlin online submissions for Build an Array With Stack Operations.
     */
    fun buildArrayUsingArray(target: IntArray, @Suppress("UNUSED_PARAMETER") n: Int): List<String> {
        val result = LinkedList<String>()
        var j = 0
        var i = 1
        while (j < target.size) {
            result.add("Push")
            if (target[j] == i) {
                j++
            } else {
                result.add("Pop")
            }
            i++
        }
        return result
    }


    /**
     * Runtime: 180 ms, faster than 80.00% of Kotlin online submissions for Build an Array With Stack Operations.
     * Memory Usage: 35.7 MB, less than 30.00% of Kotlin online submissions for Build an Array With Stack Operations.
     */
    fun buildArray(target: IntArray, @Suppress("UNUSED_PARAMETER") n: Int): List<String> {
        var item = 1
        var index = 0
        val output = LinkedList<String>()


        val stack = ArrayDeque<Int>()
        while (index <= target.lastIndex) {
            stack.push(item)
            output.add("Push")
            if (stack.peek() == target[index]) {
                index++
            } else {
                output.add("Pop")
            }
            item++
        }
        return output
    }


}