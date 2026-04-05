package com.yonatankarp.observer

import com.yonatankarp.kotlin.junit.tools.logger.InMemoryLoggerAppender
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class WeatherTest {
    private val appender = InMemoryLoggerAppender(Weather::class.java)

    @BeforeEach
    fun setUp() {
        appender.start()
    }

    @AfterEach
    fun tearDown() {
        appender.stop()
        appender.clearAll()
    }

    @Test
    fun `should notify observer on weather change and stop after removal`() {
        // Given
        val observer = mockk<WeatherObserver>(relaxed = true)
        val weather = Weather()
        weather.addObserver(observer)

        // When — SUNNY -> WINDY
        weather.timePasses()

        // Then
        assertEquals(
            "The weather changed to windy.",
            appender.lastMessage,
        )
        verify { observer.update(WeatherType.WINDY) }

        // When — remove observer, WINDY -> COLD
        weather.removeObserver(observer)
        weather.timePasses()

        // Then
        assertEquals(
            "The weather changed to cold.",
            appender.lastMessage,
        )
        verify(exactly = 1) { observer.update(any()) }
        assertEquals(2, appender.logSize)
    }

    @Test
    fun `should cycle through all weather types in order`() {
        // Given
        val observer = mockk<WeatherObserver>(relaxed = true)
        val weather = Weather()
        weather.addObserver(observer)
        val weatherTypes = WeatherType.entries
        val startIndex = WeatherType.SUNNY.ordinal

        // When
        repeat(weatherTypes.size) { weather.timePasses() }

        // Then
        weatherTypes.indices.forEach { i ->
            verify {
                observer.update(
                    weatherTypes[(startIndex + i + 1) % weatherTypes.size],
                )
            }
        }
    }
}
