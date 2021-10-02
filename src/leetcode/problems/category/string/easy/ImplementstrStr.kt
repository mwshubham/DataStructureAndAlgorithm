package leetcode.problems.category.string.easy

/**
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/
 */
class ImplementstrStr {
    fun strStr(haystack: String, needle: String): Int {
        // empty needle appears everywhere, first appears at 0 index
        // empty needle appears everywhere, first appears at 0 index
        if (needle.isEmpty()) return 0
        if (haystack.isEmpty()) return -1


        for (i in haystack.indices) {
            // no enough places for needle after i
            if (i + needle.length > haystack.length) break
            for (j in needle.indices) {
                if (haystack[i + j] != needle[j]) break
                if (j == needle.length - 1) return i
            }
        }

        return -1
    }
}