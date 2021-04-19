package leetcode.problems.category.string.easy

import java.util.*

// https://leetcode.com/problems/destination-city/
class DestinationCity {
    fun destCity(paths: List<List<String>>): String {
        val set = HashSet<String>()
        for (path in paths) set.add(path[1])
        for (path in paths) set.remove(path[0])
        return set.iterator().next()
    }
}