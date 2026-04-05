package com.yonatankarp.command

/**
 * Enumeration for target visibility.
 */
internal enum class Visibility {
    INVISIBLE,
    VISIBLE,
    ;

    override fun toString() = name.lowercase()
}
