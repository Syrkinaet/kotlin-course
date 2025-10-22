package org.example.lessons.lesson14.homework

fun main() {
    val party = Party("Москва", 16)
    party.details()

    val emotion = Emotion("Счастье", 10)
    emotion.express()

    Moon.showPhase(false, "Полная луна")

    val product = Product("Колбаса", 200.11, 2)
    product.example()

    val concert = Concert("The Rasmus", "Moscow", 3500.10, 1000)
    concert.concertInfo()
    concert.buyTicket()
    concert.buyTicket()
    concert.buyTicket()

    val shelf0 = Shelf(30)
    println("Добавление первого предмета: " + shelf0.addItem("пирожок"))
    println("Добавление второго предмета: " + shelf0.addItem("тортик"))
    println("Получение всего списка предметов: " + shelf0.getItems())
    println("Удаление предмета:" + shelf0.removeItem("пирожок"))
    println("Получение всего списка предметов: " + shelf0.getItems())
    println("Проверка влезания предмета: " + shelf0.canAccommodate("кусочек шашлыка"))
    println("Есть ли на полке предмет: " + shelf0.containsItem("тортик"))
    println("Добавление третьего предмета: " + shelf0.addItem("кусочек шашлыка"))

    val shelf1 = Shelf(5)
    val shelf2 = Shelf(5)
    val shelf3 = Shelf(15)
    val shelf4 = Shelf(20)
    val shelf5 = Shelf(25)
    val rack = Rack(10)
    println(rack.addShelf(shelf0))
    println(rack.addShelf(shelf1))
    println(rack.addShelf(shelf2))
    println(rack.addShelf(shelf3))
    println(rack.addShelf(shelf4))
    println(rack.addShelf(shelf5))
    println(rack.addItem("lsshoxwfwefwfwfwwfwfwfwefewfwefwef"))
    println(rack.removeShelf(2))
    println(rack.removeItem("lsshoxwfwefwfwfwwfwfwfwefewfwefwef"))
    println(rack.containsItem("тортик"))
    println(rack.getShelves())
    println(rack.printContents())
    println(rack.advancedRemoveShelf(0))
    println(rack.printContents())


}

