package com.yonatankarp.observer

/**
 * Enumerates the possible weather conditions that can be observed.
 */
enum class WeatherType(val description: String) {
    COLD("Cold"),
    RAINY("Rainy"),
    SUNNY("Sunny"),
    WINDY("Windy"),
    ;

    override fun toString() = name.lowercase()
}
