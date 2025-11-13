package org.example.lessons.lesson19.homework

interface Mapper<T,G> {
    fun transform(element: T):G
    fun transform(elements:List<T>):List<G>
}