package org.example.lessons.lesson11.homework

fun main(){
    print("a1: ")
    println(a1())
    print("a2: ")
    println(a2(1,2))
    print("a3: ")
    println(a3("bb"))
    print("a4: ")
    println(a4(listOf(1,2,3,4,5)))
    print("a5: ")
    println(a5("null"))
    print("a6: ")
    println(a6())
    print("a7: ")
    println(a7(listOf(1,2,3,null,4,5)))
    print("a8: ")
    println(a8(1))
    print("a9: ")
    println(a9(1))
    print("a10: ")
    println(a10("ds",1))
    print("multiplyByTwo: ")
    println(multiplyByTwo(2))
    print("isEven: True -> ")
    print(isEven(2))
    print(" False -> ")
    println(isEven(3))
    print("printNumbersUntil: ")
    println(printNumbersUntil(0))
    print("findFirstNegative: ")
    println(findFirstNegative(listOf(1,2,3,2)))
    print("processList: ")
    println(processList(listOf("nn","bb",null,"yhy")))
}
//Задачи на сигнатуру метода
//Не принимает аргументов и не возвращает значения.
fun a1(){}
//Принимает два целых числа и возвращает их сумму.
fun a2(a: Int,b: Int): Int{
    return a+b
}
//Принимает строку и ничего не возвращает.
fun a3(a: String){}
//Принимает список целых чисел и возвращает среднее значение типа Double.
fun a4(a: List<Int>): Double {
    var sum: Double = 0.0
    var sr: Double = 0.0
    val long: Int = a.size
    for (i in a) {
        sum += i.toDouble()
    }
    sr = sum / long
    return sr
}
//Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun a5(a: String?): Int?{
    return a?.length
}
//Не принимает аргументов и возвращает nullable вещественное число.
fun a6(): Double? {
    return null
}
//Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun a7(a: List<Int?>){}
//Принимает целое число и возвращает nullable строку.
fun a8(a: Int): String? {
    return null
}
//Не принимает аргументов и возвращает список nullable строк.
fun a9(a: Int): List<String?>{
    return listOf()
}
//Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun a10(a: String?,b: Int?): Boolean?{
    return  null
}

//Задачи на написание кода
//Напишите валидную сигнатуру метода, а так же рабочий код для задач.

//Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(a: Int): Int{
    return a*2
}
//Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven(a: Int): Boolean{
    if (a % 2 == 0) {
        return true
    } else {
        return false
    }
}
//Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int): MutableList<Int> {
    val a = mutableListOf<Int>()
    if (n < 1) {
        return a
    } else {
        for (i in 1..n) {
            a.add(i)
        }
    }
    return a
}
//Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке.
// Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(a: List<Int>): Int? {
    for (i in a) {
        if (i < 0) {
            return i
        }
    }
    return null
}
//Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку.
// Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(a: List<String?>){
    for (i in a) {
        if (i == null){
            return
        } else {
            println(i)
        }
    }
}
