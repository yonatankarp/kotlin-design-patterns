package com.yonatankarp.templatemethod

import com.yonatankarp.kotlin.junit.tools.logger.InMemoryLoggerAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

/**
 * Parameterized tests for all [StealingMethod] implementations.
 */
internal class StealingMethodTest {
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

    @ParameterizedTest
    @MethodSource("stealingMethods")
    fun `should execute the full steal sequence`(
        testCase: StealingMethodTestCase,
    ) {
        // When
        testCase.method.steal()

        // Then
        assertTrue(appender.logContains(testCase.expectedTarget))
        assertTrue(appender.logContains(testCase.expectedConfuse))
        assertTrue(appender.logContains(testCase.expectedSteal))
    }

    companion object {
        @JvmStatic
        fun stealingMethods() = listOf(
            StealingMethodTestCase(
                method = SubtleMethod(),
                expectedTarget = "The target has been chosen as shop keeper.",
                expectedConfuse = "Approach the shop keeper with tears running and hug him!",
                expectedSteal = "While in close contact grab the shop keeper's wallet.",
            ),
            StealingMethodTestCase(
                method = HitAndRunMethod(),
                expectedTarget = "The target has been chosen as old goblin woman.",
                expectedConfuse = "Approach the old goblin woman from behind.",
                expectedSteal = "Grab the handbag and run away fast!",
            ),
        )
    }
}

/**
 * Holds the test data for a single [StealingMethod] variant.
 */
internal data class StealingMethodTestCase(
    val method: StealingMethod,
    val expectedTarget: String,
    val expectedConfuse: String,
    val expectedSteal: String,
) {
    override fun toString() = method.javaClass.simpleName
}
