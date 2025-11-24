package org.example.lessons.lesson22
fun main() {

    throw Exception("Сообщение об ошибке")

// можно выкидывать исключение из переменной
    val exception = Exception("Сообщение об ошибке")
    throw exception

/////////

    try {
        // Код, который может выбросить исключение
    } catch (e: SpecificException) {
        // Обработка конкретного типа исключения
    } catch (e: Exception) {
        // Обработка всех остальных исключений
    } finally {
        // Блок, который выполняется всегда, независимо от наличия исключения
    }

//////////////

    try {
        // Код, который может выбросить исключения
    } catch (e: Exception) {
        when(e) {
            is IndexOutOfBoundsException -> {
                println("Обработано исключение типа IndexOutOfBoundsException")
            }
            is RuntimeException -> {
                println("Обработано исключение типа RuntimeException")
            }
            else -> throw e // Перебрасываем исключение дальше, если оно не соответствует обработанным типам
        }
    }

///////////////

    fun placeOrder(orderDetails: String) {
        if (orderDetails.isBlank()) {
            throw OrderException("Детали заказа не указаны.")
        }
        // Логика оформления заказа
        println("Заказ оформлен: $orderDetails")
    }

    fun main() {
        try {
            placeOrder("") // Попытка оформить заказ с пустыми деталями
        } catch (e: OrderException) {
            println("Ошибка при оформлении заказа: ${e.message}")
        }
    }


}

//////////////

class OrderException(message: String) : RuntimeException(message)


class CustomException : RuntimeException {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)
}