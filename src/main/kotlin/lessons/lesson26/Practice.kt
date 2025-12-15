package org.example.lessons.lesson26

import java.io.File
import java.io.FileNotFoundException

//Задание 1: Создание файла или директории
//Напишите функцию createFileOrDirectory, которая принимает путь в виде строки и создает файл или директорию в
// зависимости от того, заканчивается ли путь на "/".
fun createFileOrDirectory(path: String) {
    val file = File(path)
    file.parentFile?.mkdirs()
    if (path.endsWith("/")) {
        file.mkdir()
    } else {
        file.createNewFile()
    }
}
//Задание 2: Создание всех вложенных директорий и файла
//Напишите функцию createNestedDirectoriesAndFile, которая принимает путь к файлу, включая несуществующие директории.
// Функция должна создать все необходимые директории и файл по указанному пути.
fun createNestedDirectoriesAndFile(path: String) {
    val file = File(path)
    file.parentFile?.mkdirs()
    file.createNewFile()
}
//Задание 3: Запись данных в файл
//Напишите функцию writeDataToFile, которая принимает путь к файлу и объект Map<String, Double>. Функция должна записать
// данные из словаря в файл, форматируя их в виде текста разделяя ключи и значения символом =.
fun writeDataToFile(path: String, data: Map<String, Double>) {
    createNestedDirectoriesAndFile(path)
    data.map { "${it.key}=${it.value}" }
        .joinToString("\n")
        .also { File(path).writeText(it) }
}
//Задание 4: Чтение данных из файла и парсинг данных в объект словаря
//Напишите функцию readDataFromFileToMap, которая читает данные из файла, где ключи и значения разделены знаком ‘=’, и
// возвращает их в виде словаря String, Double.
fun readDataFromFileToMap(path: String): Map<String, Double> {
    val file = File(path)
    return file.readLines()
        .map { line -> line.split("=").map { it.trim() } }
        .associate { it[0] to (it.getOrNull(1)?.toDoubleOrNull() ?: 0.0) }
}
//Задание 5: Удаление файла
//Напишите функцию deleteFile, которая принимает путь к файлу и ключевую фразу и удаляет файл только в том случае,
// если в файле не содержится ключевая фраза
fun deleteFile(path: String, key: String) {
    val file = File(path)
    val data = file.readText()
    if (!data.contains(key)) {
        file.delete()
    }
}

//Задание 6: Удаление директории и всех вложенных директорий и файлов
//Напишите код, который создаёт файл и все родительские директории в длинном пути,
// например "super/very/long/path/to/some/unimportant/file/something.txt", а так же удаляет папку "super" со всем содержимым.
fun main() {
    val longPathFile = File("super/very/long/path/to/some/unimportant/file/something.txt")
    longPathFile.parentFile?.mkdirs()
    longPathFile.createNewFile()
    File("super").deleteRecursively()
}
//Задание 7: Поиск списка файлов по части имени с преобразованием файлов в их содержимое
//Напишите функцию findFilesByPartOfName, которая принимает начальную директорию и часть имени файла. Функция должна
// искать все подходящие файлы и возвращать список, содержащий содержимое каждого найденного файла.
fun findFilesByPartOfName(startPath: String, partOfName: String): List<String> {
    return File(startPath).walk()
        .filter { it.name.contains(partOfName) }
        .map { it.readText() }
        .toList()
}
//Задание 8: Копирование файла
//Напиши функцию расширения строки copyTo, которая принимает путь - назначение для копирования файла. Функция должна
// взять из текущей строки путь, проверить что он существует и выполнить копирование в новое расположение, полученное из
// аргумента функции. Если пути нет - выбросить исключение FileNotFoundException.
fun String.copyTo(target: String) {
    val file = File(this)
    if (!file.exists()) {
        throw FileNotFoundException("Файл $this не найден")
    }
    file.copyTo(File(target))
}
