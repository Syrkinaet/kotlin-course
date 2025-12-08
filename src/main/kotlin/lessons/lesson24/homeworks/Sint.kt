package org.example.lessons.lesson24.homeworks


class Sint {

    // 1 Создай функцию, которая:
    //принимает булево значение
    //принимает функцию, принимающую строку и ничего не возвращающую
    //возвращает целое число

    fun funcBool(a: Boolean, fnc: (String) -> Unit): Int {
        if (a) {
            return 10
        } else { return 20 }
    }

//    2 Создай функцию расширения целого числа, которая:
//принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
//возвращает список строк

//    fun Int.funcString2(str: String, Int.fnc: (String) -> List<String>): List<String> {
//    return this.fnc(str)
//}

//    3. Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
//принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
//возвращает второй дженерик

    fun <A, B> A.funn(todo: A.() -> B): B {
        return todo()
    }

//    4 Создай функцию, которая:
//принимает строку
//возвращает функцию, которая ничего не принимает и возвращает строку


    fun funcString(a: String): () -> String {
        return { a }
    }

//    5 Создай функцию расширяющую дженерик, которая:
//ничего не принимает
//возвращает функцию, принимающую строку и возвращающую дженерик

    fun <E> E.funGen(): (String) -> E {
        return { s: String -> this }
    }


//    6

    object Colors {
        const val RESET = "\u001B[0m"
        const val RED = "\u001B[31m"
        const val GREEN = "\u001B[32m"
        const val YELLOW = "\u001B[33m"
        const val BLUE = "\u001B[34m"
        const val PURPLE = "\u001B[35m"
        const val CYAN = "\u001B[36m"
        const val WHITE = "\u001B[37m"
    }

    fun String.colorize(color: String): String {
        return "$color$this${Colors.RESET}"
    }

    fun String.colorizeWords(fnc: (String) -> String) {
        val words = this.split(" ")
        words.forEach { word ->
            val col = fnc(word)
            print("$col ")
        }
    }

    val rule: (String) -> String = { word ->
        when {
            word.first().isUpperCase() -> word.colorize(Colors.BLUE)
            word.length < 3 -> word.colorize(Colors.RED)
            word.length > 6 -> word.colorize(Colors.GREEN)
            word.length % 2 == 0 -> word.colorize(Colors.YELLOW)
            else -> word.colorize(Colors.WHITE)
        }
    }

    // 2. Цвет слова выбирается по очереди из списка цветов, счётчик обнуляется
    fun poOchered(colors: List<String>): (String) -> String {
        var i = 0
        return { word ->
            val select = colors[i % colors.size]
            i++
            word.colorize(select)
        }
    }

    // 3. Цвет слова выбирается по очереди из списка цветов, счётчиком управляет изменяемая функция
    fun poOchSpisol(colors: List<String>): (String) -> String {
        var i = 0
        var kuda = 1

        val f: () -> Unit = {
            i++
            if (i >= colors.size) {
                i = colors.size - 2
                kuda = -1
            }
        }

        val d: () -> Unit = {
            i--
            if (i < 0) {
                i = 1
                kuda = 1
            }
        }
        var move: () -> Unit = f

        return { word ->
            val sel = colors[i]
            move()
            if (kuda == 1 && move != f) move = f
            if (kuda == -1 && move != d) move = d
            word.colorize(sel)
        }
    }
}