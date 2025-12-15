package org.example.lessons.lesson27

//Простая группа констант
object NumsObject {
    const val ONE = "ONE"
    const val TWO = "TWO"
    const val THREE = "THREE"
}
//Enum вместо констант
enum class Nums {
    ONE,
    TWO,
    THREE
}

fun main() {
    println(Nums.ONE)
    for (n in Nums.entries) {
        println(n)
    }
}
//Использование в when
fun printNum(num: Nums) {
//    when(num) {
//        Nums.ONE -> println(1)
//    }
}
//В примере выше возникает ошибка в операторе when, так как он требует реализации веток для всех перечислений enum.
//Можно через контекстное меню оператора автоматически добавить все недостающие ветки, либо использовать ветку else.


//Enum в Kotlin может иметь конструктор, позволяющий определить дополнительные свойства для каждой константы.
//Это делает перечисления удобным инструментом для моделирования сложных данных.

enum class DayOfWeek1(val dayNumber: Int, val isWeekend: Boolean) {
    MONDAY(1, false),
    TUESDAY(2, false),
    WEDNESDAY(3, false),
    THURSDAY(4, false),
    FRIDAY(5, false),
    SATURDAY(6, true),
    SUNDAY(7, true);

    fun printDayType() {
        if(isWeekend) println("$name is a weekend")
        else println("$name is a weekday")
    }
}
//Список всех enum констант
//Иногда необходимо выполнить перебор по всем enum константам в цикле. Сделать это можно используя свойство entries у
//класса константы, которое вернёт список всех констант.

//Этот подход можно использовать для получения нужной константы по её полю. Обновим класс DayOfWeek:

enum class DayOfWeek(val dayNumber: Int, val isWeekend: Boolean) {
    MONDAY(1, false),
    TUESDAY(2, false),
    WEDNESDAY(3, false),
    THURSDAY(4, false),
    FRIDAY(5, false),
    SATURDAY(6, true),
    SUNDAY(7, true);

    companion object {
        fun getDay(dayNumber: Int): DayOfWeek {
            return entries.firstOrNull { it.dayNumber == dayNumber }
                ?: throw IllegalArgumentException("Нет дня недели с номером $dayNumber")
        }
    }

    fun printDayType() {
        if(isWeekend) println("$name is a weekend")
        else println("$name is a weekday")
    }
}


//Ограничения и особенности
//Неизменяемость: После создания enum константы неизменяемы. Вы не можете динамически добавлять или удалять константы
// во время выполнения программы.
//Экземпляры: Каждая константа перечисления является экземпляром перечислительного класса, поэтому вы можете использовать
// их в when выражениях без необходимости добавления else ветки, так как Kotlin знает ограниченное количество возможных экземпляров.
enum class CoffeeType(val cost: Double, val coffeeBase: String, val recommendedSugar: Int, val hasMilk: Boolean = false) {
    ESPRESSO(2.50, "Espresso", 0),
    LATTE(3.00, "Latte", 2, true),
    CAPPUCCINO(2.75, "Cappuccino", 1, true),
    AMERICANO(2.25, "Americano", 0);

    fun description() = "The $coffeeBase ${if (hasMilk) "with" else "without"} milk costs \$$cost and is best with $recommendedSugar spoons of sugar."
}

//В этом примере с большим количеством аргументов можно увидеть, что каждое перечисление CoffeeType выглядит так,
// словно мы создаём отдельные объекты с конструктором, передавая в них заранее определённые параметры. При этом каждый
// элемент перечисления будет как бы экземпляром класса CoffeeType который в свою очередь очень похож на data class.
// Таким образом упрощённо можно сказать, что enum это перечисление предопределённых data class объектов создаваемых в
// момент первого обращения к базовому классу enum и являются полями этого класса.

//Ещё одна особенность - методы в enum классе не доступны из CoffeeType напрямую, так как это просто класс, а
// проинициализировать его как обычный класс нельзя. Эти методы доступны из объектов перечислений.

