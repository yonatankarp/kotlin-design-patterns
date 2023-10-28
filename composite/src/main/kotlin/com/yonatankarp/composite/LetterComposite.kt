package com.yonatankarp.composite

/**
 * Composite interface.
 */
open class LetterComposite {
    private val children = mutableListOf<LetterComposite>()
    fun add(letter: LetterComposite) {
        children.add(letter)
    }

    fun count() = children.size

    protected open fun printThisBefore() {
    }
    protected open fun printThisAfter() {
    }

    /**
     * Print.
     */
    fun print() {
        printThisBefore()
        children.forEach { it.print() }
        printThisAfter()
    }
}
