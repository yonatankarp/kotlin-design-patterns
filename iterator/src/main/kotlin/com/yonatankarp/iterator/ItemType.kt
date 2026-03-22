package com.yonatankarp.iterator

/**
 * Enumerates the types of items in a [TreasureChest].
 */
internal enum class ItemType {
    ANY,
    POTION,
    RING,
    WEAPON,
    ;

    override fun toString() = name.lowercase()
}
