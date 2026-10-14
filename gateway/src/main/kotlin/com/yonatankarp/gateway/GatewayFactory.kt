package com.yonatankarp.gateway

/**
 * Registry that maps string keys to [Gateway] instances.
 *
 * Clients register external services under unique keys and later
 * retrieve them by key, decoupling service lookup from usage.
 */
internal class GatewayFactory {
    private val gateways = mutableMapOf<String, Gateway>()

    /**
     * Registers a [gateway] under the given [key].
     *
     * @param key unique identifier for the gateway
     * @param gateway the gateway instance to register
     */
    fun registerGateway(key: String, gateway: Gateway) {
        gateways[key] = gateway
    }

    /**
     * Returns the [Gateway] registered under [key],
     * or `null` if no gateway is registered with that key.
     *
     * @param key the identifier to look up
     * @return the registered gateway, or `null`
     */
    fun getGateway(key: String): Gateway? = gateways[key]
}
