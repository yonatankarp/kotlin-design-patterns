package com.yonatankarp.iterator.list

/**
 * An [Iterator] over [Item] objects filtered by [ItemType].
 *
 * When the type is [ItemType.ANY], every item is returned.
 *
 * @property items the full list of items to iterate over
 * @property type the item type filter
 */
internal class TreasureChestItemIterator(
    private val items: List<Item>,
    private val type: ItemType,
) : Iterator<Item> {
    private var idx = -1

    override fun hasNext(): Boolean = findNextIdx() != -1

    override fun next(): Item {
        idx = findNextIdx()
        check(idx != -1) { "No more items" }
        return items[idx]
    }

    private fun findNextIdx(): Int {
        var tempIdx = idx
        while (true) {
            tempIdx++
            if (tempIdx >= items.size) {
                return -1
            }
            if (type == ItemType.ANY || items[tempIdx].type == type) {
                return tempIdx
            }
        }
    }
}
