package com.yonatankarp.iterator.list

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class TreasureChestTest {
    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `should find expected item via iterator`(expectedItem: Item) {
        // Given
        val chest = TreasureChest()
        val iterator = chest.iterator(expectedItem.type)

        // When
        val found = iterator.asSequence().any { it.toString() == expectedItem.toString() }

        // Then
        if (!found) {
            fail<Unit>(
                "Expected to find item [$expectedItem] " +
                    "using iterator, but we didn't.",
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `should find expected item via getItems`(expectedItem: Item) {
        // Given
        val chest = TreasureChest()
        val items = chest.getItems()

        // When / Then
        assertNotNull(items)
        val found =
            items.any {
                it.type == expectedItem.type &&
                    it.toString() == expectedItem.toString()
            }
        if (!found) {
            fail<Unit>(
                "Expected to find item [$expectedItem] " +
                    "in the item list, but we didn't.",
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `iterator should only return items of requested type`(
        expectedItem: Item,
    ) {
        // Given
        val chest = TreasureChest()
        val iterator = chest.iterator(expectedItem.type)

        // When / Then
        iterator.forEach { item ->
            assertEquals(expectedItem.type, item.type)
        }
    }

    companion object {
        @JvmStatic
        fun dataProvider() =
            listOf(
                arrayOf(Item(ItemType.POTION, "Potion of courage")),
                arrayOf(Item(ItemType.RING, "Ring of shadows")),
                arrayOf(Item(ItemType.POTION, "Potion of wisdom")),
                arrayOf(Item(ItemType.POTION, "Potion of blood")),
                arrayOf(Item(ItemType.WEAPON, "Sword of silver +1")),
                arrayOf(Item(ItemType.POTION, "Potion of rust")),
                arrayOf(Item(ItemType.POTION, "Potion of healing")),
                arrayOf(Item(ItemType.RING, "Ring of armor")),
                arrayOf(Item(ItemType.WEAPON, "Steel halberd")),
                arrayOf(Item(ItemType.WEAPON, "Dagger of poison")),
            )
    }
}
