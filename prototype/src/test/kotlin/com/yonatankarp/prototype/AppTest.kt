package com.yonatankarp.prototype

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class AppTest {
    @Test
    fun `should execute without exception`() {
        assertDoesNotThrow { main() }
    }
}
