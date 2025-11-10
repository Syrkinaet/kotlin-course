package org.example.lessons.lesson18.homework

abstract class ProgrammableDevice : PowerableDevice(), Programmable {
    private var currentProgram: String? = null

    override fun programAction(action: String) {
        if (!isPoweredOn) {
            println("Нельзя задать программу: устройство выключено.")
            return
        }
        currentProgram = action
        println("Задана программа: $action")
    }

    override fun execute() {
        if (!isPoweredOn) {
            println("Нельзя выполнить программу: устройство выключено.")
            return
        }
        if (currentProgram != null) {
            println("Выполняется программа: $currentProgram")
        } else {
            println("Программа не задана.")
        }
    }
}