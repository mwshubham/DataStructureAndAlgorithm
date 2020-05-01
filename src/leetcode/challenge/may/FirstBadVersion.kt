package leetcode.challenge.may

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var left = 1
        var right = n
        var mid = 0

        if (n == 1) {
            return 1
        }

        while (right >= left) {
            mid = left + (right - left) / 2
//            println("L -> $left    R -> $right    M -> $mid")
            if (isBadVersion(mid)) {
                if (mid == 0) {
                    return mid
                }
                if (!isBadVersion(mid - 1)) {
                    return mid
                }
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return mid
    }
}

fun main() {
    print("Solution().firstBadVersion(1): ")
    println(Solution().firstBadVersion(1))

    print("Solution().firstBadVersion(2): ")
    println(Solution().firstBadVersion(2))

    print("Solution().firstBadVersion(3): ")
    println(Solution().firstBadVersion(3))

    print("Solution().firstBadVersion(10): ")
    println(Solution().firstBadVersion(10))
}