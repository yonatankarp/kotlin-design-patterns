package com.yonatankarp.proxy

import com.yonatankarp.proxy.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Tests for [WizardTowerProxy]
 */
internal class WizardTowerProxyTest {
    private var appender = InMemoryAppender()

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
    fun `test enter tower proxy`() {
        val wizards =
            listOf("Gandalf", "Dumbledore", "Oz", "Merlin")
                .map(::Wizard)

        val proxy = WizardTowerProxy(IvoryTower())
        wizards.forEach(proxy::enter)

        assertTrue(appender.logContains("Gandalf enters the tower."))
        assertTrue(appender.logContains("Dumbledore enters the tower."))
        assertTrue(appender.logContains("Oz enters the tower."))
        assertTrue(appender.logContains("Merlin is not allowed to enter!"))
        assertEquals(4, appender.size)
    }
}
