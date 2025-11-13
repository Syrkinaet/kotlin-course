package org.example.lessons.lesson19.homework

fun main() {

    fun <A> getMiddleElement(list: List<A>): A? {
        if (list.size / 2 == 0) {
            return null
        }
        return list[list.size / 2]
    }

    fun <W, E> transposition(map: Map<W, E>): Map<E, W> {
        return map.map { it }.associate { it.value to it.key }

    }
}