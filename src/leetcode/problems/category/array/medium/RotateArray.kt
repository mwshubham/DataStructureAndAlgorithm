package leetcode.problems.category.array.medium

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 */

//[1,2,3,4,5,6,7]
//3
//[-1,-100,3,99]
//2
//[-1]
//2
//[1,2]
//3
class RotateArray {

    companion object{
        /**
         * Runtime: 344 ms, faster than 75.00% of Kotlin online submissions for Rotate Array.
         * Memory Usage: 51.7 MB, less than 47.78% of Kotlin online submissions for Rotate Array.
         */
        fun rotate(nums: IntArray, k: Int): Unit {
            var k = k
            if (k > nums.size) k %= nums.size
            val out = IntArray(nums.size)
            repeat(nums.size - k){
                out[it + k] = nums[it]
            }
            repeat(k){
                out[it] = nums[nums.size - k + it]
            }
            out.forEachIndexed { index, i -> nums[index] = i }
        }

        /**
         * Without any extra space
         *
         * Runtime: 348 ms, faster than 68.99% of Kotlin online submissions for Rotate Array.
         * Memory Usage: 50.6 MB, less than 79.11% of Kotlin online submissions for Rotate Array.
         */
        fun rotate2(nums: IntArray, k: Int) {
            if (nums.isEmpty()) return
            var k = k
            if (k > nums.size) k %= nums.size
            if (k == 0) return

            reverse(nums, 0, nums.lastIndex)
            println(nums.asList())
            reverse(nums, 0, k - 1)
            println(nums.asList())
            reverse(nums, k, nums.lastIndex)
            println(nums.asList())
        }

        fun reverse(nums: IntArray, start: Int, end: Int){
            var start = start
            var end = end
            while (start < end){
                val temp = nums[start]
                nums[start] = nums[end]
                nums[end] = temp
                start++
                end--
            }
        }
    }
}

fun main(){
    RotateArray.rotate2(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)
//    RotateArray.rotate2(intArrayOf(-1, -100, 3, 99), 2)
}