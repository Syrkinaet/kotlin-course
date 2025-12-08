package org.example.lessons.lesson25.homeworks

import org.example.lessons.lesson25.homeworks.Employee

class Person(val name: String, val age: Int) {
    var email: String = ""



}
fun main() {
    fun printPerson(person: Person) {
        println("---Печатаем Perosn---")
        with(person) {
            println("Имя: $name")
            println("Возраст: $age")
            println("Email: $email")
        }
        println("--Конец--")
    }

    val person = Person("Оля", 31)

    person.also {
        it.email = "olya@ya.com"
        printPerson(it)
    }

    val person4 = Person("Person из задания 4", 41)
    val employee4 = with(person4) {
        Employee(name, age, "Старший дворник").apply {
            email = "person4@ya.com"
            department = "Управление"
        }
    }

    val employee5: Employee = person.run {
        Employee(
            name = name,
            age = age,
            position = "Младший дворник"
        ).apply {
            email = this@run.email
            department = "Дворники"
        }
    }

    fun Person?.toEmployee(position: String, department: String): Employee? {
        return this?.let { person ->
            Employee(
                name = person.name,
                age = person.age,
                position = position
            ).apply {
                email = person.email
                this.department = department
            }
        }

    }
    }


