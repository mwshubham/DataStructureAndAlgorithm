package leetcode.problems.category.dynamicprogramming.medium

/**
 * 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/
 */
//"aabcc"
//"dbbca"
//"aadbbcbcac"
//"aabcc"
//"dbbca"
//"aadbbbaccc"
//""
//""
//""
//"a"
//"b"
//"a"
class InterleavingString {
    /**
     * Runtime: 228 ms, faster than 25.64% of Kotlin online submissions for Interleaving String.
     * Memory Usage: 44.5 MB, less than 10.26% of Kotlin online submissions for Interleaving String.
     */
    companion object{
        val map = hashMapOf<String, Boolean>()

        fun isInterleave(s1: String, s2: String, s3: String): Boolean {
            if (s3.length != s1.length + s2.length) return false
           return solve(s1, s2, s3)
        }


        private fun solve(s1: String, s2: String, s3: String): Boolean{
            if (s3.isEmpty()) return true

            val key = "$s1:$s2:$s3"
            if (map.containsKey(key)){
                return map[key]!!
            }

            var res1 = false
            var res2 = false
            if (s1.isNotEmpty() && s1.first() == s3.first()){
                res1 = solve(s1.substring(1), s2, s3.substring(1))
            }
            if (s2.isNotEmpty() && s2.first() == s3.first()){
                res2 = solve(s1, s2.substring(1), s3.substring(1))
            }
            return (res1 || res2).also {
                map[key] = it
            }
        }
    }
}