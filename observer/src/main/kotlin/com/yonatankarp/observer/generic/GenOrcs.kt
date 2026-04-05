package com.yonatankarp.observer.generic

import com.yonatankarp.observer.WeatherType
import org.slf4j.LoggerFactory

/**
 * A [Race] observer representing the orcs in the
 * generic-observer variant.
 */
internal class GenOrcs : Race {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun update(subject: GenWeather, argument: WeatherType) {
        logger.info("The orcs are facing ${argument.description} weather now")
    }
}
