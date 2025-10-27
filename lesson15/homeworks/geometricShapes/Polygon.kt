package org.example.lessons.lesson15.homeworks.geometricShapes

open class Polygon(
    color: String,
    border: Boolean,
    name: String,
    val numberOfCorners: Int,
    val sides: List<Int>
): GeometricShape(color, border, name) {

    open fun getPerimeter() {
        println("Периметр = ${sides.sum()}")
    }
}