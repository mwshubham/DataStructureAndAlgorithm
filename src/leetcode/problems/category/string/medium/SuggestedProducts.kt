package leetcode.problems.category.string.medium

// https://leetcode.com/problems/search-suggestions-system/
class SuggestedProducts {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val output = ArrayList<List<String>>()
        products.sort()

        var lastStartIndex = 0
        var counter: Int

        (1..searchWord.length).forEach outer@{ searchIndexIndex ->
            val searchWordTemp = searchWord.substring(0, searchIndexIndex)
//            println("$searchIndexIndex. searchWordTemp: $searchWordTemp")
            val list = ArrayList<String>()
            output.add(list)
            counter = 0
            (lastStartIndex..products.lastIndex).forEach inner@{
                val product = products[it]
//                println("counter: $counter")
//                println("product: $product")
                if (product.startsWith(searchWordTemp, false)) {
                    list.add(product)
                    counter++
                } else if (counter == 1) {
                    return@outer
                }
                if (counter <= 1) {
                    lastStartIndex = it
                }
                if (counter == 3) {
                    return@outer
                }
            }
        }
        return output
    }
}