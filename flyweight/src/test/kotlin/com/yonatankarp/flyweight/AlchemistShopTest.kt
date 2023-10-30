package com.yonatankarp.flyweight

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class AlchemistShopTest {
    @Test
    fun `test Shop`() {
        val shop = AlchemistShop()

        val bottomShelf = shop.bottomShelf
        assertNotNull(bottomShelf)
        assertEquals(5, bottomShelf.size)

        val topShelf = shop.topShelf
        assertNotNull(topShelf)
        assertEquals(8, topShelf.size)

        val allPotions = topShelf + bottomShelf

        // There are 13 potion instances, but only 5 unique instance types
        assertEquals(13, allPotions.size)
        assertEquals(5, HashSet<Any>(allPotions).size)
    }
}
