package com.yonatankarp.strategy

import com.yonatankarp.strategy.EnumStrategy.Strategy.MELEE_STRATEGY
import com.yonatankarp.strategy.EnumStrategy.Strategy.PROJECTILE_STRATEGY
import com.yonatankarp.strategy.EnumStrategy.Strategy.SPELL_STRATEGY
import com.yonatankarp.strategy.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class DragonSlayingStrategyTest {
    private val appender = InMemoryAppender()

    @BeforeEach
    fun setUp() {
        appender.start()
    }

    @AfterEach
    fun tearDown() {
        appender.stop()
        appender.clearAll()
    }

    @ParameterizedTest(name = "test execute {0}")
    @MethodSource("dataProvider")
    fun `test execute`(strategy: DragonSlayingStrategy, expectedResult: String) {
        strategy.execute()
        assertEquals(expectedResult, appender.lastMessage)
        assertEquals(1, appender.size)
    }

    companion object {
        @JvmStatic
        fun dataProvider() =
            listOf(
                arrayOf(
                    MeleeStrategy(),
                    "With your Excalibur you sever the dragon's head!"
                ),
                arrayOf(
                    ProjectileStrategy(),
                    "You shoot the dragon with the magical crossbow and it falls dead on the ground!"
                ),
                arrayOf(
                    SpellStrategy(),
                    "You cast the spell of disintegration and the dragon vaporizes in a pile of dust!"
                ),
                arrayOf(
                    MELEE_STRATEGY,
                    "With your Excalibur you sever the dragon's head!"
                ),
                arrayOf(
                    PROJECTILE_STRATEGY,
                    "You shoot the dragon with the magical crossbow and it falls dead on the ground!"
                ),
                arrayOf(
                    SPELL_STRATEGY,
                    "You cast the spell of disintegration and the dragon vaporizes in a pile of dust!"
                )
            )
    }
}
