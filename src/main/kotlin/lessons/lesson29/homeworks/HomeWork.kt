package org.example.lessons.lesson29.homeworks

import com.google.gson.GsonBuilder
import java.io.File

//Задание 1
//
//Создай дата класс сотрудника компании Employee, содержащий:
//- имя
//- статус трудоустройства (булево)
//- дата рождения (строка)
//- должность CharacterTypes
//- список подчинённых с типом Employee
//
//enum class CharacterTypes {
//   CTO,
//   UX_UI,
//   CRM, // Customer Relationship Manager
//   FRONTEND_DEV,
//   TEAM_LEAD,
//   BACKEND_DEV,
//   PM,
//   SYSADMIN,
//   QA
//}

enum class CharacterTypes {
    CTO,
    UX_UI,
    CRM,
    FRONTEND_DEV,
    TEAM_LEAD,
    BACKEND_DEV,
    PM,
    SYSADMIN,
    QA
}

data class Employee(
    val name: String,
    val isEmployed: Boolean,
    val birthDate: String,
    val position: CharacterTypes,
    val subordinates: List<Employee>
)

//Задание 2
//
//Создай объекты рабочей группы так, чтобы:
//- у CTO был PM и CRM
//- у PM было два тим-лида (на фронт и бэк)
//- у каждого тим-лида была группа сотрудников подходящего профиля

val frontendTeam = listOf(
    Employee("Alice", true, "1998-03-12", CharacterTypes.FRONTEND_DEV, emptyList()),
    Employee("Bob", true, "1997-07-22", CharacterTypes.UX_UI, emptyList())
)

val backendTeam = listOf(
    Employee("Charlie", true, "1995-11-02", CharacterTypes.BACKEND_DEV, emptyList()),
    Employee("Dave", true, "1994-01-18", CharacterTypes.SYSADMIN, emptyList()),
    Employee("Eve", true, "1996-06-30", CharacterTypes.QA, emptyList())
)

val frontendLead = Employee(
    "Frank",
    true,
    "1988-09-14",
    CharacterTypes.TEAM_LEAD,
    frontendTeam
)

val backendLead = Employee(
    "Grace",
    true,
    "1986-12-05",
    CharacterTypes.TEAM_LEAD,
    backendTeam
)

val pm = Employee(
    "Helen",
    true,
    "1985-04-20",
    CharacterTypes.PM,
    listOf(frontendLead, backendLead)
)

val crm = Employee(
    "Ivan",
    true,
    "1990-10-10",
    CharacterTypes.CRM,
    emptyList()
)

val cto = Employee(
    "Jack",
    true,
    "1980-02-01",
    CharacterTypes.CTO,
    listOf(pm, crm)
)

//Задание 3
//
//Создай функцию, в которой:
//- сериализуй CTO в текст с настройкой prettyPrinting
//- текст запиши в файл в корне проекта

fun saveCtoToJson() {
    val gson = GsonBuilder().setPrettyPrinting().create()
    val json = gson.toJson(cto)
    File("cto.json").writeText(json)
}

//Задание 4
//
//Создай функцию, в которой:
//- прочитай текст из файла
//- десериализуй его в объект класса Employee
//- распечатай в консоль

fun readCtoFromJson() {
    val gson = GsonBuilder().create()
    val json = File("cto.json").readText()
    val employee = gson.fromJson(json, Employee::class.java)
    println(employee)
}

fun main() {
    saveCtoToJson()
    readCtoFromJson()
}
