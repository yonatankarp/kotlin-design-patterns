package com.yonatankarp.composite

/**
 * Composite [LetterComposite] containing [Word] children.
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
