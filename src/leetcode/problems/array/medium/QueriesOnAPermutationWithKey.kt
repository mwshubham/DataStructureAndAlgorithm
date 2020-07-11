package leetcode.problems.array.medium

import java.util.*
import javax.print.attribute.IntegerSyntax

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