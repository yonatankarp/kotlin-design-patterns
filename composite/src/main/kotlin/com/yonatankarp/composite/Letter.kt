package com.yonatankarp.composite

/**
 * Leaf [LetterComposite] representing a single character.
 */
class Letter(private val character: Char) : LetterComposite() {
    override fun printThisBefore() = print(character)
}
