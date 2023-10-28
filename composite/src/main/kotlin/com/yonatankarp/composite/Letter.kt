package com.yonatankarp.composite

/**
 * Letter.
 */
class Letter(private val character: Char) : LetterComposite() {
    override fun printThisBefore() = print(character)
}
