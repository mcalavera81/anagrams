package anagram

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class StringToCharCounterTest {

    private val charCounter = DefaultStringToCharCounter(AnagramStringNormalizer())


    @ParameterizedTest
    @MethodSource("textSamples")
    fun `should count correctly char occurrences in text considering case`(text:String, expectedMap: Map<Char, Int>){
        assertEquals(expectedMap,charCounter.buildOccurrencesCharMap(text))
    }

    companion object {
        @JvmStatic
        fun  textSamples(): List<Arguments> = listOf(
            Arguments.of("", emptyMap<Char,Int>()),
            Arguments.of("a", mapOf('a' to 1)),
            Arguments.of("A", mapOf('a' to 1)),
            Arguments.of("aAa", mapOf('a' to 3)),
            Arguments.of("AAA", mapOf('a' to 3)),
            Arguments.of("aBc", mapOf('a' to 1, 'b' to 1, 'c' to 1)),
            Arguments.of("ABC", mapOf('a' to 1, 'b' to 1, 'c' to 1)),
            Arguments.of("aaabc", mapOf('a' to 3, 'b' to 1, 'c' to 1)),
            Arguments.of("AAABC", mapOf('a' to 3, 'b' to 1, 'c' to 1)),
            Arguments.of("abcaa", mapOf('a' to 3, 'b' to 1, 'c' to 1)),
            Arguments.of("abcAAb", mapOf('a' to 3, 'b' to 2, 'c' to 1)),
            Arguments.of("abcaaba", mapOf('a' to 4, 'b' to 2, 'c' to 1)),
            Arguments.of("ABCAABA", mapOf('a' to 4, 'b' to 2, 'c' to 1)),
            Arguments.of("abcAabaCC", mapOf('a' to 4, 'b' to 2, 'c' to 3)),
            Arguments.of("abc cC", mapOf('a' to 1, 'b' to 1, 'c' to 3)),
            Arguments.of("ABC CC ", mapOf('a' to 1, 'b' to 1, 'c' to 3)),
            Arguments.of("4@!/$## @!!", mapOf('4' to 1)),
        )
    }
}