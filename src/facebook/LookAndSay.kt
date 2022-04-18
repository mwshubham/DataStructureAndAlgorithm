package facebook

class LookAndSay {

}

fun main() {
    val n = 11
    if (n <= 0) {
        println("")
        return
    }

    if (n == 1) {
        println("1")
        return
    }
    var lastList = ArrayList<Int>().apply {
        add(1)
    }

    println(lastList)

    var count: Int
    var lastNum: Int?

    repeat(n - 1) {
        count = 0
        lastNum = null
        val currentList = ArrayList<Int>()
        lastList.forEachIndexed { index, num ->
            if (index == lastList.lastIndex) {
                if (lastNum == null) {
                    currentList.add(1)
                    currentList.add(num)
                } else {
                    if (lastNum == num) {
                        currentList.add(++count)
                        currentList.add(num)
                    } else {
                        currentList.add(count)
                        currentList.add(lastNum!!)
                        currentList.add(1)
                        currentList.add(num)
                    }
                }
            } else if (lastNum != num) {
                if (lastNum == null) {
                    ++count
                    lastNum = num
                } else {
                    currentList.add(count)
                    currentList.add(lastNum!!)
                    count = 1
                    lastNum = num
                }
            } else {
                ++count
                lastNum = num
            }
        }
        println(currentList)
        lastList = currentList
    }
}