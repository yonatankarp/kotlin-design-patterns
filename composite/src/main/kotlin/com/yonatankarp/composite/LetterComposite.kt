package com.yonatankarp.composite

/**
 * Base component in the Composite tree of printable elements.
 */
sealed class LetterComposite {
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
     * Recursively prints this node and all its children.
     */
    fun print() {
        printThisBefore()
        children.forEach { it.print() }
        printThisAfter()
    }
}
