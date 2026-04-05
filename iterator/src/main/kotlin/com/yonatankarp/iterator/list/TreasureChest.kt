package com.yonatankarp.iterator.list

/**
 * A collection of [Item] objects that supports iteration filtered
 * by [ItemType].
 */
class TreasureChest {
    private val items: List<Item> =
        listOf(
            Item(ItemType.POTION, "Potion of courage"),
            Item(ItemType.RING, "Ring of shadows"),
            Item(ItemType.POTION, "Potion of wisdom"),
            Item(ItemType.POTION, "Potion of blood"),
            Item(ItemType.WEAPON, "Sword of silver +1"),
            Item(ItemType.POTION, "Potion of rust"),
            Item(ItemType.POTION, "Potion of healing"),
            Item(ItemType.RING, "Ring of armor"),
            Item(ItemType.WEAPON, "Steel halberd"),
            Item(ItemType.WEAPON, "Dagger of poison"),
        )

    /**
     * Returns an iterator over items of the given [itemType].
     * Pass [ItemType.ANY] to iterate over all items.
     */
    fun iterator(itemType: ItemType): Iterator<Item> =
        TreasureChestItemIterator(items, itemType)

    /**
     * Returns a defensive copy of all items in the chest.
     */
    fun getItems(): List<Item> = items.toList()
}
