package org.example.lessons.lesson08.homework

fun main() {
    string1("Это невозможно выполнить за один день")
    string1("Я не уверен в успехе этого проекта")
    string1("Произошла катастрофа на сервере")
    string1("Этот код работает без проблем")
    string1("Удача")
    string2("Пользователь вошел в систему -> 2021-12-01 09:48:23")
    string3("4539 1488 0343 6467")
    string4("username@example.com")
    string5("D:/good.themes/dracula.theme")
    string6("Котлин лучший язык программирования")
    string7("Котлин лучший язык программирования")
}
// Преобразование строк
fun string1(arg: String) {
    if (arg.contains("невозможно")) {
        val newString = arg.replace("невозможно", "совершенно точно возможно, просто требует времени")
        println(newString)
    } else if (arg.startsWith("Я не уверен")) {
        val newString = "$arg, но моя интуиция говорит об обратном"
        println(newString)
    } else if (arg.contains("катастрофа")) {
        val newString = arg.replace("катастрофа", "интересное событие")
        println(newString)
    } else if (arg.endsWith("без проблем")) {
        val newString = arg.replace("без проблем", "с парой интересных вызовов на пути")
        println(newString)
    } else if (!(arg.contains(" "))) {
        val newString = "Иногда, $arg, но не всегда"
        println(newString)
    }
}

// Извлечение даты из строки лога
fun string2(arg: String) {
    val indexOfSub = arg.indexOf("-> ")
    val timeOffset = arg.substring(indexOfSub+3)
    val date = timeOffset.substring(0,10)
    val time = timeOffset.substring(11)
    println(date)
    println(time)
}

// Маскирование личных данных
fun string3(arg: String) {
    val card = arg.replace(" ", "")
    val maskCard = card.replace(card.substring(0,12),"*".repeat(12))
    println(maskCard)
}

// Форматирование адреса электронной почты.
fun string4(arg: String) {
    val at = arg.replace("@", " [at] ")
    val dot = at.replace(".", " [dot] ")
    println(dot)
}

//Извлечение имени файла из пути.
fun string5(arg: String) {
    val fileName = arg.substringAfterLast("/")
    println(fileName)
}

//Создание аббревиатуры из фразы.
fun string6(arg: String) {
    val words = arg.split(" ")
    var counter = ""
    for (word in words) {
        val firstS = word[0].uppercase()
        counter += firstS
    }
    println(counter)
}

// Все слова с большой буквы
fun string7(arg: String) {
    val words = arg.split(" ")
    for (word in words) {
        val lenW = word.length
        var slovo = ""
        val firstS = word[0].uppercase()
        for (i in 1 until lenW) {
            val bukva = word[i].lowercase()
            slovo += bukva
        }
        val fullS = firstS + slovo
        val fullFrace = fullS + " "
        print(fullFrace)
    }
}