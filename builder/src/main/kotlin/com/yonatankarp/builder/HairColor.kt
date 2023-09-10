package com.yonatankarp.builder

/**
 * HairColor enumeration.
 */
internal enum class HairColor {
    BLACK,
    BLOND,
    BROWN,
    RED,
    WHITE,
    ;

    override fun toString() = name.lowercase()
}
