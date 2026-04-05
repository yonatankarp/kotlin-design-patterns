package com.yonatankarp.iterator.list

/**
 * Represents a single item stored inside a [TreasureChest].
 *
 * @property type the category of this item
 * @property name the display name of this item
 */
data class Item(val type: ItemType, val name: String) {
    override fun toString() = name
}
