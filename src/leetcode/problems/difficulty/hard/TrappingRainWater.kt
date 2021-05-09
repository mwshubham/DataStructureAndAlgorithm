package leetcode.problems.difficulty.hard

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 */
//[4,2,0,3,2,5]
class TrappingRainWater {
    companion object {
        /**
         * Runtime: 200 ms, faster than 41.91% of Kotlin online submissions for Trapping Rain Water.
         * Memory Usage: 37.1 MB, less than 73.03% of Kotlin online submissions for Trapping Rain Water.
         */
        fun trap(height: IntArray): Int {
            var left = 0
            var right = height.lastIndex
            var res = 0
            var maxLeft = 0
            var maxRight = 0
            while (left <= right) {
                if (height[left] <= height[right]) {
                    if (height[left] >= maxLeft) {
                        maxLeft = height[left]
                    } else {
                        res += maxLeft - height[left]
                    }
                    left++
                } else {
                    if (height[right] >= maxRight) {
                        maxRight = height[right]
                    } else {
                        res += maxRight - height[right]
                    }
                    right--
                }
            }
            return res
        }
    }
}