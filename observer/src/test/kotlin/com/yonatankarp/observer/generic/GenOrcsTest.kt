package com.yonatankarp.observer.generic

import com.yonatankarp.kotlin.junit.tools.logger.InMemoryLoggerAppender
import com.yonatankarp.observer.WeatherType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class GenOrcsTest {
    private val appender = InMemoryLoggerAppender()

    @BeforeEach
    fun setUp() {
        appender.start()
    }

    @AfterEach
    fun tearDown() {
        appender.stop()
        appender.clearAll()
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `should log correct message for weather type`(
        weather: WeatherType,
        expectedMessage: String,
    ) {
        // When
        GenOrcs().update(GenWeather(), weather)

        // Then
        assertEquals(expectedMessage, appender.lastMessage)
        assertEquals(1, appender.logSize)
    }

    companion object {
        @JvmStatic
        fun dataProvider() =
            listOf(
                arrayOf<Any>(
                    WeatherType.COLD,
                    "The orcs are facing Cold weather now",
                ),
                arrayOf<Any>(
                    WeatherType.RAINY,
                    "The orcs are facing Rainy weather now",
                ),
                arrayOf<Any>(
                    WeatherType.SUNNY,
                    "The orcs are facing Sunny weather now",
                ),
                arrayOf<Any>(
                    WeatherType.WINDY,
                    "The orcs are facing Windy weather now",
                ),
            )
    }
}
