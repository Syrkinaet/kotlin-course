package org.example.lessons.lesson14.homework

class Concert(
    val group: String,
    val place: String,
    val price: Double,
    val capacity: Int,
) {
    fun concertInfo() {
        println("Группа: $group, место проведения: $place, цена билета: $price, вместимость зала: $capacity")
    }

    private var soldTickets: Int = 0
    fun buyTicket() {
        soldTickets++
        println("кол-во проданных билетов: $soldTickets")
    }
}