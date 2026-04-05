package com.yonatankarp.observer.generic

import com.yonatankarp.observer.WeatherType
import org.slf4j.LoggerFactory

/**
 * A [Race] observer representing the hobbits in the
 * generic-observer variant.
 */
internal class GenHobbits : Race {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun update(subject: GenWeather, argument: WeatherType) {
        logger.info("The hobbits are facing ${argument.description} weather now")
    }
}
