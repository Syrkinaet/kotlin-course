package org.example.lessons.lesson15.homeworks.educationalEstablishments

class Department(
    name: String,
    yearOfFoundation: Int,
    rating: Double,
    val directions: MutableList<String>
) : Institute(name, yearOfFoundation, rating) {
}