package org.example.lessons.lesson29.homeworks

//GSON — это популярная библиотека от Google для работы с JSON в Java и Kotlin. Она позволяет легко преобразовывать объекты в JSON (сериализация) и JSON в объекты (десериализация). Давайте познакомимся с основами её использования.
//
//Подключение библиотеки
//Для использования GSON в проекте, добавьте зависимость в файл build.gradle:

dependencies {
    implementation("com.google.code.gson:gson:2.10.1") // Убедитесь, что версия актуальная
}

//После добавления зависимости выполните синхронизацию проекта.
//
//Дата-класс с несколькими полями
//Пример дата-класса, содержащего поля разных типов, включая вложенный объект:

data class Address(
    val street: String,
    val city: String,
    val postalCode: Int
)
data class User(
    val id: Int,
    val name: String,
    val isActive: Boolean,
    val address: Address
)

//Примеры сериализации и десериализации
//Сериализация: объект → JSON

import com.google.gson.Gson

fun main1() {
    val address = Address("Baker Street", "London", 221)
    val user = User(1, "Sherlock Holmes", true, address)
    val gson = Gson() // Создаём экземпляр Gson
    val json = gson.toJson(user) // Сериализация объекта
    println("JSON: $json")
}

//Вывод:

JSON: {"id":1,"name":"Sherlock Holmes","isActive":true,"address":{"street":"Baker Street","city":"London","postalCode":221}}

//Десериализация: JSON → объект

fun main2() {
    val json = """{"id":1,"name":"Sherlock Holmes","isActive":true,"address":{"street":"Baker Street","city":"London","postalCode":221}}"""
    val gson = Gson()
    val user = gson.fromJson(json, User::class.java) // Десериализация JSON в объект
    println("User: $user")
}

//Вывод:

User: User(id=1, name=Sherlock Holmes, isActive=true, address=Address(street=Baker Street, city=London, postalCode=221))

//Использование аннотаций для изменения имени поля
//Иногда имена полей в JSON не совпадают с именами свойств объекта. GSON позволяет решить эту проблему с помощью аннотации @SerializedName.

import com.google.gson.annotations.SerializedName

data class UserWithAlias(
    @SerializedName("user_id") val id: Int,
    @SerializedName("full_name") val name: String,
    val isActive: Boolean
)

fun main3() {
    val json = """{"user_id":2,"full_name":"John Watson","isActive":false}"""
    val gson = Gson()
    val user = gson.fromJson(json, UserWithAlias::class.java)
    println("User with alias: $user")
}

//Вывод:

User with alias: UserWithAlias(id=2, name=John Watson, isActive=false)

//Настройка GSON с помощью GsonBuilder
//Если нужно настроить сериализацию/десериализацию (например, формат дат, работа с null), используется GsonBuilder:

import com.google.gson.GsonBuilder

fun main4() {
    val gson = GsonBuilder()
        .setPrettyPrinting() // Для красивого форматирования JSON
        .serializeNulls() // Включить null-поля в JSON
        .create()
    val user = User(3, "Mary Morstan", false, Address("Fleet Street", "London", 123))
    val json = gson.toJson(user)
    println("Pretty JSON:\n$json")
}

//Вывод:

Pretty JSON:
{
    "id": 3,
    "name": "Mary Morstan",
    "isActive": false,
    "address": {
    "street": "Fleet Street",
    "city": "London",
    "postalCode": 123
}
}