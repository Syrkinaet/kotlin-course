package org.example.lessons.lesson19.homework

class StringValidator : Validator<String?> {
    override fun validation(element: String?): Boolean {
        if (element != null) {
            return element.isNotBlank()
        } else {
            return false
        }
    }
}