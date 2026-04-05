package com.yonatankarp.observer.generic

import com.yonatankarp.observer.WeatherType
import org.slf4j.LoggerFactory

/**
 * Generic-observer variant of the weather subject.
 *
 * Extends [Observable] so that registered [Race] observers are
 * notified with both the subject reference and the new
 * [WeatherType] whenever [timePasses] is called.
 */
class GenWeather :
    Observable<GenWeather, WeatherType>() {
    private val logger = LoggerFactory.getLogger(javaClass)
    private var currentWeather = WeatherType.SUNNY

    /**
     * Advances the weather to the next [WeatherType] in the
     * cycle and notifies all registered observers.
     */
    fun timePasses() {
        val values = WeatherType.entries
        currentWeather =
            values[(currentWeather.ordinal + 1) % values.size]
        logger.info("The weather changed to $currentWeather.")
        notifyObservers(currentWeather)
    }
}
