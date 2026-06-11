package com.yonatankarp.gateway

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

internal class GatewayConcurrencyTest {
    @Test
    fun `should handle concurrent gateway execution without errors`() {
        // Given
        val factory = GatewayFactory()
        factory.registerGateway("Shipping", ShippingService())
        val threadCount = 10
        val latch = CountDownLatch(threadCount)
        val failed = AtomicBoolean(false)
        val executor = Executors.newFixedThreadPool(threadCount)

        // When
        repeat(threadCount) {
            executor.submit {
                try {
                    factory.getGateway("Shipping")?.execute()
                } catch (_: Exception) {
                    failed.set(true)
                } finally {
                    latch.countDown()
                }
            }
        }
        latch.await()
        executor.shutdown()

        // Then
        assertFalse(failed.get(), "Concurrent execution should not fail")
    }
}
