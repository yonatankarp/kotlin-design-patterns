package com.yonatankarp.iterator

/**
 * Represents an item stored in a [TreasureChest].
 */
internal data class Item(
    val type: ItemType,
    val name: String,
) {
    override fun toString() = name
}
