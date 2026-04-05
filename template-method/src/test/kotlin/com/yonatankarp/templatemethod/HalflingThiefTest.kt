package com.yonatankarp.templatemethod

import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test

/**
 * Tests for [HalflingThief].
 */
internal class HalflingThiefTest {
    @Test
    fun `should delegate steal to the current method`() {
        val method = spyk(HitAndRunMethod())
        val thief = HalflingThief(method)

        thief.steal()

        verify { method.steal() }
    }

    @Test
    fun `should use new method after change`() {
        // Given
        val initialMethod = spyk(HitAndRunMethod())
        val thief = HalflingThief(initialMethod)
        thief.steal()
        verify { initialMethod.steal() }

        // When
        val newMethod = spyk(SubtleMethod())
        thief.changeMethod(newMethod)
        thief.steal()

        // Then
        verify { newMethod.steal() }
    }
}
