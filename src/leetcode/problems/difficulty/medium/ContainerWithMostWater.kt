package leetcode.problems.difficulty.medium

import kotlin.math.max
import kotlin.math.min

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */
class ContainerWithMostWater {

    companion object {
        fun maxArea(height: IntArray): Int {
            var result = 0
            for (i in 0..height.lastIndex - 1) {
                for (j in i + 1..height.lastIndex) {
                    result = max(result, (j - i) * min(height[i], height[j]))
                }
            }
            return result
        }

        fun maxArea2(height: IntArray): Int {
            var result = 0
            var left = 0
            var right = height.lastIndex
            while (left < right) {
                result = max(result, (right - left) * min(height[left], height[right]))
                if (height[left] < height[right]) {
                    var currentLeft = left
                    while (currentLeft < right && height[currentLeft] <= height[left]) {
                        currentLeft++
                    }
                    left = currentLeft
                } else {
                    var currentRight = right
                    while (currentRight > left && height[currentRight] <= height[right]) {
                        currentRight--
                    }
                    right = currentRight
                }
            }
            return result
        }
    }
}