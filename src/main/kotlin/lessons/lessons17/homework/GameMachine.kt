package org.example.lessons.lesson17.homework

class GameMachine(
    private val color: String,
    private val model: String,
    private var isOn: Boolean = false,
    private var isOsLoaded: Boolean = false,
    private val installedGames: MutableList<String> = mutableListOf(),
    private val hasJoystick: Boolean,
    private var earnedBalance: Double = 0.0,
    private val owner: String,
    private val supportPhone: String,
    private var isSessionPaid: Boolean = false,
    private val sessionCost: Double,
    private var pinCode: String
) {
    // Включить автомат
    fun turnOn() {
        if (!isOn) {
            isOn = true
            println("Автомат включён.")
        }
    }

    // Выключить автомат
    fun turnOff() {
        if (isOn) {
            isOn = false
            isOsLoaded = false
            println("Автомат выключен.")
        }
    }

    // Загрузить ОС
    fun loadOs() {
        if (isOn && !isOsLoaded) {
            isOsLoaded = true
            println("ОС загружена.")
        } else if (!isOn) {
            println("Сначала включите автомат.")
        }
    }

    // Завершить работу ОС
    fun shutdownOs() {
        if (isOsLoaded) {
            isOsLoaded = false
            println("ОС завершена.")
        }
    }

    // Показать список игр (копия, чтобы не нарушать инкапсуляцию)
    fun getGameList(): List<String> = installedGames.toList()

    // Включить игру (требует загруженной ОС и оплаты)
    fun startGame(gameName: String): Boolean {
        if (!isOsLoaded) {
            println("ОС не загружена.")
            return false
        }
        if (!isSessionPaid) {
            println("Сначала оплатите сеанс.")
            return false
        }
        if (gameName !in installedGames) {
            println("Игра '$gameName' не установлена.")
            return false
        }
        println("Запускаем игру: $gameName")
        isSessionPaid = false // сеанс использован
        return true
    }

    // Оплатить игровой сеанс
    fun paySession(amount: Double): Boolean {
        if (amount >= sessionCost) {
            isSessionPaid = true
            earnedBalance += sessionCost
            println("Сеанс оплачен.")
            return true
        } else {
            println("Недостаточно средств. Стоимость: $sessionCost")
            return false
        }
    }

    // Забрать наличные с помощью пин-кода
    fun withdrawCash(enteredPin: String): Double? {
        if (enteredPin == pinCode) {
            val amount = earnedBalance
            earnedBalance = 0.0
            println("Выдано: $amount")
            return amount
        } else {
            println("Неверный пин-код.")
            return null
        }
    }

    // Открыть сейф и выдать наличные (внутренний метод, только для владельца/сервиса)
    private fun openSafe(): Double {
        val amount = earnedBalance
        earnedBalance = 0.0
        return amount
    }
}