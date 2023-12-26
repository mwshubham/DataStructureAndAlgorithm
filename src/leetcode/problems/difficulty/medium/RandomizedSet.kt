package leetcode.problems.difficulty.medium

import kotlin1.println


/**
 * 380. Insert Delete GetRandom O(1)
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/112/design/813/
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/submissions/1128777081/
 */
class RandomizedSet {

    private val items = ArrayList<Int>()
    private val map = HashMap<Int, Int>()

    fun insert(`val`: Int): Boolean {
        if (map.containsKey(`val`)) return false
        items.add(`val`)
        map[`val`] = items.lastIndex
        return true
    }

    fun remove(`val`: Int): Boolean {
        map[`val`]?.also { itemPosition ->
            if (items.last() != `val`) {
                items[itemPosition] = items.last()
                map[items.last()] = itemPosition
            }
            map.remove(`val`)
            items.removeAt(items.lastIndex)
            return true
        }

        return false
    }

    fun getRandom(): Int {
        return items.random()
    }

    fun println() {
        items.println()
    }

}

fun main() {
    RandomizedSet().apply {
        insert(1)
        println()

        remove(2)
        println()

        insert(2)
        println()

        getRandom()
        println()

        remove(1)
        println()

        insert(2)
        println()

        getRandom()
        println()
    }
}

