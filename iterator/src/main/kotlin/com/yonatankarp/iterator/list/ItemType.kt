package com.yonatankarp.iterator.list

/**
 * Enumerates the types of items that can be found in a
 * [TreasureChest].
 */
enum class ItemType {
    ANY,
    POTION,
    RING,
    WEAPON,
    ;

    override fun toString() = name.lowercase()
}
