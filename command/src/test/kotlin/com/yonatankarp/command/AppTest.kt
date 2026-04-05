package com.yonatankarp.command

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Tests that the Command example runs without errors.
 */
internal class AppTest {
    @Test
    fun `should execute application without exception`() {
        assertDoesNotThrow { main() }
    }
}
