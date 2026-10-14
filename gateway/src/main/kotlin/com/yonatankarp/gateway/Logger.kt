package com.yonatankarp.gateway

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/** Delay in milliseconds used to simulate a time-consuming service call. */
internal const val SIMULATED_DELAY_MS = 100L

/**
 * Shared logger for the gateway module.
 */
internal val logger: Logger =
    LoggerFactory.getLogger("com.yonatankarp.gateway")
