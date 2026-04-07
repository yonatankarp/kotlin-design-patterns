package com.yonatankarp.gateway

/**
 * Simulates an external inventory service behind the [Gateway]
 * interface.
 *
 * Logs its execution and pauses briefly to mimic a
 * time-consuming remote call.
 */
internal class InventoryService : Gateway {
    override fun execute() {
        logger.info("Executing Inventory Service")
        Thread.sleep(SIMULATED_DELAY_MS)
    }
}
