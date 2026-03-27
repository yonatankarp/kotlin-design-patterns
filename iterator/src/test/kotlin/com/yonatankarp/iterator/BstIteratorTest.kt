package com.yonatankarp.iterator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BstIteratorTest {
    @Test
    fun `in-order traversal should yield sorted values`() {
        // Given
        val root = TreeNode(5)
        listOf(3, 7, 1, 4, 6).forEach { root.insert(it) }

        // When
        val iterator = BstIterator(root)
        val result = mutableListOf<Int>()
        while (iterator.hasNext()) {
            result.add(iterator.next().value)
        }

        // Then
        assertEquals(listOf(1, 3, 4, 5, 6, 7), result)
    }

    @Test
    fun `single node tree should yield one element`() {
        // Given
        val iterator = BstIterator(TreeNode(42))

        // When
        val value = iterator.next().value

        // Then
        assertEquals(42, value)
        assertFalse(iterator.hasNext())
    }

    @Test
    fun `next on exhausted iterator should throw NoSuchElementException`() {
        // Given
        val iterator = BstIterator(TreeNode(1))
        iterator.next()

        // When / Then
        assertThrows<NoSuchElementException> { iterator.next() }
    }

    @Test
    fun `interleaved hasNext and next calls should work correctly`() {
        // Given
        val root = TreeNode(3)
        listOf(1, 5).forEach { root.insert(it) }
        val iterator = BstIterator(root)

        // When / Then
        assertTrue(iterator.hasNext())
        assertTrue(iterator.hasNext())
        assertEquals(1, iterator.next().value)
        assertTrue(iterator.hasNext())
        assertEquals(3, iterator.next().value)
        assertTrue(iterator.hasNext())
        assertEquals(5, iterator.next().value)
        assertFalse(iterator.hasNext())
    }
}
