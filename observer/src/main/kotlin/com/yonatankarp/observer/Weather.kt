package com.yonatankarp.observer

import org.slf4j.LoggerFactory

/**
 * The subject in the Observer pattern. [Weather] maintains a list of
 * [WeatherObserver] instances and notifies them whenever the weather
 * changes via [timePasses].
 */
class Weather {
    private val logger = LoggerFactory.getLogger(javaClass)

    private val observers = mutableListOf<WeatherObserver>()
    private var currentWeather = WeatherType.SUNNY

    /**
     * Registers an [observer] to receive weather updates.
     */
    fun addObserver(observer: WeatherObserver) {
        observers.add(observer)
    }

    /**
     * Unregisters an [observer] so it no longer receives updates.
     */
    fun removeObserver(observer: WeatherObserver) {
        observers.remove(observer)
    }

    /**
     * Advances the weather to the next [WeatherType] in the cycle
     * and notifies all registered observers.
     */
    fun timePasses() {
        val values = WeatherType.entries
        currentWeather = values[(currentWeather.ordinal + 1) % values.size]
        logger.info("The weather changed to $currentWeather.")
        notifyObservers()
    }

    private fun notifyObservers() {
        observers.forEach { it.update(currentWeather) }
    }
}
