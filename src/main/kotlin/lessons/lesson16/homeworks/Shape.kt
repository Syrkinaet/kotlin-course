package org.example.lessons.lesson16.homeworks

abstract class Shape {
    open fun area(): Double = 0.0
}

class Circle(private val radius: Double) : Shape() {

    override fun area(): Double = kotlin.math.PI * radius * radius
}

class Square(private val side: Double) : Shape() {

    override fun area(): Double = side * side
}

class Triangle(
    private val a: Double,
    private val b: Double,
    private val c: Double
) : Shape() {

    override fun area(): Double {
        val p = (a + b + c) / 2
        return kotlin.math.sqrt(p * (p - a) * (p - b) * (p - c))
    }
}

fun main() {
    val shapes: List<Shape> = listOf(
        Circle(radius = 5.0),
        Square(side = 4.0),
        Triangle(a = 3.0, b = 4.0, c = 5.0)
    )

    shapes.forEach { shape ->
        println(shape.area())
    }
}
