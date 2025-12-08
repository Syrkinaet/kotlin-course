package org.example.lessons.lesson25.homeworks

class num1 {
//    Создайте функцию timeTracker, которая принимает
//    другую функцию в качестве аргумента и измеряет время её выполнения.
//    Функция timeTracker должна возвращать затраченное время в миллисекундах.
//    Для измерения времени используйте System.currentTimeMillis() до и после выполнения переданной функции.

    fun <R> timeTracker(fnc: () -> R): Long {
        val start = System.currentTimeMillis()
        fnc()
        val end = System.currentTimeMillis()
        return end - start
    }

    fun main() {

        val myFunction = {
            val list = List(10000000) { (0..10000).random() }
            list.sorted()
        }

        val time = timeTracker(myFunction)
        println("Время: $time ")
    }

}