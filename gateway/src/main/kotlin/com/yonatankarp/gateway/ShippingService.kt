package com.yonatankarp.gateway

/**
 * Simulates an external shipping service behind the [Gateway]
 * interface.
 *
 * Logs its execution and pauses briefly to mimic a
 * time-consuming remote call.
 */
internal class ShippingService : Gateway {
    override fun execute() {
        logger.info("Executing Shipping Service")
        Thread.sleep(SIMULATED_DELAY_MS)
    }
}
