package leetcode.problems.difficulty.easy

/**
 * 2215. Find the Difference of Two Arrays
 *
 * https://leetcode.com/problems/find-the-difference-of-two-arrays
 */
class FindTheDifferenceOfTwoArrays {

    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val n1Set = HashSet<Int>()
        val n2Set = HashSet<Int>()

        nums1.forEach {
            n1Set.add(it)
        }
        nums2.forEach {
            n2Set.add(it)
        }

        val res = ArrayList<List<Int>>()
        val n1Res = HashSet<Int>()
        val n2Res = HashSet<Int>()

        nums1.forEach {
            if (!n2Set.contains(it)) {
                n1Res.add(it)
            }
        }

        nums2.forEach {
            if (!n1Set.contains(it)) {
                n2Res.add(it)
            }
        }

        res.add(n1Res.toList())
        res.add(n2Res.toList())

        return res
    }
}