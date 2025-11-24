package org.example.lessons.lesson21.homeworks

//Напишите функцию analyzeDataType, принимающую параметр типа Any.
//Функция должна определить тип аргумента и вывести соответствующее сообщение:
//
//Для строки: "Это строка: [значение]".
//
//Для любого числа: "Это число: [значение]".
//
//Для списка: "Это список, количество элементов: [количество]".
//
//Для словаря: "Это словарь, количество пар: [количество]".
//
//Для остальных типов: "Неизвестный тип данных".
//
//Используйте оператор is для проверки типов

fun analyzeDataType(value: Any) {
    if (value is String) {
        println("Это строка: $value")
    } else if (value is Number) {
        println("Это число: $value")
    } else if (value is List<*>) {
        println("Это список, количество элементов: ${value.size}")
    } else if (value is Map<*, *>) {
        println("Это словарь, количество пар: ${value.size}")
    } else {
        println("Неизвестный тип данных")
    }
}

//Создайте функцию safeCastToList, принимающую параметр типа Any
//и возвращающую размер списка, если аргумент можно безопасно привести к типу List.
//В случае неудачного приведения функция должна возвращать -1.
//Используйте оператор as? для безопасного приведения типа.

fun safeCastToList(value: Any): Int {
    val list = value as? List<*>
    return if (list != null) list.size else -1
}

//Создайте функцию getStringLengthOrZero,
//которая принимает параметр типа Any?
//и возвращает длину строки, если аргумент можно привести к типу String.
//Если аргумент равен null или не является строкой, функция должна возвращать 0

fun getStringLengthOrZero(value: Any?): Int {
    val str = value as? String
    return str?.length ?: 0
}

//Создайте функцию-расширение класса Any под названием toSquare.
//Функция гарантированно вызывается у числа (в виде числа или строки,
//например 4, 4.2 или "4.2") и должна вернуть квадрат этого числа.
//
//Если приходит число — его нужно возвести в квадрат.
//
//Если приходит строка — нужно преобразовать её в число через toDouble()
//и также возвести в квадрат.

fun Any.toSquare(): Double {
    if (this is Number) {
        val num = this.toDouble()
        return num * num
    }
    if (this is String) {
        val num = this.toDouble()
        return num * num
    }
    return 0.0
}

//Напишите функцию sumIntOrDoubleValues,
//которая принимает список элементов типа Any
//и возвращает сумму всех целочисленных (Int) и вещественных (Double) значений в списке.
//Все остальные типы должны быть проигнорированы.

fun sumIntOrDoubleValues(items: List<Any>): Double {
    var sum = 0.0
    for (item in items) {
        if (item is Int) {
            sum += item
        } else if (item is Double) {
            sum += item
        }
    }
    return sum
}

//Создайте функцию tryCastToListAndPrint,
//которая принимает параметр типа Any
//и пытается привести его к типу List<*>.
//
//Если приведение успешно:
//
//функция должна напечатать все строки из списка;
//
//если элемент не является строкой — вывести предупреждение.
//
//Если приведение неудачно — должно быть выведено сообщение об ошибке,
//не прерывая выполнение программы.

fun tryCastToListAndPrint(value: Any) {
    val list = value as? List<*>
    if (list == null) {
        println("Ошибка: объект нельзя привести к списку")
        return
    }

    for (item in list) {
        if (item is String) {
            println(item)
        } else {
            println("Предупреждение: элемент не является строкой -> $item")
        }
    }
}
