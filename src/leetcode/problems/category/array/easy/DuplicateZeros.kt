package leetcode.problems.category.array.easy

/**
 * 1089. Duplicate Zeros
 * https://leetcode.com/problems/duplicate-zeros/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
 *
 * https://leetcode.com/submissions/detail/484481876/?from=explore&item_id=3245
 */
class DuplicateZeros {
    companion object {
        /**
         * Runtime: 196 ms, faster than 71.09% of Kotlin online submissions for Duplicate Zeros.
         * Memory Usage: 37.1 MB, less than 67.19% of Kotlin online submissions for Duplicate Zeros.
         */
        fun duplicateZeros(arr: IntArray) {
            var countZero = 0
            for (element in arr) {
                if (element == 0) countZero++
            }
            val len: Int = arr.size + countZero
            //We just need O(1) space if we scan from back
            //i point to the original array, j point to the new location
            var i: Int = arr.size - 1
            var j = len - 1
            while (i >= 0 && j >= 0) {
                if (arr[i] != 0) {
                    if (j < arr.size) arr[j] = arr[i]
                } else {
                    if (j < arr.size) arr[j] = arr[i]
                    j--
                    if (j < arr.size) arr[j] = arr[i] //copy twice when hit '0'
                }
                i--
                j--
            }
        }
    }
}