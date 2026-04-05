package com.yonatankarp.observer

import org.slf4j.LoggerFactory

/**
 * A [WeatherObserver] representing the orcs, who react to
 * weather changes.
 */
internal class Orcs : WeatherObserver {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun update(currentWeather: WeatherType) {
        logger.info("The orcs are facing ${currentWeather.description} weather now")
    }
}
