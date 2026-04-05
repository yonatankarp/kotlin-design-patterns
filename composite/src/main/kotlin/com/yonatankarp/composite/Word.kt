package com.yonatankarp.composite

/**
 * Composite [LetterComposite] containing [Letter] children.
 */
class Word : LetterComposite {
    /**
     * Constructor.
     */
    constructor(letters: List<Letter>) {
        letters.forEach { add(it) }
    }

    /**
     * Constructor.
     * @param letters to include
     */
    constructor(vararg letters: Char) {
        letters.forEach { add(Letter(it)) }
    }

    override fun printThisBefore() = print(" ")
}
