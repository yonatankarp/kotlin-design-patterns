package com.yonatankarp.iterator

/**
 * A collection of [Item]s that supports filtered iteration by [ItemType].
 *
 * Calling [iterator] with [ItemType.ANY] yields every item; any other type
 * yields only matching items.
 */
internal class TreasureChest {
    val items = listOf(
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
     * Returns an [Iterator] over items matching the given [itemType].
     * Use [ItemType.ANY] to iterate over every item.
     */
    fun iterator(itemType: ItemType): Iterator<Item> =
        TreasureChestItemIterator(items, itemType)
}
