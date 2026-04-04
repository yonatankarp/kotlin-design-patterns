package com.yonatankarp.builder

/**
 * Represents the character class or profession of a [Hero].
 */
internal enum class Profession {
    MAGE,
    PRIEST,
    THIEF,
    WARRIOR,
    ;

    override fun toString() = name.lowercase()
}
