package org.example.lessons.lesson15.homeworks.geometricShapes

class Quadrilateral(
    color: String,
    border: Boolean,
    name: String,
    numberOfCorners: Int,
    sides: List<Int>
) : Polygon(color, border, name, numberOfCorners, sides) {
}