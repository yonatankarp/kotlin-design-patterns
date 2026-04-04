package com.yonatankarp.builder

/**
 * Represents the available hair colors for a [Hero].
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
