package com.yonatankarp.iterator

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

internal class AppTest {
    @Test
    fun `should execute application without exception`() =
        assertDoesNotThrow { main() }
}
