package leetcode.problems.array

// https://leetcode.com/problems/two-sum/
private class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, value ->
            val complement = target - value
            if (map.contains(complement) && map[complement] != index) {
                return intArrayOf(index, map[complement]!!)
            }
            map[value] = index
        }
        throw  IllegalArgumentException("No two sum solution")
    }
}

private fun main(){
    val instance = TwoSum()
    println(instance.twoSum(intArrayOf(2, 7,11, 15), 9).asList()) // [1, 0]
    println(instance.twoSum(intArrayOf(-2, 7,11, 15), 9).asList()) // [2, 0]
    println(instance.twoSum(intArrayOf(3,3), 6).asList()) // [1, 0]
}