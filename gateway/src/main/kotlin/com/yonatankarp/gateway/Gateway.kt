package com.yonatankarp.gateway

/**
 * Unified interface for interacting with external services.
 *
 * Each service behind the gateway implements this single method,
 * allowing the application to call any service without knowing
 * the details of its protocol or implementation.
 */
fun interface Gateway {
    /**
     * Executes the service operation.
     *
     * @throws Exception if the service encounters an error
     */
    fun execute()
}
