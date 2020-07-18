package sorting

// https://www.geeksforgeeks.org/radix-sort/
class RadixSort {
    fun sort(nums: IntArray) {
        val max = nums.max()!!
        var exp = 1
        while (max / exp > 0) {
            countSort(nums, exp)
            exp *= 10
        }
    }

    private fun countSort(nums: IntArray, exp: Int) {
        println("nums: ${nums.asList()}")
        val output = IntArray(nums.size)
        val count = IntArray(10) { 0 }
        println("count: ${count.asList()}")
        nums.forEach {
            count[(it / exp) % 10]++
        }
        println("count: ${count.asList()}")
        (1 until 10).forEach {
            count[it] += count[it - 1]
        }
        println("count: ${count.asList()}")
        for (index in nums.lastIndex downTo 0 step 1) {
            output[count[(nums[index] / exp) % 10] - 1] = nums[index]
            count[(nums[index] / exp) % 10]--
        }
        output.copyInto(nums)
        println("output: ${output.asList()}")
        println("nums: ${nums.asList()}")
    }
}

fun main() {
    val nums = intArrayOf(170, 45, 75, 90, 802, 24, 2, 60)
    RadixSort().sort(nums)
    println(nums.asList())
}