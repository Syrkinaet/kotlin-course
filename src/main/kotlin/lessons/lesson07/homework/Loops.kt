package org.example.lessons.lessons07.homework

// Напишите цикл for, который выводит числа от 1 до 5.
fun forwardRange1() {
    for (i in 1..5) {
        println(i)
    }
}

// Напишите цикл for, который выводит четные числа от 1 до 10.
fun forwardRange2() {
    for (i in 1..10) {
        if (i % 2 == 0) {
            println(i)
        }
    }
}

// Создайте цикл for, который выводит числа от 5 до 1.
fun reverseRange1() {
    for (i in 5 downTo 1) {
        println(i)
    }
}

// Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
fun reverseRange2() {
    for (i in 10 downTo 1) {
        if (i % 2 == 0) {
            println(i)
        }
    }
}

// Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
fun rangeWithStep() {
    for (count in 1..9 step 2) {
        println(count)
    }
}

// Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
fun everyThird() {
    for ((index, value) in (1..20).withIndex()) {
        if (index % 3 == 0) {
            println(value)
        }
    }
}

// Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
fun rangeWithUntil() {
    var size = 13

    for (i in 3 until size step 2) {
        println(i)
    }
}

// while
// Создайте цикл while, который выводит квадраты чисел от 1 до 5.
fun whileWithSquare() {
    var count = 1

    while (count < 6) {
        println(count * count)
        count++
    }
}

// Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
fun decreaseWhile() {
    var count = 10

    while (count > 5) {
        count--
    }
    println(count)
}

// do while
// Используйте цикл do while, чтобы вывести числа от 5 до 1.
fun doWhile1() {
    var count = 5

    do {
        println(count)
        count--
    } while (count >= 1)
}

// Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
fun doWhile2() {
    var count = 5

    do {
        println(count)
        count++
    } while (count < 10)
}

// break
// Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
fun break1() {
    for (i in 1..10) {
        if (i == 6) {
            break
        }
        println(i)
    }
}

// Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
fun break2() {
    var number = 1

    while (true) {
        println(number)
        number++
        if (number > 10) {
            break
        }
    }
}

// continue
// В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
fun continue1() {
    for (i in 1..10) {
        if (i % 2 == 0) {
            continue
        }
        println(i)
    }

}

// Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
fun continue2() {
    var number = 1

    while (number <= 10) {
        if (number % 3 == 0) {
            number++
            continue
        }
        println(number)
        number++
    }
}

// Используя вложенный цикл реализовать таблицу умножения, как на картинке.
fun getMultiplicationTable() {
    val range = 1..10

    for (row in range) {
        for (col in range) {
            print(row * col)
            print(" ")
        }
        println()
    }
}

// Напишите функцию, которая суммирует числа от 1 до 'arg' с помощью цикла for.
fun sumNumbers(arg: Int): Int {
    var sum = 0
    for (i in 1..arg) {
        sum += i
    }
    return sum
}

// Напишите функцию, которая вычисляет факториал числа 'arg' с использованием цикла while.
fun factorial(arg: Int): Long {
    var result: Long = 1
    var i = 1
    while (i <= arg) {
        result *= i
        i++
    }
    return result
}

// Напишите функцию, которая находит сумму всех четных чисел от 2 до 'arg', используя цикл while.
fun sumEvenNumbers(arg: Int): Int {
    var sum = 0
    var i = 2
    while (i <= arg) {
        sum += i
        i += 2
    }
    return sum
}

// Напишите функцию, которая используя вложенные циклы while, выведет заполненный прямоугольник размером 5x3 из символов *.
fun printRectangle() {
    var row = 1
    while (row <= 3) {
        var col = 1
        while (col <= 5) {
            print("*")
            col++
        }
        println()
        row++
    }
}

// Напишите функцию, которая используя цикл for найдёт суммы чётных и нечётных значений чисел от 1 до arg.
fun sumEvenOdd(arg: Int): Pair<Int, Int> {
    var sumEven = 0
    var sumOdd = 0

    for (i in 1..arg) {
        if (i % 2 == 0) {
            sumEven += i
        } else {
            sumOdd += i
        }
    }

    return Pair(sumEven, sumOdd)
}
