package com.yonatankarp.proxy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Tests for [Wizard]
 */
internal class WizardTest {
    @Test
    fun `test toString()`() {
        listOf("Gandalf", "Dumbledore", "Oz", "Merlin")
            .forEach { name ->
                assertEquals(name, Wizard(name).toString())
            }
    }
}
