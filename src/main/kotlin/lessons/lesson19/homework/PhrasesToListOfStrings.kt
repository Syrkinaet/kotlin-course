package org.example.lessons.lesson19.homework

class PhrasesToListOfStrings : Mapper<String, List<String>> {

    override fun transform(element: String): List<String> {
        return element.split(" ")
    }

    override fun transform(elements: List<String>): List<List<String>> {
        return elements.map { it.split(" ") }
    }
}