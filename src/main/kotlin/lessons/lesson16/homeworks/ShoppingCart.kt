package org.example.lessons.lesson16.homeworks

class ShoppingCart {
    private val items = mutableMapOf<Int, Int>()

    fun addToCart(itemId: Int) {
        items[itemId] = items.getOrDefault(itemId, 0) + 1
    }

    fun addToCart(itemId: Int, amount: Int) {
        if (amount > 0) {
            items[itemId] = items.getOrDefault(itemId, 0) + amount
        }
    }

    fun addToCart(itemsMap: Map<Int, Int>) {
        for ((itemId, amount) in itemsMap) {
            if (amount > 0) {
                items[itemId] = items.getOrDefault(itemId, 0) + amount
            }
        }
    }

    fun addToCart(itemIds: List<Int>) {
        for (itemId in itemIds) {
            items[itemId] = items.getOrDefault(itemId, 0) + 1
        }
    }

    override fun toString(): String {
        var result = "Содержимое корзины:\n"
        var totalQuantity = 0

        for ((id, quantity) in items) {
            result += "Товар ID $id: $quantity шт.\n"
            totalQuantity += quantity
        }

        result += "Всего товаров: $totalQuantity шт.\n"
        result += "Всего артикулов: ${items.size}"

        return result
    }
}

fun main() {
    val cart = ShoppingCart()

    cart.addToCart(101)

    cart.addToCart(102, 3)
    cart.addToCart(103, 5)

    val bulkItems = mapOf(
        104 to 2,
        105 to 1,
        101 to 2
    )
    cart.addToCart(bulkItems)

    val promoItems = listOf(106, 107, 102, 108)
    cart.addToCart(promoItems)

    println(cart)
}