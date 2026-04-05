package com.yonatankarp.memento

/**
 * Enumerates the lifecycle stages of a [Star].
 */
internal enum class StarType(private val title: String) {
    DEAD("dead star"),
    RED_GIANT("red giant"),
    SUN("sun"),
    SUPERNOVA("supernova"),
    WHITE_DWARF("white dwarf"),
    ;

    override fun toString(): String = title
}
