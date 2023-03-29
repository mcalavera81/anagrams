package anagram

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class AnagramStringNormalizerTest {

    private val normalizer = AnagramStringNormalizer()

    @ParameterizedTest
    @MethodSource("notNormalizedText")
    fun `should normalize string and remove all non alpha numeric characters`(originalText:String, normalizedText:String){
        assertEquals(normalizedText, normalizer.normalize(originalText))
    }

    companion object {

        @JvmStatic
        fun notNormalizedText(): List<Arguments> = listOf(
            Arguments.of("", ""),
            Arguments.of("a", "a"),
            Arguments.of("A", "a"),
            Arguments.of("AA", "aa"),
            Arguments.of("AABB", "aabb"),
            Arguments.of("AA BB", "aabb"),
            Arguments.of("AA BB ", "aabb"),
            Arguments.of("@AA BB &$", "aabb"),
        )

    }
}