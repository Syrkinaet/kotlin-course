package org.example.lessons.lesson18.homework

abstract class TemperatureOpenableDevice : ProgrammableDevice(), TemperatureRegulatable, Openable {
    override var maxTemperature: Int = 100 // базовое значение

    protected var currentTemperature: Int = 0
    protected var isOpened = false

    override fun open() {
        isOpened = true
        println("Устройство открыто.")
    }

    override fun close() {
        isOpened = false
        println("Устройство закрыто.")
    }

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn) {
            println("Нельзя установить температуру: устройство выключено.")
            return
        }
        if (temp < 0 || temp > maxTemperature) {
            println("Недопустимая температура: $temp°C. Диапазон: 0–$maxTemperature°C.")
            return
        }
        currentTemperature = temp
        println("Температура установлена: $temp°C")
    }
}