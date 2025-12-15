package org.example.lessons.lesson26

import java.io.File

fun main() {

//Создание объекта File
    val file = File("path/to/your/file.txt")
    val directory = File("path/to/your/directory")

//Проверка существования файла или директории
    if (file.exists()) {
        println("Файл существует")
    } else {
        println("Файл не найден")
    }

//Создание нового файла
//Чтобы создать новый файл, используйте метод createNewFile(). Этот метод вернёт true, если файл был успешно создан,
// и false, если файл уже существует:

    val isNewFileCreated: Boolean = file.createNewFile()
    if (isNewFileCreated) {
        println("Файл был создан")
    } else {
        println("Файл уже существует")
    }
//Обратите внимание: если путь к файлу включает несуществующие директории, createNewFile() выбросит исключение.
// Убедитесь, что все родительские директории существуют.
//Для решения этой проблемы можно перманентно использовать следующий сниппет:
    file.parentFile.mkdirs()
    file.createNewFile()

//Чтение и запись файла
    file.writeText("Hello, world!")

//Чтение всего текста из файла:
    val text = file.readText()
    println(text)

//Работа с директориями
//Создание директории:
    val isDirectoryCreated: Boolean = directory.mkdir()
    if (isDirectoryCreated) {
        println("Директория была создана")
    } else {
        println("Не удалось создать директорию")
    }

//Получение списка файлов в директории:
    val files = directory.listFiles()
    files?.forEach { file ->
        println(file.name)
    }

//Удаление файла или директории
    if (file.delete()) {
        println("Файл удален")
    } else {
        println("Не удалось удалить файл")
    }

//Удаление директории возможно только, если она пуста. Для удаления непустой директории со всеми файлами и поддиректориями
// можно использовать следующий метод:
    if (file.deleteRecursively()) {
        println("Директория и всё её содержимое удалено")
    } else {
        println("Не удалось удалить директорию")
    }

//Поиск файлов и директорий
//Для рекурсивного перебора директорий и файлов применяется метод walk() который предоставляет последовательность
// sequence которую можно фильтровать и преобразовывать так, как это нужно.

    fun searchFilesUsingWalk(startDir: String, query: String): List<String> {
        return File(startDir)
            .walk() // Рекурсивный обход файлов и директорий начиная с startDir
            .filter { it.isFile && it.name.contains(query, ignoreCase = true) } // Фильтрация по имени файла
            .map { it.absolutePath } // Преобразование результатов в абсолютные пути
            .toList() // Сбор результатов в список
    }

//Дополнительные методы для работы с файлами в Kotlin
//absoluteFile Возвращает абсолютный путь к файлу в виде объекта File.
    val filee = File("path/to/file.txt")
    println(filee.absoluteFile) // Вывод: /absolute/path/to/file.txt

//isFile Проверяет, является ли объект файлом.
    val file2 = File("path/to/file.txt")
    println(file2.isFile) // Вывод: true, если объект - файл

//name Возвращает имя файла или директории.
    val file3 = File("/path/to/file.txt")
    println(file3.name) // Вывод: file.txt

//parent Возвращает строку с путем к родительской директории.
    val file4 = File("/path/to/file.txt")
    println(file4.parent) // Вывод: /path/to

//parentFile Возвращает объект File, указывающий на родительскую директорию.
   val file5 = File("/path/to/file.txt")
    println(file5.parentFile) // Вывод: объект File для /path/to

//copyTo Копирует файл в указанное местоположение.
    val sourceFile = File("/path/to/source.txt")
    val destinationFile = File("/path/to/destination.txt")
    sourceFile.copyTo(destinationFile, overwrite = true) // Копирует файл, перезаписывая его при необходимости

//toRelativeString Возвращает относительный путь от одного File к другому.
    val baseDir = File("/path/to")
    val file6 = File("/path/to/nested/file.txt")
    println(file6.toRelativeString(baseDir)) // Вывод: nested/file.txt

    // walk Выполняет рекурсивный перебор всех файлов директории, предоставляя их как поток, с которым можно работать как с обычными списками
    val file7 = File("path/to/file")
    file7.walk().filter { it.isFile }
        .associate { it.name to it.readLines() }
        .filterValues { data ->
            data.any { it.contains("text") }
        }
}
