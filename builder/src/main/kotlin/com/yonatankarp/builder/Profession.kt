package com.yonatankarp.builder

/**
 * Profession enumeration.
 */
internal enum class Profession {
    MAGE,
    PRIEST,
    THIEF,
    WARRIOR,
    ;

    override fun toString() = name.lowercase()
}
