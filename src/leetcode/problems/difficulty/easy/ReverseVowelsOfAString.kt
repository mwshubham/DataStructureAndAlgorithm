package leetcode.problems.difficulty.easy

/**
 * 345. Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
class ReverseVowelsOfAString {

    fun reverseVowels(s: String): String {
        if (s.length <= 1) return s

        val set = HashSet<Char>()
        set.add('a')
        set.add('e')
        set.add('i')
        set.add('o')
        set.add('u')

        set.add('A')
        set.add('E')
        set.add('I')
        set.add('O')
        set.add('U')

        val res = Array<Char>(s.length) { s[it] }

        var start = 0
        var end = s.lastIndex

        while (start < end) {
            while (start <= end && !set.contains(s[start])) {
                start++
            }
            if (start > end) {
                break
            }

            while (end >= start && !set.contains(s[end])) {
                end--
            }

            if (end < start) {
                break
            }

            res[start] = s[end]
            res[end] = s[start]

            start++
            end--
        }

        val sb = StringBuilder()
        res.forEach {
            sb.append(it)
        }
        return sb.toString()
    }

}