package com.yonatankarp.iterator

/**
 * Iterates over a list of [Item]s, optionally filtering by [ItemType].
 * When [type] is [ItemType.ANY], all items are yielded.
 */
internal class TreasureChestItemIterator(
    private val items: List<Item>,
    private val type: ItemType,
) : Iterator<Item> {
    private var currentIndex: Int = -1

    override fun hasNext(): Boolean = findNextIndex() != -1

    override fun next(): Item {
        currentIndex = findNextIndex()
        if (currentIndex == -1) {
            throw NoSuchElementException()
        }
        return items[currentIndex]
    }

    private fun findNextIndex(): Int =
        (currentIndex + 1..items.lastIndex).firstOrNull { idx ->
            type == ItemType.ANY || items[idx].type == type
        } ?: -1
}
