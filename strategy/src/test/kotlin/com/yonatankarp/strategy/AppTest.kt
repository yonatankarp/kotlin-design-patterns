package com.yonatankarp.strategy

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

/**
 * Application test.
 */
internal class AppTest {
    @Test
    fun `should execute without exception`() {
        assertDoesNotThrow { main() }
    }
}
