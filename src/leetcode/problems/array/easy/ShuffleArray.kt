package leetcode.problems.array.easy

// https://leetcode.com/problems/shuffle-the-array
private class ShuffleArray {

    fun shuffle(nums: IntArray, n: Int): IntArray {
        val output = IntArray(nums.size)
        (0 until n).forEach {
            output[it * 2] = nums[it]
            output[it * 2 + 1] = nums[n + it]
        }
        return output
    }
}

private fun main() {
    val instance = ShuffleArray()
    println(instance.shuffle(intArrayOf(2, 5, 1, 3, 4, 7), 3).asList()) // [2,3,5,4,1,7]
    println(instance.shuffle(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1), 4).asList()) //  [1,4,2,3,3,2,4,1]
}