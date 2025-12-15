package org.example.lessons.lesson27.homeworks

//Задание 1
//Создай Enum со статусами прохождения теста (passed, broken, failed).
//Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.
//Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.
enum class Status {
    PASSED,
    BROKEN,
    FAILED,
}
enum class RealEstate(val value: String) {
    ROOM("Комната"),
    APARTMENT("Квартира"),
    HOUSE("Дом"),
    GARAGE("Гараж"),
    NON_RESIDENTAL_PREMISES("Нежилая недвижимость"),
}
enum class Planet(
    val distanceAu: Double,   // расстояние до Солнца в а.е.
    val massKg: Double        // масса в кг
) {
    MERCURY(0.39, 3.30e23),
    VENUS(0.72, 4.87e24),
    EARTH(1.00, 5.97e24),
    MARS(1.52, 6.42e23),
    JUPITER(5.20, 1.90e27),
    SATURN(9.58, 5.68e26),
    URANUS(19.20, 8.68e25),
    NEPTUNE(30.05, 1.02e26)
}

//Задание 2
//Создай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке возрастания длины названия enum.
fun ex2() {
    println(RealEstate.entries.sortedBy { it.name.length })
}

//Задание 3
//Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает Enum со статусом
// прохождения теста в зависимости от того как выполнится принятая лямбда:
//если без исключений - PASSED
//если будет AssertionError - FAILED
//прочие исключения  - BROKEN
fun test(fnc: () -> Unit): Status {
    return try {
        fnc()
        Status.PASSED
    } catch (e: AssertionError) {
        Status.FAILED
    } catch (e: Throwable) {
        Status.BROKEN
    }
}

//Задание 4
//Создай функцию, которая принимает лямбду и возвращает enum планеты. Лямбда должна принимать планету и возвращать
// булево значение. Лямбда здесь выступает в качестве фильтра, который должен отфильтровать список всех планет по
// какому-либо признаку (расстояние или вес). Вернуть нужно первый элемент из отфильтрованного списка или выкинуть
// исключение если список пустой.
fun ex4(fnc: (Planet) -> Boolean): Planet {
    return Planet.entries
        .firstOrNull(fnc)
        ?: throw RuntimeException("Подходящей планеты не найдено")
}
