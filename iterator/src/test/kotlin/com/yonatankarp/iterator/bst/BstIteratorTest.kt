package com.yonatankarp.iterator.bst

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.junit.jupiter.api.assertThrows

@TestInstance(Lifecycle.PER_CLASS)
internal class BstIteratorTest {
    private lateinit var nonEmptyRoot: TreeNode<Int>

    @BeforeAll
    fun createTrees() {
        nonEmptyRoot =
            TreeNode(5).apply {
                insert(3)
                insert(7)
                insert(1)
                insert(4)
                insert(6)
            }
    }

    @Test
    fun `should throw NoSuchElementException when calling next on empty tree`() {
        val iter = BstIterator<Int>(null)
        assertThrows<NoSuchElementException> { iter.next() }
    }

    @Test
    fun `should traverse entire populated tree in order`() {
        // Given
        val iter = BstIterator(nonEmptyRoot)
        val expected = listOf(1, 3, 4, 5, 6, 7)

        // When
        val result = iter.asSequence().map { it.value }.toList()

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `should return false for hasNext on empty tree`() =
        assertFalse(BstIterator<Int>(null).hasNext())

    @Test
    fun `should return true for hasNext on populated tree`() =
        assertTrue(BstIterator(nonEmptyRoot).hasNext())

    @Test
    fun `should alternate hasNext and next over entire tree`() {
        // Given
        val iter = BstIterator(nonEmptyRoot)
        val expected = listOf(1, 3, 4, 5, 6, 7)

        // When / Then
        expected.forEach { expectedValue ->
            assertTrue(iter.hasNext())
            assertEquals(expectedValue, iter.next().value)
        }
        assertFalse(iter.hasNext())
    }
}
