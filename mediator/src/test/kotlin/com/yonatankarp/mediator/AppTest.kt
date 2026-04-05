package com.yonatankarp.mediator

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Verifies that the application entry point runs without errors.
 */
internal class AppTest {
    @Test
    fun `should execute application without exception`() =
        assertDoesNotThrow { main() }
}
