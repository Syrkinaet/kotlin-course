package org.example.lessons.lesson16.homeworks

abstract class Printer {
    abstract fun print(text: String)
}

class LaserPrinter : Printer() {
    override fun print(text: String) {
        val words = text.split(' ')
        for (word in words) {
            println("\u001b[30m\u001b[47m $word \u001b[0m") // чёрный текст, белый фон
        }
    }
}

class InkjetPrinter : Printer() {
    private val colorPairs = listOf(
        "\u001b[31m\u001b[47m", // красный текст, белый фон
        "\u001b[34m\u001b[43m", // синий текст, жёлтый фон
        "\u001b[93m\u001b[46m"  // бежевый текст, голубой фон
    )

    override fun print(text: String) {
        val words = text.split(' ')
        for ((index, word) in words.withIndex()) {
            val colorCode = colorPairs[index % colorPairs.size]
            println("$colorCode $word \u001b[0m")
        }
    }
}

fun main() {
    val laserPrinter = LaserPrinter()
    val inkjetPrinter = InkjetPrinter()

    val longText = "Это очень длинный тестовый текст для проверки работы струйного и лазерного принтеров " +
            "в условиях реальной печати с большим количеством слов и разнообразных символов " +
            "для демонстрации циклического применения цветов и корректного разбиения на слова."

    laserPrinter.print(longText)

    inkjetPrinter.print(longText)
}