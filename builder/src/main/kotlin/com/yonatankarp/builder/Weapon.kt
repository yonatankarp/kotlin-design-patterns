package com.yonatankarp.builder

/**
 * Represents the type of weapon a [Hero] can wield.
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
