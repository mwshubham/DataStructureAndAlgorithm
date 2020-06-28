package leetcode.problems.array

// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
// https://leetcode.com/submissions/detail/336213566/?from=/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
class CheckStraightLine {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        if (coordinates.size == 2) return true
        val slope = (coordinates[1][1] - coordinates[0][1]).toFloat() / (coordinates[1][0] - coordinates[0][0])
        println("slope: $slope")
        for (index in 2 until coordinates.size) {
            val newSlope =
                (coordinates[index][1] - coordinates[0][1]).toFloat() / (coordinates[index][0] - coordinates[0][0])
            println("newSlope: $newSlope")
            if (slope != newSlope)
                return false
        }
        return true
    }
}


fun main() {
    val coordinates = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(5, 6)
    )
//    val coordinates = arrayOf(
//        intArrayOf(1, 1),
//        intArrayOf(2, 2),
//        intArrayOf(3, 4),
//        intArrayOf(4, 5),
//        intArrayOf(5, 6),
//        intArrayOf(7, 7)
//    )
    val instance = CheckStraightLine()
    print(instance.checkStraightLine(coordinates))
}