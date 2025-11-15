package leetcode.problems.difficulty.medium

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/878/
 * https://leetcode.com/submissions/detail/596817767/?from=explore&item_id=878
 */
//"III"
//"IV"
//"IX"
class RomanToInteger {

    companion object {

        val map = HashMap<Char, Int>().apply {
            put('I', 1)
            put('V', 5)
            put('L', 50)
            put('X', 10)
            put('C', 100)
            put('D', 500)
            put('M', 1000)
        }

        fun romanToInt(s: String): Int {
            var res = 0
            var i = 0
            while (i <= s.lastIndex) {
                if (i == s.lastIndex) {
                    res += map[s[i]]!!
                    i += 1
                } else {
                    if (map[s[i]]!! < map[s[i + 1]]!!) {
                        res += map[s[i + 1]]!! - map[s[i]]!!
                        i += 2
                    } else {
                        res += map[s[i]]!!
                        i += 1
                    }
                }

            }
            return res
        }

    }
}