package anagram

class AnagramChecker(private val charCounter: StringToCharCounter) {

    fun check(text1: String, text2: String): AnagramCheckResult {

        if(text1.isBlank() || text2.isBlank()) return AnagramCheckResult.notMatch("Not an anagram. $text1 and/or $text2 is/are blank")

        val charMap1 = charCounter.buildOccurrencesCharMap(text1)
        val charMap2 = charCounter.buildOccurrencesCharMap(text2)

        val result = if (charMap1 == charMap2) {
            AnagramCheckResult.match(charMap1)
        } else {
            AnagramCheckResult.notMatch("$text1 and $text2 are not anagrams.")
        }
        return result
    }

}