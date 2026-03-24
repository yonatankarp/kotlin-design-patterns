package com.yonatankarp.interpreter

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Tests for the interpreter [main] function.
 */
internal class AppTest {
    @Test
    fun `should execute application without exception`() {
        assertDoesNotThrow { main() }
    }
}
