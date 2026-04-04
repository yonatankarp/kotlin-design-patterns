package com.yonatankarp.singleton

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeout

import java.time.Duration

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest

/**
 * Create a new singleton test instance using the given 'getInstance' method.
 */
internal class IvoryTowerTest {
    /**
     * Test the singleton in a non-concurrent setting.
     */
    @Test
    fun `test multiple calls return the same object in the same thread`() {
        // Given
        val instance1 = IvoryTower

        // When
        val instance2 = IvoryTower
        val instance3 = IvoryTower

        // Then
        assertSame(instance1, instance2)
        assertSame(instance1, instance3)
        assertSame(instance2, instance3)
    }

    /**
     * Test singleton instance in a concurrent setting.
     */
    @Test
    fun `test multiple calls return the same object in different threads`() =
        runTest {
            assertTimeout(Duration.ofMillis(10000)) {
                // Given
                val tasks =
                    (0..10_000)
                        .map { { IvoryTower } }
                        .toList()
                val expectedInstance = IvoryTower

                // When
                tasks.forEach { task ->
                    launch(Dispatchers.Default) {
                        val instance = task()

                        // Then
                        assertNotNull(instance)
                        assertSame(expectedInstance, instance)
                    }
                }
            }
        }
}
