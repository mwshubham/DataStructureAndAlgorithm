package searching

import kotlin1.println

val intArr123: IntArray = intArrayOf(0, 1, 2, 3, 4, 5)
//val intArray: IntArray = intArrayOf(1, 4, 6, 8, 9, 10)
val intArray: IntArray = intArrayOf(-1, 0, 3, 5, 9, 12)

fun search(nums: IntArray, target: Int): Int {
//    if (nums.size == 1 && nums[0] == target) return 0
//    if (target < nums[0] || target > nums.last()) return -1
//    if (target == nums[0]) return 0
//    if (target == nums.last()) return nums.lastIndex
    var start = 0
    var end = nums.lastIndex
    while (start <= end) {
//        val mid = start + (end + start) / 2
        val mid = (end + start) / 2
        val midV = nums[mid]
        if (target == midV) {
            return mid
        } else if (target < midV) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return -1
}

fun main() {
    intArray.forEachIndexed { index, i  ->
        search(intArray, i).println()
    }
//    search(intArray, 0).println()
}