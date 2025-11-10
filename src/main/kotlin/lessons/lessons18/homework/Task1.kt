package org.example.lessons.lesson18.homework

import java.io.InputStream

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}
// Task 1
// Холодильник
abstract class Refrigerator : Powerable, Openable, TemperatureRegulatable, Cleanable

// Стиральная машина
abstract class WashingMachine : Powerable, Openable, WaterConnection, Drainable, TemperatureRegulatable, Timable, Cleanable

// Умная лампа
abstract class SmartLamp : Powerable, LightEmitting, Programmable


// Эл часы:
abstract class DigitalClock : Powerable, Timable

// Робот-пылесос
abstract class RoboVacuum : Powerable, Movable, BatteryOperated, Rechargeable, Cleanable, SoundEmitting, Programmable

// Механические часы
abstract class MechanicalClock : Mechanical, Timable

// Фонарик
abstract class Flashlight : Powerable, LightEmitting, BatteryOperated

// Кофемашина
abstract class CoffeeMachine : Powerable, WaterContainer, TemperatureRegulatable, Programmable, Cleanable

// Умная колонка
abstract class SmartSpeaker : Powerable, SoundEmitting, Programmable