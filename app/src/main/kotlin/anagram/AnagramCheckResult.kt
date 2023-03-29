package anagram

sealed class AnagramCheckResult {
    public val matchFound: Boolean get() = this is AnagramMatchFound
    public val matchNotFound: Boolean get() = this is AnagramMatchNotFound

    companion object {
        fun match(charMap: Map<Char, Int>) = AnagramMatchFound(charMap)
        fun notMatch(reason: String) = AnagramMatchNotFound(reason)
    }

    data class AnagramMatchFound(val map: Map<Char, Int>) : AnagramCheckResult()
    data class AnagramMatchNotFound(val reason: String) : AnagramCheckResult()
}