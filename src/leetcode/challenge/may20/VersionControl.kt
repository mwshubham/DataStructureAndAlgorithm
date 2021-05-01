package leetcode.challenge.may20

abstract class VersionControl {
    abstract fun firstBadVersion(n: Int): Int

    //    fun isBadVersion(n: Int) = n >= 1
//    fun isBadVersion(n: Int) = n >= 2
//    fun isBadVersion(n: Int) = n >= 3
//    fun isBadVersion(n: Int) = n >= 8
//    fun isBadVersion(n: Int) = n >= 9
    fun isBadVersion(n: Int) = n >= 10
}