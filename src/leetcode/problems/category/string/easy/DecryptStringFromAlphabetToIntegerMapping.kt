package leetcode.problems.category.string.easy

// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
class DecryptStringFromAlphabetToIntegerMapping {
    fun freqAlphabets(s: String): String {
        val strBuilder = StringBuilder()
        var counter = 0
        while (counter < s.length) {
            if (counter + 2 < s.length && s[counter + 2] == '#') {
                strBuilder.append(charMap[s.substring(counter, counter + 2)])
                counter += 3
            } else {
                strBuilder.append(charMap[s[counter].toString()])
                counter++
            }
        }
        return strBuilder.toString()
    }

    companion object {
        val charMap = HashMap<String, Char>().apply {
            put("1", 'a')
            put("2", 'b')
            put("3", 'c')
            put("4", 'd')
            put("5", 'e')
            put("6", 'f')
            put("7", 'g')
            put("8", 'h')
            put("9", 'i')
            put("10", 'j')
            put("11", 'k')
            put("12", 'l')
            put("13", 'm')
            put("14", 'n')
            put("15", 'o')
            put("16", 'p')
            put("17", 'q')
            put("18", 'r')
            put("19", 's')
            put("20", 't')
            put("21", 'u')
            put("22", 'v')
            put("23", 'w')
            put("24", 'x')
            put("25", 'y')
            put("26", 'z')
        }
    }
}