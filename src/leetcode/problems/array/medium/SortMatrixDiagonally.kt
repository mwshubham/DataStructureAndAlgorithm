package leetcode.problems.array.medium

import java.util.*
import kotlin.collections.HashMap

// https://leetcode.com/problems/sort-the-matrix-diagonally/
class SortMatrixDiagonally {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val map = HashMap<Int, PriorityQueue<Int>>()
        mat.forEachIndexed { row, ints ->
            ints.forEachIndexed { column, value ->
                map[row - column]?.add(value)
                    ?: map.put(row - column, PriorityQueue<Int>().apply {
                        add(value)
                    })
            }
        }
        mat.forEachIndexed { row, ints ->
            ints.forEachIndexed { column, _ ->
                mat[row][column] = map[row - column]!!.poll()
            }
        }
        return mat
    }
}