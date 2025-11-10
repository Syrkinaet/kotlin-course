package org.example.lessons.lesson18.homework

abstract class PowerableDevice : Powerable {
    protected var isPoweredOn = false

    override fun powerOn() {
        if (!isPoweredOn) {
            println("Устройство включено.")
            isPoweredOn = true
        } else {
            println("Устройство уже включено.")
        }
    }

    override fun powerOff() {
        if (isPoweredOn) {
            println("Устройство выключено.")
            isPoweredOn = false
        } else {
            println("Устройство уже выключено.")
        }
    }
}