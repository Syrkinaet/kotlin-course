package org.example.lessons.lesson15.homeworks.furniture

class Table(
    name: String,
    material: String,
    color: String,
    val size: String
) : Kitchen(name, material, color) {
}