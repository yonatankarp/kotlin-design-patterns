package com.yonatankarp.decorator

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.AppenderBase
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

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

    /**
     * This private inner class, [InMemoryAppender], is a custom Logback Appender
     * designed to capture and store log events for a specific class represented
     * by 'clazz'. It extends the AppenderBase<ILoggingEvent> class and maintains
     * an in-memory log of log events for the specified class.
     * This is particularly useful for testing and debugging purposes when you
     * want to capture and analyze log messages generated during the execution of
     * a specific class or component.
     */
    private inner class InMemoryAppender(clazz: Class<*>) :
        AppenderBase<ILoggingEvent>() {
        private val log = mutableListOf<ILoggingEvent>()

        val lastMessage: String
            get() = log[log.size - 1].message

        val logSize: Int
            get() = log.size

        init {
            (LoggerFactory.getLogger(clazz) as Logger).addAppender(this)
            start()
        }

        override fun append(eventObject: ILoggingEvent) {
            log.add(eventObject)
        }

        fun clearAll() = log.clear()
    }
}
