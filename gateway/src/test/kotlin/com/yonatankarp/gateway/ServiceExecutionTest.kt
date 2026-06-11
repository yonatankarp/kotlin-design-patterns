package com.yonatankarp.gateway

import com.yonatankarp.kotlin.junit.tools.logger.InMemoryLoggerAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ServiceExecutionTest {
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

    @ParameterizedTest(name = "{1}")
    @MethodSource("serviceProvider")
    fun `should log expected message when executed`(
        service: Gateway,
        expectedMessage: String,
    ) {
        // When
        service.execute()

        // Then
        assertEquals(expectedMessage, appender.lastMessage)
        assertEquals(1, appender.logSize)
    }

    @Test
    fun `notification service error should throw runtime exception`() {
        val exception = assertThrows(RuntimeException::class.java) {
            NotificationService().error()
        }
        assertEquals(
            "Notification Service encountered an error",
            exception.message,
        )
    }

    companion object {
        @JvmStatic
        fun serviceProvider() =
            listOf(
                arrayOf(ShippingService(), "Executing Shipping Service"),
                arrayOf(InventoryService(), "Executing Inventory Service"),
                arrayOf(NotificationService(), "Executing Notification Service"),
            )
    }
}
