package org.example.lessons.lesson19.homework

class ListHolder<T> {
    val a = mutableListOf<T>()

    fun add(element: T) {
        a.add(element)
    }

    fun get(): List<T> {
        return a.toList()
    }
}