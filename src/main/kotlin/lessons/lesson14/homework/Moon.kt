package org.example.lessons.lesson14.homework

object Moon {
    fun showPhase(isVisible: Boolean, phase: String) {
        if (isVisible) {
            println(phase)
        } else {
            println("Луна не видна")
        }
    }
}
