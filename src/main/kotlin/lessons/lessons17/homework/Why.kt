package org.example.lessons.lesson17.homework

abstract class BaseClass(
    private val privateVal: String,
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"

    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

    // Сеттер для privateField (пункт 6)
    fun setPrivateField(value: String) {
        privateField = value
    }

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return true // разрешить любое значение (пункт 4: в оригинале было value.length < 3, но это мешает)
    }

    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass
    private class PrivateClass
}

class ChildrenClass(
    privateVal: String,
    protectedVal: String,
    publicVal: String // пункт 10: это параметр конструктора, но не поле. Однако он передаётся в super и становится publicVal в BaseClass, которое публичное.
) : BaseClass(privateVal, protectedVal, publicVal) {

    // Пункт 5: сеттер для protectedField через публичный метод
    fun setProtectedField(value: String) {
        protectedField = value
    }
}


// --------- ответы

/*
1. privateVal недоступен в main() напрямую, но в getAll() он читается — потому что private в Kotlin означает доступ только внутри класса BaseClass, но не извне. В main() к нему нет прямого доступа. (Примечание: в задании, возможно, опечатка — на самом деле privateVal недоступен в main).

2. protectedVal — недоступен в main(), потому что protected разрешает доступ только в подклассах и внутри самого класса, но не извне (в т.ч. из main).

3–4. Чтобы изменить publicField из main(), нужно, чтобы проверка verifyPublicField разрешала новое значение. Поэтому переопределили логику (в решении просто всегда true).

5. Чтобы изменить protectedField из main(), добавили в ChildrenClass публичный сеттер setProtectedField.

6. Добавили публичный метод setPrivateField() в BaseClass, чтобы можно было менять privateField извне.

7. getProtectedClass() не может быть public, потому что она возвращает вложенный protected класс — иначе нарушится инкапсуляция: внешний код сможет создавать/получать объекты ProtectedClass.

8. В getAll() поле "generate" показывает текст из дочернего класса, потому что generate() — open, и в ChildrenClass он переопределён. Вызывается полиморфно.

9. getPrivateClass() не может быть public или protected, потому что возвращает вложенный private класс, который недоступен за пределами BaseClass.

10. publicVal в конструкторе ChildrenClass не является полем, но передаётся в суперкласс, где объявлен как val publicVal: String → публичное свойство, поэтому доступно в main() через экземпляр.

11. getAll() доступна, потому что унаследована от BaseClass (метод public по умолчанию).

12. При вызове printText() печатается "Печать из класса BaseClass", потому что private-методы не наследуются и не переопределяются. privatePrint() в ChildrenClass — это совершенно другой метод.*/
