package anagram

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.*

class AnagramCheckerTest {


    private val checker = buildAnagramCheckerApp()

    @ParameterizedTest
    @MethodSource("anagramSamples")
    fun `should detect all provided anagrams`(text1: String, text2: String) {
        assertIs<AnagramCheckResult.AnagramMatchFound>(checker.check(text1, text2))
    }

    @ParameterizedTest
    @MethodSource("nonAnagramSamples")
    fun `should detect all provided non anagrams`(text1: String, text2: String) {
        assertIs<AnagramCheckResult.AnagramMatchNotFound>(checker.check(text1, text2))
    }

    companion object {

        @JvmStatic
        fun anagramSamples(): List<Arguments> = listOf(
            Arguments.of("Silent", "Listen"),
            Arguments.of("silent", "listen"),
            Arguments.of("silent", "LISTEN"),
            Arguments.of("Triangle", "Integral"),
            Arguments.of("Triangle", "Integral"),
            Arguments.of("Dormitory", "Dirty room"),
            Arguments.of("Debit card", "Bad    credit"),
            Arguments.of("Funeral", "Real fun"),
            Arguments.of("412", "214"),

            )

        @JvmStatic
        fun nonAnagramSamples(): List<Arguments> = listOf(
            Arguments.of("", ""),
            Arguments.of("abc", "def"),
            Arguments.of("412", "567"),
        )

    }
}