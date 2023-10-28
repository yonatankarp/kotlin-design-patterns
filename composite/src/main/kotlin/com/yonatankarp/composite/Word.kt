package com.yonatankarp.composite

/**
 * Word.
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
        for (letter in letters) {
            add(Letter(letter))
        }
    }

    override fun printThisBefore() = print(" ")
}
