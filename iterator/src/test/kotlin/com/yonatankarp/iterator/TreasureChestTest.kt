package com.yonatankarp.iterator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TreasureChestTest {
    @Test
    fun `chest should contain all items`() {
        // Given
        val chest = TreasureChest()

        // When
        val items = chest.items

        // Then
        assertEquals(10, items.size)
    }

    @ParameterizedTest(name = "iterating with {0} should yield {1} items")
    @MethodSource("itemTypeCounts")
    fun `iterator should yield correct number of items per type`(
        type: ItemType,
        expectedCount: Int,
    ) {
        // Given
        val chest = TreasureChest()
        val iterator = chest.iterator(type)

        // When
        var count = 0
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (type != ItemType.ANY) {
                assertEquals(type, item.type)
            }
            count++
        }

        // Then
        assertEquals(expectedCount, count)
    }

    @Test
    fun `iterator should throw NoSuchElementException when exhausted`() {
        // Given
        val chest = TreasureChest()
        val iterator = chest.iterator(ItemType.RING)
        while (iterator.hasNext()) {
            iterator.next()
        }

        // When / Then
        assertFalse(iterator.hasNext())
        assertThrows<NoSuchElementException> { iterator.next() }
    }

    companion object {
        @JvmStatic
        fun itemTypeCounts() = listOf(
            Arguments.of(ItemType.ANY, 10),
            Arguments.of(ItemType.POTION, 5),
            Arguments.of(ItemType.RING, 2),
            Arguments.of(ItemType.WEAPON, 3),
        )
    }
}
