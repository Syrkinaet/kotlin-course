package org.example.lessons.lesson16.homeworks

open class Animal {

    open fun makeSound() {
        println("\u001b[37mThis animal makes no sound.\u001b[0m") // Серый цвет
    }
}

class Dog : Animal() {
    override fun makeSound() {
        println("\u001b[32mBark\u001b[0m") // Зелёный цвет
    }
}

class Cat : Animal() {
    override fun makeSound() {
        println("\u001b[33mMeow\u001b[0m") // Жёлтый цвет
    }
}

class Bird : Animal() {
    override fun makeSound() {
        println("\u001b[36mTweet\u001b[0m") // Голубой цвет
    }
}

fun main() {
    val animals: List<Animal> = listOf(
        Dog(),
        Cat(),
        Bird(),
        Animal()
    )

    animals.forEach { animal ->
        animal.makeSound()
    }
}