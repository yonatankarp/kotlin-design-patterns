package com.yonatankarp.observer

/**
 * Functional interface for observing [WeatherType] changes.
 */
fun interface WeatherObserver {
    /**
     * Called when the observed weather changes.
     *
     * @param currentWeather the new [WeatherType]
     */
    fun update(currentWeather: WeatherType)
}
