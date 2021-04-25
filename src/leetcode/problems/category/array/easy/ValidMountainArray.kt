package leetcode.problems.category.array.easy

/**
 * 941. Valid Mountain Array
 * https://leetcode.com/problems/valid-mountain-array/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
 * https://leetcode.com/submissions/detail/484995593/?from=explore&item_id=3251
 */
class ValidMountainArray {
    companion object {
        /**
         * Runtime: 220 ms, faster than 95.29% of Kotlin online submissions for Valid Mountain Array.
         * Memory Usage: 38.4 MB, less than 34.12% of Kotlin online submissions for Valid Mountain Array.
         */
        fun validMountainArray(arr: IntArray): Boolean {
            val n: Int = arr.size
            var i = 0
            var j = n - 1
            while (i + 1 < n && arr[i] < arr[i + 1]) i++
            while (j > 0 && arr[j - 1] > arr[j]) j--
            return i > 0 && i == j && j < n - 1
        }
    }
}