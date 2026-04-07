package com.yonatankarp.gateway

import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GatewayFactoryTest {
    private lateinit var factory: GatewayFactory

    @BeforeEach
    fun setUp() {
        factory = GatewayFactory()
        factory.registerGateway("Shipping", ShippingService())
        factory.registerGateway("Inventory", InventoryService())
        factory.registerGateway("Notification", NotificationService())
    }

    @Test
    fun `should return correct service type for each registered key`() {
        assertInstanceOf(ShippingService::class.java, factory.getGateway("Shipping"))
        assertInstanceOf(InventoryService::class.java, factory.getGateway("Inventory"))
        assertInstanceOf(NotificationService::class.java, factory.getGateway("Notification"))
    }

    @Test
    fun `should return null for unregistered key`() {
        assertNull(factory.getGateway("NonExistent"))
    }

    @Test
    fun `should overwrite existing registration with same key`() {
        // Given
        val replacement = InventoryService()
        factory.registerGateway("Shipping", replacement)

        // When
        val result = factory.getGateway("Shipping")

        // Then
        assertSame(replacement, result)
    }
}
