package com.yonatankarp.memento

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

internal class AppTest {
    @Test
    fun `should execute without exception`() {
        assertDoesNotThrow { main() }
    }
}
