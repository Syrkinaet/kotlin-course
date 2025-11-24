package org.example.lessons.lesson21


interface Drivable {
    fun drive()
}

interface Flyable {
    fun fly()
}

open class Car : Drivable {

    override fun drive() {
        println("Едет как автомобиль")
    }
}

class FlyingCar : Car(), Flyable {

    override fun fly() {
        println("Летит как самолёт")
    }
}

fun checkCapabilitiesWithSmartCast(drivable: Drivable) {
    drivable.drive()
    if (drivable is Flyable) {
        drivable.fly()
    } else {
        println("Этот объект не может летать.")
    }
}

fun checkCapabilities(drivable: Drivable) {
    drivable.drive()
    (drivable as? Flyable)?.fly() ?: println("Этот объект не может летать.")
}


fun main() {
    val obj: Any = "Hello, World!"
    if (obj is String) {
        println("Объект является строкой")
    }
    if (obj !is Int) {
        println("Объект не является целым числом")
    }



    if (obj is String) {
        // obj автоматически приведён к String
        println(obj.toUpperCase()) // Метод toUpperCase() доступен, т.к. obj теперь String
    }



    val num: Any = 123
    val str: String = num as String // Выбросит ClassCastException

    val safeStr: String? = num as? String // safeStr будет равно null



    val nullableStr: String? = "Kotlin"
    val nonNullableStr: String = nullableStr as String // Явное приведение типа


    val mixedList: List<Any> = listOf("Kotlin", 42, 3.14, "Java", true)
    for (item in mixedList) {
        when (item) {
            is String -> println("$item - строка длиной ${item.length}")
            is Int -> println("$item - целое число")
            is Double -> println("$item - вещественное число")
            else -> println("Неизвестный тип")
        }
    }



///////////////////
    val car = Car()
    checkCapabilities(car)

    val flyingCar = FlyingCar()
    checkCapabilities(flyingCar)



}