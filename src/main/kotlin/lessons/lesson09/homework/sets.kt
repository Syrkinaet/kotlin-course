package org.example.lessons.lesson09.homework

fun main() {
    arrayEx()
    findElement()
    listsEx()
    setEx()
    setFun2()
    setFun3()
}

//Работа с массивами Array
fun arrayEx() {
//Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val a1: Array<Int> = arrayOf(1, 2, 3, 4, 5)
//Создайте пустой массив строк размером 10 элементов.
    val emptyArray = Array(10) { "" }
//Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val a2: DoubleArray = doubleArrayOf(0.0, 2.0, 4.0, 6.0, 8.0)
//Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    val a3: Array<Int> = Array(5) { 0 }
    for (i in a3.indices) {
        a3[i] = i * 3
    }
    println(a3.joinToString(", "))
////Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val a4: Array<String?> = arrayOf(null, "smth", "smth2")
//Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val a5: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val a6: Array<Int> = Array(5) { 0 }
    for (i in a5.indices) {
        a6[i] = a5[i]
    }
    println(a6.joinToString(", "))

//Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    val a7: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val a8: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val a9: Array<Int> = Array(5) { 0 }
    for (i in a7.indices) {
        a9[i] = a8[i] - a7[i]
    }
    println(a9.joinToString(", "))


//Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
    val a10: Array<Int> = arrayOf(5,2,4,4,6,6,6,6,6,5)
    var counter = 0
    while (counter != a10.lastIndex){
        if (a10[counter] == 5 ) {
            println(counter)
            return
        } else if (counter == a10.lastIndex) {
            println("-1")
            return
        } else
            counter++
    }
//Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val a11: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    for (i in a11.indices) {
        if (a11[i] % 2 == 0) {
            print(a11[i])
            println(" - четное")

        } else {
            print(a11[i])
            println(" - нечетное")
        }

    }

}

//Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.

fun findElement(arg: String = "ab", arg2: Array<String> = arrayOf("abc", "def", "jkl", "oli", "kio")) {
    for (i in arg2.indices) {
        if (arg2[i].contains(arg)) {
            println(arg2[i])
        }
    }
}

//Работа со списками List
fun listsEx() {
//Создайте пустой неизменяемый список целых чисел.
    val a11: List<Int> = listOf()
//Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val a12: List<String> = listOf("Hello", "World", "Kotlin")
//Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val a13: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
//Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    a13.add(6)
    a13.add(7)
    a13.add(8)
//Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val a14: MutableList<String> = mutableListOf("Hello", "World", "Kotlin")
    a14.remove("Kotlin")
//Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val a15: List<Int> = listOf(10, 11, 12, 13, 14)
    for (i in a15.indices) {
        println(a15[i])
    }

//Создайте список строк и получите из него второй элемент, используя его индекс.
    val a16: List<String> = listOf("1", "2", "3")
    println(a16[1])
//Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
    val a17: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    a17[2] = 5
    println(a17[2])
//Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
    val a18: List<String> = listOf("1", "2", "3")
    val a19: List<String> = listOf("4", "5", "6")
    val a20: MutableList<String> = mutableListOf()
    for (i in a18.indices) {
        a20.add(a18[i])
    }
    for (i in a19.indices) {
        a20.add(a19[i])
    }
    println(a20.joinToString(", "))

//Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val a21: List<Int> = listOf(10, 88, 12, 4, 14)
    var max: Int = a21[0]
    var min: Int = a21[0]
    for (n in a21.indices) {
        if (a21[n] > max) {
            max = a21[n]
        }
    }
    for (b in a21.indices) {
        if (a21[b] < min) {
            min = a21[b]
        }
    }
    println(min)
    println(max)

//Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
//
    val a22: List<Int> = listOf(10, 83, 12, 4, 3)
    val a23: MutableList<Int> = mutableListOf()
    for (i in a22.indices)
        if (a22[i] % 2 == 0) {
            a23.add(a22[i])
        }
    println(a23.joinToString(", "))
}

fun setEx() {
//Работа с Множествами Set
//
//Создайте пустое неизменяемое множество целых чисел.
    val a24: Set<Int> = emptySet()
//Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val a25: Set<Int> = setOf(1, 2, 3)
//Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    val a26: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
//Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    a26.add("Swift")
//Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    a26.remove("Java")
//Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val a27 = setOf(10, 11, 12, 13, 14)
    for (i in a27) {
        println("| $i |")
    }
}

//Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
fun setFun2(arg: String = "abc", arg2: Set<String> = setOf("abc", "def", "jkl", "oli", "kio")) {
    println(arg2.contains(arg))
}


//Создайте множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
fun setFun3(){
    val a28: Set<String> = setOf("a","b","c")
    val a29: MutableSet<String> = mutableSetOf()
    for (i in a28) {
        println(i)
        a29.add(i)
    }
    println(a29)
}