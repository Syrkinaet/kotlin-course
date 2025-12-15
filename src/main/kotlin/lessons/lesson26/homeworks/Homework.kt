package org.example.lessons.lesson26.homeworks

import java.io.File

//Задача 1
//Создайте текстовый файл workspace/task1/example.txt. Запишите в него строку "Hello, Kotlin!", а затем проверьте,
// существует ли файл. Реши задачу с использованием scope функции без создания переменной.
fun task1() {
    File(".workspace/task1/example.txt").apply {
        parentFile?.mkdirs()
        createNewFile()
        writeText("Hello, Kotlin!")
        if (exists()) {
            println("File exists")
        } else {
            println("File not exists")
        }
    }
}
//Задача 2
//Создайте директорию workspace/task2/testDir. Проверьте, является ли она директорией, и выведите её абсолютный путь.
fun ex2() {
    File("workspace/task2/testDir").apply {
        mkdirs()
        if (isDirectory) {
            println("Это директория")
        } else {
            println("Это не директория")
        }
        println(absolutePath)
    }
}

//Задача 3
//Создайте директорию workspace/task3/structure. Внутри директории structure создайте папку myDir с двумя вложенными
// поддиректориями subDir1 и subDir2. Проверьте, что myDir действительно содержит эти поддиректории. Используй scope
// функции для минимизации создания переменных а так же метод file.resolve("myDir") для создания нового объекта File
// путём добавления к существующему пути ещё одной секции. И так же для других директорий.
fun ex3() {
    with(File("workspace/task3/structure")) {
        mkdirs()
        resolve("myDir")
    }.apply {
        mkdir()
        resolve("subDir1").mkdir()
        resolve("subDir2").mkdir()
        val files = list()
        if (files?.all { it.contains("subDir1") || it.contains("subDir2") } ?: false) {
            println("Директории найдены")
        } else {
            println("Директории не найдены в ${list().joinToString()}")
        }
    }
}

//Задача 4
//Создайте директорию workspace/task4/temp. Внутри директории temp создайте несколько вложенных файлов и директорий.
// Удалите директорию workspace/task4 со всем содержимым
fun ex4() {
    File("workspace/task4/temp").apply {
        mkdirs()
        mapOf(
            "dir1" to true,
            "file1" to false,
            "dir2" to true,
            "dir3" to true,
            "file2" to false,
            "file3" to false
        ).forEach { (name, isDirectory) ->
            resolve(name).also {
                if (isDirectory) {
                    it.mkdir()
                } else {
                    it.createNewFile()
                }
            }
        }
        check(list() != null && list()!!.size == 6) { "Список файлов и директорий не полный ${list()?.joinToString()}" }
        parentFile.deleteRecursively()
    }
    check(!File("workspace/task4").exists())
}

//Задача 5
//Создайте файл workspace/task5/config/config.txt. запишите в него список параметров (в формате ключ=значение), а затем
// прочитайте файл и выведите только значения.
fun ex5() {
    with(File("workspace/task5/config/config.txt")) {
        parentFile.mkdirs()
        createNewFile()
        listOf("param 1 = true", "param 2 = false").also {
            writeText(it.joinToString("\n"))
        }
        readLines().map {
            it.split("=")
                .getOrNull(1)
                ?.trim() ?: ""
        }.also {
            println(it.joinToString())
        }
    }
}

//Задача 6
//Пройди по всем вложенным директориям workspace и выведи в консоль сначала пути директорий, а потом пути файлов
fun ex6() {
    File("workspace").apply {
        walk().groupBy { if (it.isDirectory) "dir" else "file" }
            .also {
                println("Directories")
                println(it["dir"]?.joinToString("\n"))
                println("Files")
                println(it["file"]?.joinToString("\n"))
            }
    }
}

//Задача 7
//Создайте директорию workspace/task7/docs. Проверь, есть ли файл с именем readme.md. Если файла нет, создайте его и
// запишите текст "This is a README file.". Проверьте текст в файле.
fun ex7() {
    val phrase = "This is a README file."
    File("workspace/task7/docs/readme.md").apply {
        parentFile?.mkdirs()
        if (!this.exists()) {
            createNewFile()
            writeText(phrase)
        }
        check(readText() == phrase)
    }
}

//Задача 8
//Создайте файлы
//workspace/task8/data/1/4/prod/data14.mysql
//workspace/task8/data/2/3/prod/data23.mysql
//workspace/task8/data/5/2/prod/data52.mysql
//Создайте директорию workspace/task8/backup и скопируйте туда файлы из workspace/task8/data сохраняя структуру директорий.
// Для копирования используй метод copyTo. Для получения относительного пути начиная от data используй relativeTo от пути
// до файла, передавая в него путь до базовой директории (то-есть data). Полученный relative фрагмент можно присоединить
// к пути бэкапа через resolve и таким образом получить путь назначения копирования,
// например workspace/task8/backup/1/4/prod/data14.mysql сохраняя весь относительный путь.
fun ex8() {
    File("workspace/task8").deleteRecursively()
    listOf(
        "workspace/task8/data/1/4/prod/data14.mysql",
        "workspace/task8/data/2/3/prod/data23.mysql",
        "workspace/task8/data/5/2/prod/data52.mysql",
    ).forEach {
        File(it).apply {
            parentFile?.mkdirs()
        }.createNewFile()
    }
    val backup = File("workspace/task8/backup").also { it.mkdirs() }
    File("workspace/task8/data").apply {
        walk().filter { it.isFile }
            .forEach {
                val relative = it.relativeTo(this)
                it.copyTo(backup.resolve(relative))
            }
    }
}
