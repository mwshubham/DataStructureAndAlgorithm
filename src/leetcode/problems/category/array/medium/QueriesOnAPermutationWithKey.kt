package leetcode.problems.category.array.medium

import java.util.*

// https://leetcode.com/problems/queries-on-a-permutation-with-key/
class QueriesOnAPermutationWithKey {
    fun processQueries(queries: IntArray, m: Int): IntArray {
        val P = LinkedList<Int>()
        (1..m).forEach { P.add(it) }

        val outputArr = IntArray(queries.size)
        queries.forEachIndexed { index, value ->
            P.indexOf(value).let {
                outputArr[index] = it
                P.removeAt(it)
                P.addFirst(value)
            }
        }
        return outputArr
    }
}