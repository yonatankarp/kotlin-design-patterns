package com.yonatankarp.command

/**
 * Enumeration for target size.
 */
internal enum class Size {
    NORMAL,
    SMALL,
    ;

    override fun toString() = name.lowercase()
}
