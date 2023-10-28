package com.yonatankarp.composite

/**
 * Messenger.
 */
internal class Messenger {
    fun messageFromOrcs(): LetterComposite {
        val words = listOf(
            Word('W', 'h', 'e', 'r', 'e'),
            Word('t', 'h', 'e', 'r', 'e'),
            Word('i', 's'),
            Word('a'),
            Word('w', 'h', 'i', 'p'),
            Word('t', 'h', 'e', 'r', 'e'),
            Word('i', 's'),
            Word('a'),
            Word('w', 'a', 'y')
        )
        return Sentence(words)
    }

    fun messageFromElves(): LetterComposite {
        val words = listOf(
            Word('M', 'u', 'c', 'h'),
            Word('w', 'i', 'n', 'd'),
            Word('p', 'o', 'u', 'r', 's'),
            Word('f', 'r', 'o', 'm'),
            Word('y', 'o', 'u', 'r'),
            Word('m', 'o', 'u', 't', 'h')
        )
        return Sentence(words)
    }
}
