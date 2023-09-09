package com.yonatankarp.factory.method

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

/**
 * Tests that Factory Method example runs without errors.
 */
internal class AppTest {
    @Test
    fun shouldExecuteWithoutException() {
        assertDoesNotThrow { main() }
    }
}
