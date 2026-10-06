package com.yonatankarp.gateway

/**
 * Demonstrates the Gateway design pattern by registering three
 * external services behind a [GatewayFactory] and invoking each
 * through the unified [Gateway] interface.
 */
fun main() {
    val factory = GatewayFactory()
    factory.registerGateway("Shipping", ShippingService())
    factory.registerGateway("Inventory", InventoryService())
    factory.registerGateway("Notification", NotificationService())

    factory.getGateway("Shipping")?.execute()
    factory.getGateway("Inventory")?.execute()
    factory.getGateway("Notification")?.execute()
}
