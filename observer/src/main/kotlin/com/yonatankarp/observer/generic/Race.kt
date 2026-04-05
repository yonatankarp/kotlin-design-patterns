package com.yonatankarp.observer.generic

import com.yonatankarp.observer.WeatherType

/**
 * A type alias binding [Observer] to the weather domain:
 * observes [GenWeather] subjects and receives [WeatherType]
 * arguments.
 */
fun interface Race : Observer<GenWeather, WeatherType>
