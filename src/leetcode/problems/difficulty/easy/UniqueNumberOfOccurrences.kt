package leetcode.problems.difficulty.easy

/**
 * 1207. Unique Number of Occurrences
 * https://leetcode.com/problems/unique-number-of-occurrences
 */
class UniqueNumberOfOccurrences {

    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        arr.forEach {
            map.put(it, map.get(it)?.plus(1) ?: 1)
        }
        val set = HashSet<Int>()
        map.forEach {
            if (set.contains(it.value)) {
                return false
            }
            set.add(it.value)
        }

        return true
    }

}