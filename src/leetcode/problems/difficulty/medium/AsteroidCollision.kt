package leetcode.problems.difficulty.medium

import kotlin1.println
import java.util.Stack
import kotlin.math.abs

/**
 * 735. Asteroid Collision
 * https://leetcode.com/problems/asteroid-collision/
 */
class AsteroidCollision {

    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        for (asteroid in asteroids) {
            if (stack.isEmpty() ||
                stack.peek() > 0 && asteroid > 0 ||
                stack.peek() < 0 && asteroid < 0 ||
                stack.peek() < 0 && asteroid > 0
            ) {
                stack.push(asteroid)
            } else {
                while (stack.isNotEmpty()) {
                    if (stack.peek() == abs(asteroid)) {
                        stack.pop()
                        break
                    } else if (stack.peek() > 0 && stack.peek() < abs(asteroid)) {
                        stack.pop()
                        if (stack.isEmpty()) {
                            stack.push(asteroid)
                            break
                        }
                    } else if (stack.isEmpty() ||
                        stack.peek() > 0 && asteroid > 0 ||
                        stack.peek() < 0 && asteroid < 0 ||
                        stack.peek() < 0 && asteroid > 0
                    ) {
                        stack.push(asteroid)
                        break
                    } else {
                        break
                    }
                }
            }
        }
        return stack.toIntArray()
    }

    fun asteroidCollision2(asteroids: IntArray): IntArray {
        val deque = ArrayDeque<Int>()
        for (asteroid in asteroids) {
            var isAlive = true
            while (
                isAlive
                && deque.isNotEmpty()
                && deque.last() > 0
                && asteroid < 0
            ) {
                when {
                    deque.last() < -asteroid -> {
                        deque.removeLast()
                    }
                    deque.last() == -asteroid -> {
                        deque.removeLast()
                        isAlive = false
                    }
                    else -> {
                        isAlive = false
                    }
                }
            }
            if (isAlive) {
                deque.addLast(asteroid)
            }
        }
        return deque.toIntArray()
    }
}

fun main() {
    AsteroidCollision().apply {
        asteroidCollision(intArrayOf(5, 10, -5)).println()
        asteroidCollision(intArrayOf(8, -8)).println()
        asteroidCollision(intArrayOf(10, 2, -5)).println()
        asteroidCollision(intArrayOf(3, 5, -6, 2, -1, 4)).println()
        asteroidCollision(intArrayOf(-2, -2, 1, -2)).println()
    }
}
