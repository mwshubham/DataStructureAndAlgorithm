package hackerrank

import kotlin1.println
import kotlin.math.max
import kotlin.math.min

/**
 * https://github.com/geeniuss01/SysSquish/blob/main/technical_scenarios/2026_technical_scenarios.md#question-2-products-and-discounts
 */
class MinimumTotalAmout {
    fun minimumTotalAmount(
        products: Array<Array<String>>,
        discounts: Array<Array<String>>
    ): Int {
        var totalAmount = 0
        val discountsMap = discounts.associate {
            Pair(it[0], Pair(it[1], it[2].toInt()))
        }
        products.forEach { productInfo ->
            var productPrice = 0
            var minProductPrice = 0
            productInfo.forEachIndexed { index, productStr ->
                if (index == 0) {
                    productPrice = productStr.toInt()
                    minProductPrice = productPrice
                } else if (productStr != "EMPTY") {
                    val discount = discountsMap[productStr]!!
                    val priceAfterDiscount: Int = when (discount.first) {
                        "0" -> discount.second
                        "1" -> (productPrice * (1 - discount.second.toFloat() / 100)).toInt()
                        else -> max(0, productPrice - discount.second)
                    }
                    minProductPrice = max(0, min(minProductPrice, priceAfterDiscount))
                }
            }
            println("minProductPrice: $minProductPrice")
            totalAmount += minProductPrice
        }
        return totalAmount
    }
}

fun main() {
    MinimumTotalAmout().apply {
        minimumTotalAmount(
            products = arrayOf(
                arrayOf(
                    "1000", "d1", "d2", "d3"
                ),
                arrayOf(
                    "500", "EMPTY", "d2"
                ),
                arrayOf(
                    "300"
                )
            ),
            discounts = arrayOf(
                arrayOf(
                    "d1", "0", "500"
                ),
                arrayOf(
                    "d2", "1", "40"
                ),
                arrayOf(
                    "d3", "2", "200"
                )
            )
        ).println()
    }
}