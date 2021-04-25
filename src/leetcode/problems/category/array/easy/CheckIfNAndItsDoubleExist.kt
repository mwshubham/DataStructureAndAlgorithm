package leetcode.problems.category.array.easy

/**
 * 1346. Check If N and Its Double Exist
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
 * https://leetcode.com/submissions/detail/484993488/?from=explore&item_id=3250
 */
class CheckIfNAndItsDoubleExist {

    companion object {

        /**
         * Runtime: 176 ms, faster than 62.96% of Kotlin online submissions for Check If N and Its Double Exist.
         * Memory Usage: 35.7 MB, less than 91.36% of Kotlin online submissions for Check If N and Its Double Exist.
         */
        fun checkIfExist(arr: IntArray): Boolean {
            val map = hashMapOf<Int, Int>()
            arr.forEachIndexed { index, i -> map[i] = index }
            arr.forEachIndexed { index, i ->
                if (map.contains(i * 2) && map[i * 2] != index) return true
            }
            return false
        }

        /**
         * Runtime: 152 ms, faster than 100.00% of Kotlin online submissions for Check If N and Its Double Exist.
         * Memory Usage: 35.7 MB, less than 91.36% of Kotlin online submissions for Check If N and Its Double Exist.
         */
        fun checkIfExist2(arr: IntArray): Boolean {
            val seen = hashSetOf<Int>()
            arr.forEach {
                if (seen.contains(it * 2) || it % 2 == 0 && seen.contains(it / 2)) return true
                seen.add(it)
            }
            return false
        }

    }
}