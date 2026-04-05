package com.yonatankarp.observer

import org.slf4j.LoggerFactory

/**
 * A [WeatherObserver] representing the hobbits, who react to
 * weather changes.
 */
internal class Hobbits : WeatherObserver {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun update(currentWeather: WeatherType) {
        logger.info("The hobbits are facing ${currentWeather.description} weather now")
    }
}
