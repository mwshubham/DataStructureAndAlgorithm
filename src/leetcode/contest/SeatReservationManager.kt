package leetcode.contest

import java.lang.Exception
import java.util.*
import kotlin.collections.HashMap


//["SeatManager","reserve","reserve","unreserve","reserve","reserve","reserve","reserve","unreserve"]
//[[5],[],[],[2],[],[],[],[],[5]]
//["SeatManager","reserve","unreserve","reserve","unreserve","reserve","reserve","reserve","unreserve","unreserve"]
//[[18],[],[1],[],[1],[],[],[],[1],[3]]
/**
 * 1845. Seat Reservation Manager
 * https://leetcode.com/problems/seat-reservation-manager/
 * Runtime: 784 ms, faster than 100.00% of Kotlin online submissions for Seat Reservation Manager.
 * Memory Usage: 92.9 MB, less than 100.00% of Kotlin online submissions for Seat Reservation Manager.
 */
class SeatManager(n: Int) {

    val pq = PriorityQueue<Int>()

    init {
        for (i in 1..n) {
            pq.add(i)
        }
    }

    fun reserve(): Int {
        return pq.poll()
    }

    fun unreserve(seatNumber: Int) {
        pq.add(seatNumber)
    }

}