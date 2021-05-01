package leetcode.challenge.may20

import java.util.*


// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
// https://leetcode.com/submissions/detail/343867437/?from=/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
class IntervalListIntersection {

    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray?> {
        val output = ArrayList<IntArray>()
        var indexI = 0
        var indexJ = 0
        while (indexI < A.size && indexJ < B.size) {
            val lo = A[indexI][0].coerceAtLeast(B[indexJ][0])
            val hi = A[indexI][1].coerceAtMost(B[indexJ][1])
            if (lo <= hi) output.add(intArrayOf(lo, hi))
            if (A[indexI][1] < B[indexJ][1]) {
                indexI++
            } else indexJ++
        }
        return output.toTypedArray()
    }
}