package leetcode.problems.difficulty.hard

import kotlin1.println
import kotlin.math.min

/**
 * 1723. Find Minimum Time to Finish All Jobs
 * https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/submissions/874127281/
 */
class FindMinimumTimeToFinishAllJobs {

    companion object {
        private var ans = Int.MAX_VALUE
        private lateinit var jobs: IntArray
        private lateinit var workers: IntArray
        private var k: Int = -1

        fun minimumTimeRequired(jobs: IntArray, k: Int): Int {
//          jobs.sort()
            FindMinimumTimeToFinishAllJobs.jobs = jobs
            FindMinimumTimeToFinishAllJobs.k = k
            workers = IntArray(k)
            dfs(0)
            return ans
        }

        private fun dfs(currIndex: Int) {
            if (currIndex == jobs.size) {
                ans = min(ans, workers.max() ?: return)
                println("-- ans: $ans --")
                println("\n\n")
                return
            }
            val seen = HashSet<Int>()
            for (i in 0 until k) {
                println("dfs: currIndex: $currIndex, seen: $seen, workers: ${workers.asList()}, ans = $ans")
                if (seen.contains(workers[i])) {
                    println("return from 1")
                    println("\n")
                    continue
                }
                if (workers[i] + jobs[currIndex] >= ans) {
                    println("return from 2 >>> ${workers[i]} + ${jobs[currIndex]} >= $ans")
                    println("\n")
                    continue
                }
                seen.add(workers[i])
                workers[i] += jobs[currIndex]
                println("dfs: currIndex: $currIndex, seen: $seen, workers: ${workers.asList()}, ans = $ans")
                dfs(currIndex + 1)
                workers[i] -= jobs[currIndex]
            }
        }
    }
}

fun main() {
    FindMinimumTimeToFinishAllJobs.minimumTimeRequired(
        intArrayOf(1, 2, 4, 7, 8), 2
    ).println()


//    FindMinimumTimeToFinishAllJobs.minimumTimeRequired(
//        intArrayOf(12, 13, 14, 17, 25), 3
//    ).println()

//    FindMinimumTimeToFinishAllJobs.minimumTimeRequired(
//        intArrayOf(11,2,20,18,2,1,7,11,7,10), 9
//    ).println()
}