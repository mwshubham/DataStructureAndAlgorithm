package leetcode.challenge.may

// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
// https://leetcode.com/submissions/detail/337241747/?from=/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
class TownJudge {

//    fun findJudge(N: Int, trust: Array<IntArray>): Int {
//        if (N == 1 && trust.isEmpty()) return 1
//        val map = hashMapOf<Int, HashSet<Int>>()
//        trust.forEach {
//            map.getOrPut(it[0], { hashSetOf(it[1]) }).add(it[1])
//            if (map.size == N) return -1
//        }
//        if (map.size != N - 1) return -1
//        val possiblyTownJudge = trust.firstOrNull { !map.containsKey(it[1]) }?.get(1) ?: return -1
//        return if (map.entries.all { it.value.contains(possiblyTownJudge) }) {
//            possiblyTownJudge
//        } else {
//            -1;
//        }
//    }

    // sample 368 ms submission
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val trustCounts = IntArray(N + 1)
        for (i in trust) {
            trustCounts[i[0]]--
            trustCounts[i[1]]++
        }

        for (i in 1..N) {
            if (trustCounts[i] == N - 1) return i
        }
        return -1
    }
}

fun main() {
    val instance = TownJudge()
    println(instance.findJudge(1, arrayOf())) // 1
    println(instance.findJudge(2, arrayOf(intArrayOf(1, 2)))) // 2
    println(instance.findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3)))) // 3
    println(instance.findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1)))) // -1
    println(instance.findJudge(3, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)))) // -1
    println(
        instance.findJudge(
            4, arrayOf(
                intArrayOf(1, 3),
                intArrayOf(1, 4),
                intArrayOf(2, 3),
                intArrayOf(2, 4),
                intArrayOf(4, 3)
            )
        )
    ) // 3

    println(
        instance.findJudge(
            4, arrayOf(
                intArrayOf(1, 3),
                intArrayOf(1, 4),
                intArrayOf(2, 3),
                intArrayOf(2, 4),
                intArrayOf(4, 3)
            )
        )
    ) // 3

//    11
//    [[1,8],[1,3],[2,8],[2,3],[4,8],[4,3],[5,8],[5,3],[6,8],[6,3],[7,8],[7,3],[9,8],[9,3],[11,8],[11,3]]
}