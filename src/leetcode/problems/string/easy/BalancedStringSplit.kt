package leetcode.problems.string.easy

// https://leetcode.com/problems/split-a-string-in-balanced-strings/
class BalancedStringSplit {
    fun balancedStringSplit(s: String): Int {
        var result = 0
        var counter = 0
        s.forEach {
            if (it == 'R') {
                counter++
            } else {
                counter--
            }
            if (counter == 0) {
                result++
            }
        }
        return result
    }
}