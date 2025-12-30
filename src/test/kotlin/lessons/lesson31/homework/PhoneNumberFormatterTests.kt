package lessons.lesson31.homework
import org.example.lessons.lesson31.homeworks.PhoneNumberFormatter
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource


class PhoneNumberFormatterTest {

    @ParameterizedTest
    @MethodSource("validPhones")
    fun formatValidPhonesTest(source: String, expected: String) {
        val formatter = PhoneNumberFormatter()
        val actual = formatter.formatPhoneNumber(source)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @ValueSource(strings = ["12345", "+1 (922) 941-11-11"])
    fun invalidPhoneTest(source: String) {
        val formatter = PhoneNumberFormatter()
        assertThrows(IllegalArgumentException::class.java) {
            formatter.formatPhoneNumber(source)
        }
    }


    companion object {

        @JvmStatic
        fun validPhones() = listOf<Any>(
            arrayOf("8 (922) 941-11-11", "+7 (922) 941-11-11"),
            arrayOf("79229411111", "+7 (922) 941-11-11"),
            arrayOf("+7 922 941 11 11", "+7 (922) 941-11-11"),
            arrayOf("9229411111", "+7 (922) 941-11-11"),
            arrayOf("abc +7 922 941 11 11", "+7 (922) 941-11-11"),
        )
    }
}
