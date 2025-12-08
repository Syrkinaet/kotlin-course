package org.example.lessons.lesson25.homeworks

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}

val new = Employee("Sam", 45, "Дворник").apply {
    email = "sam@dvorniki.com"
    department = "Рабочие"
}
