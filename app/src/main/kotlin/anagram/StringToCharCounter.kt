package anagram

interface StringToCharCounter {
    fun buildOccurrencesCharMap(text: String): Map<Char, Int>
}

class DefaultStringToCharCounter(private val stringNormalizer: StringNormalizer) : StringToCharCounter {
    override fun buildOccurrencesCharMap(text: String): Map<Char, Int> =
        stringNormalizer.normalize(text)
            .fold(mutableMapOf<Char, Int>()) { occurrences: MutableMap<Char, Int>, char: Char ->
                occurrences[char] = occurrences.getOrDefault(char.lowercaseChar(), 0) + 1
                occurrences
            }
}