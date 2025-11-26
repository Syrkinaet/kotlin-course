package org.example.lessons.lesson23.homework

fun main() {

//    Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных чисел этого списка. С помощью require проверь, что список не пустой.
//    Создай аналогичную анонимную функцию.
//    Создай аналогичное лямбда выражение с указанием типа.
//    Создай лямбда выражение без указания типа.
//    Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).

    fun ex(list: List<Int>): Double {
        require(list.isNotEmpty())
        return list.filter { it % 2 == 0 }.average()
    }

    val ex1 = fun(list: List<Int>): Double {
        require(list.isNotEmpty())
        return list.filter { it % 2 == 0 }.average()
    }

    val ex2: (List<Int>) -> Double = { list ->
        require(list.isNotEmpty())
        list.filter { it % 2 == 0 }.average()
    }

    val ex3 = { list: List<Int> ->
        require(list.isNotEmpty())
        list.filter { it % 2 == 0 }
            .average()
    }
    val list1 = listOf<Int>()
    val list2 = listOf(5)
    val list3 = listOf(1, 2, 3, 4, 5, 6)
    println(ex2(list2))

//    Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа. Сделай проверку, что входящее число больше нуля. Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
//    Создай аналогичную анонимную функцию.
//    Создай аналогичное лямбда выражение с указанием типа.
//    Создай лямбда выражение без указания типа.
//    Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.

    fun ex4(a: Long): Int {
        require(a > 0) { "Число должно быть больше нуля" }
        return "$a".sumOf { it.digitToInt() }
    }

    val ex5 = fun(a: Long): Int {
        require(a > 0) { "Число больше нуля" }
        return "$a".sumOf { it.digitToInt() }
    }

    val ex6: (Long) -> Int = { a ->
        require(a > 0) { "Число больше нуля" }
        "$a".sumOf { it.digitToInt() }
    }

    val ex7 = { a: Long ->
        require(a > 0) { "Число больше нуля" }
        "$a".sumOf { it.digitToInt() }
    }

    val a1 = 1111111111L
    val a2 = 1010101010L
    val a3 = -100010010L
    println(ex7(a2))

//    Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел (встречающихся в списке более одного раза).
//    Создай аналогичную анонимную функцию.
//    Создай аналогичное лямбда выражение с указанием типа.
//    Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.


    fun List<Int>.duplicates(): Set<Int> {
        return toSet().associate { element ->
            element to this.count { it == element }
        }.filter { it.value > 1 }
            .keys
    }

    val ex8 = fun List<Int>.(): Set<Int> {
        return toSet().associate { element ->
            element to this.count { it == element }
        }.filter { it.value > 1 }
            .keys
    }
    val ex9: List<Int>.() -> Set<Int> = {
        toSet().associate { element ->
            element to this.count { it == element }
        }.filter { it.value > 1 }
            .keys
    }
    val a = listOf(0, 1, 2, 4, 2, 5, 6, 5, 7)
    println(a.ex9())
}


}