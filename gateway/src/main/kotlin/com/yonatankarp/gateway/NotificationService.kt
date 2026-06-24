package com.yonatankarp.gateway

/**
 * Simulates an external notification service behind the
 * [Gateway] interface.
 *
 * In addition to normal execution, this service exposes an
 * [error] method that simulates a service failure.
 */
internal class NotificationService : Gateway {
    override fun execute() {
        logger.info("Executing Notification Service")
        Thread.sleep(SIMULATED_DELAY_MS)
    }

    /**
     * Simulates an error condition in the external service.
     *
     * @throws RuntimeException always
     */
    fun error() {
        throw RuntimeException(
            "Notification Service encountered an error",
        )
    }
}
