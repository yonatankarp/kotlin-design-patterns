package com.yonatankarp.abstractfactory

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

/**
 * Tests that Abstract Factory example runs without errors.
 */
internal class AppTest {
    @Test
    fun `should execute without exception`() = assertDoesNotThrow { main() }
}
