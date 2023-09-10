package com.yonatankarp.builder

/**
 * Weapon enumeration.
 */
internal enum class Weapon {
    AXE,
    BOW,
    DAGGER,
    SWORD,
    WARHAMMER,
    ;

    override fun toString() = name.lowercase()
}
