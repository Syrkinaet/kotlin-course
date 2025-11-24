package org.example.lessons.lesson22.homeworks

fun main() {

// NullPointerException
    val x: String? = null
    println(x!!.length)

// IndexOutOfBoundsException
    val list = listOf(1, 2, 3)
    println(list[5])

// ClassCastException
    val obj: Any = "text"
    val num = obj as Int

// IllegalArgumentException
    require(2 > 5)

// NumberFormatException
    val n = "abc".toInt()

// IllegalStateException
    check(false)

// OutOfMemoryError
    val huge = MutableList(Int.MAX_VALUE) { ByteArray(1024) }

    // StackOverflowError
    fun boom(): Int = boom() + 1
    boom()

// Всё одним блоком:

    try {
        val x: String? = null
        println(x!!.length)

        val list = listOf(1, 2, 3)
        println(list[5])

        val obj: Any = "text"
        val num = obj as Int

        require(2 > 5)

        val n = "abc".toInt()

        check(false)

        val huge = MutableList(Int.MAX_VALUE) { ByteArray(1024) }

        fun boom(): Int = boom() + 1
        boom()

    } catch (e: NullPointerException) {
        println("NullPointerException")
    } catch (e: IndexOutOfBoundsException) {
        println("IndexOutOfBoundsException")
    } catch (e: ClassCastException) {
        println("ClassCastException")
    } catch (e: IllegalArgumentException) {
        println("IllegalArgumentException")
    } catch (e: NumberFormatException) {
        println("NumberFormatException")
    } catch (e: IllegalStateException) {
        println("IllegalStateException")
    } catch (e: OutOfMemoryError) {
        println("OutOfMemoryError")
    } catch (e: StackOverflowError) {
        println("StackOverflowError")
    }

/////////////////////

// Задача:
// Напишите функцию, которая принимает nullable аргумент типа Any и в блоке try/catch
// выполнит набор действий с этим аргументом, которые могут вызвать исключения
// (в порядке: NullPointerException, IndexOutOfBoundsException,
// ClassCastException, IllegalArgumentException, NumberFormatException, IllegalStateException).
// В catch перехватить Throwable и через when определить тип исключения и вывести его имя.
// После when выбросить то же исключение через throw.
// Если аргумент не вызвал исключение — вывести сообщение, что аргумент фантастически хорош.

    fun chk(a: Any?) {
        try {
            val x = a!!
            val list = listOf(1)
            val z = list[5]
            val c = x as Int
            require(false)
            val n = x.toString().toInt()
            check(false)

            println("Аргумент фантастически хорош!")

        } catch (t: Throwable) {
            when (t) {
                is NullPointerException -> println("NullPointerException")
                is IndexOutOfBoundsException -> println("IndexOutOfBoundsException")
                is ClassCastException -> println("ClassCastException")
                is IllegalArgumentException -> println("IllegalArgumentException")
                is NumberFormatException -> println("NumberFormatException")
                is IllegalStateException -> println("IllegalStateException")
                else -> println("Неизвестная ошибка")
            }
            throw t
        }
    }

////////////
// Создай свой тип исключения в отдельном файле.
// Исключение должно наследоваться от AssertionError и принимать текст в конструкторе.
// В main выброси созданное исключение.

    throw MyErr("Мой текст ошибки")

// Создать свой тип исключения в отдельном файле.
// Этот тип должен наследоваться от RuntimeException
// и принимать объект IndexOutOfBoundsException как аргумент конструктора.
// Далее нужно написать код, который специально вызывает IndexOutOfBoundsException,
// затем перехватывает его в блоке try-catch, выводит сообщение в консоль
// и выбрасывает собственное созданное исключение.

    try {
        val lst2 = listOf(1, 2, 3)
        println(lst2[10])
    } catch (e: IndexOutOfBoundsException) {
        println("Поймано исключение: $e")
        throw MyEx(e)
    }


}