package org.example.lessons.lesson19.homework

class ListValidator<Y : Number> : Validator<List<Y?>> {
    override fun validation(element: List<Y?>): Boolean {
        return element.all { it != null && it.toDouble() != 0.0 }

    }
}