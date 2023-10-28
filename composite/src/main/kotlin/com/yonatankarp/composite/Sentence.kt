package com.yonatankarp.composite

/**
 * Sentence.
 */
internal class Sentence(words: List<Word>) : LetterComposite() {
    /**
     * Constructor.
     */
    init {
        words.forEach(::add)
    }

    override fun printThisAfter() = print(".\n")
}
