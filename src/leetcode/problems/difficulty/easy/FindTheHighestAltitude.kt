package leetcode.problems.difficulty.easy

/**
 * 1732. Find The Highest Altitude
 * https://leetcode.com/problems/find-the-highest-altitude/
 */
class FindTheHighestAltitude {
    fun largestAltitude(gain: IntArray): Int {
        var altitude = 0
        var maxAltitude = 0
        for (i in 0 until gain.size) {
            altitude += gain[i]
            maxAltitude = Math.max(maxAltitude, altitude)
        }
        return maxAltitude
    }

}