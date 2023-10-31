package com.yonatankarp.proxy

import com.yonatankarp.proxy.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Tests for [IvoryTower]
 */
internal class IvoryTowerTest {
    private val appender = InMemoryAppender()

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
    fun `test enter the tower`() {
        val wizards =
            listOf("Gandalf", "Dumbledore", "Oz", "Merlin")
                .map(::Wizard)

        val tower = IvoryTower()
        wizards.forEach(tower::enter)

        assertTrue(appender.logContains("Gandalf enters the tower."))
        assertTrue(appender.logContains("Dumbledore enters the tower."))
        assertTrue(appender.logContains("Oz enters the tower."))
        assertTrue(appender.logContains("Merlin enters the tower."))
        assertEquals(4, appender.size)
    }
}
