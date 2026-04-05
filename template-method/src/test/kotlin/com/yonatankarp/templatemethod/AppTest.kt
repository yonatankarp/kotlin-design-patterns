package com.yonatankarp.templatemethod

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Tests for the application entry point.
 */
internal class AppTest {
    @Test
    fun `should execute without exception`() {
        assertDoesNotThrow { main() }
    }
}
