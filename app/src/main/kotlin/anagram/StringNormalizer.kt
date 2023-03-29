package anagram


interface StringNormalizer{
    fun normalize(text: String):String
}

class AnagramStringNormalizer: StringNormalizer {
    override fun normalize(text: String): String {
        return text.lowercase().replace("[^a-z0-9]".toRegex(), "")
    }

}