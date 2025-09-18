package org.example.`kotlin-course`.lessons.lesson05.homework

fun main() {
    /* Задача 1
    Контекст: Вы изучаете физическое явление затухания звука в помещении. У вас есть измеренное значение начальной интенсивности звука, но из-за ограничений оборудования данные о коэффициенте затухания иногда могут быть неизвестны.
    Задача: Рассчитать предполагаемую интенсивность звука после затухания. Интенсивность звука после затухания пропорциональна начальной интенсивности, умноженной на коэффициент затухания. Если коэффициент затухания неизвестен, использовать стандартное значение 0.5. */
    var baseIntensity: Double = 10.0
    var coefficient: Double? = 0.73 // но может быть null
    val baseCoefficient = 0.5
    var resultIntensity = baseIntensity * (coefficient ?: baseCoefficient)
    println(resultIntensity)


    /* Задача 2

    Контекст: Клиент оплачивает доставку груза. К стоимости доставки добавляется страховка на груз, которая составляет 0,5% от его стоимости. В случае, если стоимость не указана, то берётся стандартная стоимость в $50
    Задача: Рассчитать полную стоимость доставки. */
    var deliveryCost: Double = 20.0
    val ensurancePersantage: Double = 0.005
    val standardCost: Double = 50.0
    var cost: Double? = null
    var ensuranceCost: Double = (cost ?: standardCost) * ensurancePersantage
    var finalDeliveryCost: Double = ensuranceCost + deliveryCost
    println(finalDeliveryCost)


    /*Задача 3

    Контекст: Вы проводите метеорологические измерения. Одним из важных показателей является атмосферное давление, которое должно быть зафиксировано. Лаборант приносит вам набор показателей, но по пути может что-нибудь потерять. Задача - сообщить об ошибке в случае отсутствия показаний атмосферного давления.*/
    val pressure: String? = null
    val lostMessage = "Pressure is lost"
    val pressureChecking = pressure ?: lostMessage
    println(pressureChecking)
}