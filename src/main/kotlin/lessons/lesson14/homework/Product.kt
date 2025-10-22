package org.example.lessons.lesson14.homework

data class Product(val name: String, val price: Double, val count: Int) {
    fun example() {
        println("Продукт - $name, цена - $price,кол-во - $count")
    }

}
