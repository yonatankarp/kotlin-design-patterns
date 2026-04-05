package com.yonatankarp.state

import com.yonatankarp.kotlin.junit.tools.logger.InMemoryLoggerAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Verifies that the [Mammoth] alternates between
 * peaceful and angry states as time passes.
 */
internal class MammothTest {
    private val appender = InMemoryLoggerAppender()

    @BeforeEach
    fun setUp() {
        appender.start()
    }

    @AfterEach
    fun tearDown() {
        appender.stop()
        appender.clearAll()
    }

    @Test
    fun `should cycle through peaceful and angry states`() {
        // Given
        val mammoth = Mammoth()

        // When — observe peaceful state
        mammoth.observe()

        // Then
        assertEquals(
            "The mammoth is calm and peaceful.",
            appender.lastMessage
        )
        assertEquals(1, appender.logSize)

        // When — time passes → angry
        mammoth.timePasses()

        // Then
        assertEquals("The mammoth gets angry!", appender.lastMessage)
        assertEquals(2, appender.logSize)

        // When — observe angry state
        mammoth.observe()

        // Then
        assertEquals("The mammoth is furious!", appender.lastMessage)
        assertEquals(3, appender.logSize)

        // When — time passes → peaceful again
        mammoth.timePasses()

        // Then
        assertEquals("The mammoth calms down.", appender.lastMessage)
        assertEquals(4, appender.logSize)

        // When — observe peaceful state again
        mammoth.observe()

        // Then
        assertEquals(
            "The mammoth is calm and peaceful.",
            appender.lastMessage
        )
        assertEquals(5, appender.logSize)
    }

    @Test
    fun `should have meaningful toString`() {
        val toString = Mammoth().toString()
        assertNotNull(toString)
        assertEquals("The mammoth", toString)
    }
}
