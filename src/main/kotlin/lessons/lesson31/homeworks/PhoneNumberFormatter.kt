package org.example.lessons.lesson31.homeworks

class PhoneNumberFormatter {

    fun formatPhoneNumber(input: String): String {
        val digits = input.replace("\\D".toRegex(), "")

        val normalized = when (digits.length) {
            10 -> "7$digits"
            11 -> digits
            else -> throw IllegalArgumentException("Invalid phone number length")
        }

        if (normalized[0] != '7' && normalized[0] != '8') {
            throw IllegalArgumentException("Invalid country code")
        }

        val phone = "7" + normalized.substring(1)

        val code = phone.substring(1, 4)
        val part1 = phone.substring(4, 7)
        val part2 = phone.substring(7, 9)
        val part3 = phone.substring(9, 11)

        return "+7 ($code) $part1-$part2-$part3"
    }
}
