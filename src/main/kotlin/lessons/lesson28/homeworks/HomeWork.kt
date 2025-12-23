package org.example.lessons.lesson28.homeworks

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

/*
Задача 1
Создай текущую метку времени и выведи её на печать (чтобы ещё раз запомнить название этого класса)
*/
val currentTimestamp: Instant = Instant.now()
println(currentTimestamp)

/*
Задача 2
Создай дату своего дня рождения
*/
val birthday: LocalDate = LocalDate.of(1981, 4, 9)
println(birthday)

/*
Задача 3
Создай период между датой своего рождения и текущей датой.
Выведи на печать количество лет из этого периода
*/
val period: Period = Period.between(birthday, LocalDate.now())
println(period.years)

/*
Задача 4
Создай функцию, которая принимает тип Temporal и выводит форматированное значение
в зависимости от того, содержит ли аргумент время и часовой пояс.
Реализуй два варианта функции:
1) с собственным форматированием
2) с форматированием из ISO коллекции
*/
fun formatTemporalCustom(temporal: Temporal): String =
    when (temporal) {
        is LocalDateTime -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        is LocalDate -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        is LocalTime -> temporal.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        is ZonedDateTime -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"))
        is OffsetDateTime -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss XXX"))
        is Instant -> temporal.toString()
        else -> temporal.toString()
    }

fun formatTemporalIso(temporal: Temporal): String =
    when (temporal) {
        is LocalDateTime -> DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(temporal)
        is LocalDate -> DateTimeFormatter.ISO_LOCAL_DATE.format(temporal)
        is LocalTime -> DateTimeFormatter.ISO_LOCAL_TIME.format(temporal)
        is ZonedDateTime -> DateTimeFormatter.ISO_ZONED_DATE_TIME.format(temporal)
        is OffsetDateTime -> DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(temporal)
        is Instant -> DateTimeFormatter.ISO_INSTANT.format(temporal)
        else -> temporal.toString()
    }

/*
Задача 5
Создай объекты дат и / или времени, которые мы изучили,
и по очереди передай их в метод форматирования.
Не используй метод now()
*/
val localDate: LocalDate = LocalDate.of(2020, 1, 10)
val localTime: LocalTime = LocalTime.of(14, 30, 15)
val localDateTime: LocalDateTime = LocalDateTime.of(2021, 5, 20, 18, 45, 30)
val zonedDateTime: ZonedDateTime =
    ZonedDateTime.of(2022, 8, 1, 12, 0, 0, 0, ZoneId.of("Europe/Paris"))
val offsetDateTime: OffsetDateTime =
    OffsetDateTime.of(2023, 3, 10, 9, 15, 0, 0, ZoneOffset.ofHours(3))

listOf(
localDate,
localTime,
localDateTime,
zonedDateTime,
offsetDateTime
).forEach {
    println(formatTemporalCustom(it))
    println(formatTemporalIso(it))
}

/*
Задача 6
Создай функцию identifyGeneration, которая расширяет класс LocalDate и печатает строку,
определяющую поколение человека:
"Бумер" — 1946–1964
"Зумер" — 1997–2012
"Не определено" — остальные даты
*/
private val BOOMER_START: LocalDate = LocalDate.of(1946, 1, 1)
private val BOOMER_END: LocalDate = LocalDate.of(1964, 12, 31)
private val ZOOMER_START: LocalDate = LocalDate.of(1997, 1, 1)
private val ZOOMER_END: LocalDate = LocalDate.of(2012, 12, 31)

fun LocalDate.identifyGeneration() {
    when {
        this in BOOMER_START..BOOMER_END -> println("Бумер")
        this in ZOOMER_START..ZOOMER_END -> println("Зумер")
        else -> println("Не определено")
    }
}

birthday.identifyGeneration()

/*
Задача 7
Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года.
Создай форматтер, который форматирует дату в месяц и день
*/
val date2023: LocalDate = LocalDate.of(2023, 2, 25)
val date2024: LocalDate = LocalDate.of(2024, 2, 25)
val monthDayFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd")

/*
Задача 8
Выведи первую дату, прибавив к ней 10 дней, в отформатированном виде
*/
println(date2023.plusDays(10).format(monthDayFormatter))

/*
Задача 9
Выведи вторую дату, прибавив к ней 10 дней, в отформатированном виде
*/
println(date2024.plusDays(10).format(monthDayFormatter))
```
