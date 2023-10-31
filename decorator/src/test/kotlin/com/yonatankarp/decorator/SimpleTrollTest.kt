package com.yonatankarp.decorator

import com.yonatankarp.decorator.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Tests for [SimpleTroll]
 */
internal class SimpleTrollTest {
    private var appender = InMemoryAppender(SimpleTroll::class.java)

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
    fun `test troll actions`() {
        val troll = SimpleTroll()
        assertEquals(10, troll.attackPower)

        troll.attack()
        assertEquals("The troll tries to grab you!", appender.lastMessage)

        troll.fleeBattle()
        assertEquals(
            "The troll shrieks in horror and runs away!",
            appender.lastMessage
        )

        assertEquals(2, appender.logSize)
    }
}
