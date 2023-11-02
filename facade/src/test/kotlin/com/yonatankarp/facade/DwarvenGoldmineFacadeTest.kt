package com.yonatankarp.facade

import com.yonatankarp.kotlin.junit.tools.logger.InMemoryLoggerAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class DwarvenGoldmineFacadeTest {
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

    /**
     * Test a complete day cycle in the gold mine by executing all three
     * different steps: {@link DwarvenGoldmineFacade#startNewDay()},
     * {@link DwarvenGoldmineFacade#digOutGold()} and
     * {@link DwarvenGoldmineFacade#endDay()}.
     *
     * See if the workers are doing what's expected from them on each step.
     */
    @Test
    fun `test full work day`() {
        val goldMine = DwarvenGoldmineFacade()

        goldMine.startNewDay()

        // On the start of a day, all workers should wake up ...
        assertTrue(appender.logContains("Dwarf gold digger wakes up."))
        assertTrue(appender.logContains("Dwarf cart operator wakes up."))
        assertTrue(appender.logContains("Dwarven tunnel digger wakes up."))

        // ... and go to the mine
        assertTrue(appender.logContains("Dwarf gold digger goes to the mine."))
        assertTrue(appender.logContains("Dwarf cart operator goes to the mine."))
        assertTrue(appender.logContains("Dwarven tunnel digger goes to the mine."))

        // No other actions were invoked, so the workers shouldn't have done
        // (printed) anything else
        assertEquals(6, appender.logSize)

        // Now do some actual work, start digging gold!
        goldMine.digOutGold()

        // Since we gave the dig command, every worker should be doing its job ...
        assertTrue(appender.logContains("Dwarf gold digger digs for gold."))
        assertTrue(appender.logContains("Dwarf cart operator moves gold chunks out of the mine."))
        assertTrue(appender.logContains("Dwarven tunnel digger creates another promising tunnel."))

        // Again, they shouldn't be doing anything else.
        assertEquals(9, appender.logSize)

        // Enough gold, lets end the day.
        goldMine.endDay()

        // Check if the workers go home ...
        assertTrue(appender.logContains("Dwarf gold digger goes home."))
        assertTrue(appender.logContains("Dwarf cart operator goes home."))
        assertTrue(appender.logContains("Dwarven tunnel digger goes home."))

        // ... and go to sleep. We need well rested workers the next day :)
        assertTrue(appender.logContains("Dwarf gold digger goes to sleep."))
        assertTrue(appender.logContains("Dwarf cart operator goes to sleep."))
        assertTrue(appender.logContains("Dwarven tunnel digger goes to sleep."))

        // Every worker should be sleeping now, no other actions allowed
        assertEquals(15, appender.logSize)
    }
}
