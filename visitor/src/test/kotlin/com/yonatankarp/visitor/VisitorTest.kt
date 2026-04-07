package com.yonatankarp.visitor

import com.yonatankarp.kotlin.junit.tools.logger.InMemoryLoggerAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

/**
 * Verifies that each [UnitVisitor] implementation logs the
 * expected message for the unit type it targets and stays silent
 * for the others.
 */
internal class VisitorTest {
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

    @ParameterizedTest(name = "{0} visiting commander")
    @MethodSource("commanderVisitData")
    fun `should log expected message when visiting commander`(
        visitorName: String,
        visitor: UnitVisitor,
        expectedMessage: String?,
    ) {
        visitor.visit(Commander())
        assertExpectedLog(expectedMessage)
    }

    @ParameterizedTest(name = "{0} visiting sergeant")
    @MethodSource("sergeantVisitData")
    fun `should log expected message when visiting sergeant`(
        visitorName: String,
        visitor: UnitVisitor,
        expectedMessage: String?,
    ) {
        visitor.visit(Sergeant())
        assertExpectedLog(expectedMessage)
    }

    @ParameterizedTest(name = "{0} visiting soldier")
    @MethodSource("soldierVisitData")
    fun `should log expected message when visiting soldier`(
        visitorName: String,
        visitor: UnitVisitor,
        expectedMessage: String?,
    ) {
        visitor.visit(Soldier())
        assertExpectedLog(expectedMessage)
    }

    private fun assertExpectedLog(expectedMessage: String?) {
        if (expectedMessage != null) {
            assertEquals(expectedMessage, appender.lastMessage)
            assertEquals(1, appender.logSize)
        } else {
            assertEquals(0, appender.logSize)
        }
    }

    companion object {
        @JvmStatic
        fun commanderVisitData() = listOf(
            arrayOf<Any?>(
                "CommanderVisitor",
                CommanderVisitor(),
                "Good to see you commander",
            ),
            arrayOf<Any?>(
                "SergeantVisitor",
                SergeantVisitor(),
                null,
            ),
            arrayOf<Any?>(
                "SoldierVisitor",
                SoldierVisitor(),
                null,
            ),
        )

        @JvmStatic
        fun sergeantVisitData() = listOf(
            arrayOf<Any?>(
                "CommanderVisitor",
                CommanderVisitor(),
                null,
            ),
            arrayOf<Any?>(
                "SergeantVisitor",
                SergeantVisitor(),
                "Hello sergeant",
            ),
            arrayOf<Any?>(
                "SoldierVisitor",
                SoldierVisitor(),
                null,
            ),
        )

        @JvmStatic
        fun soldierVisitData() = listOf(
            arrayOf<Any?>(
                "CommanderVisitor",
                CommanderVisitor(),
                null,
            ),
            arrayOf<Any?>(
                "SergeantVisitor",
                SergeantVisitor(),
                null,
            ),
            arrayOf<Any?>(
                "SoldierVisitor",
                SoldierVisitor(),
                "Greetings soldier",
            ),
        )
    }
}
