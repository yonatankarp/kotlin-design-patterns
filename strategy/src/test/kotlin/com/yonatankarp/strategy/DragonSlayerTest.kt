package com.yonatankarp.strategy

import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class DragonSlayerTest {
    @Test
    fun `test go to battle`() {
        // Given
        val strategy = spyk<DragonSlayingStrategy>()
        val dragonSlayer = DragonSlayer(strategy)

        // When
        dragonSlayer.goToBattle()

        // Then
        verify(exactly = 1) { strategy.execute() }
        confirmVerified(strategy)
    }

    @Test
    fun `test change strategy`() {
        val initialStrategy = spyk<DragonSlayingStrategy>()
        val dragonSlayer = DragonSlayer(initialStrategy)

        dragonSlayer.goToBattle()

        verify(exactly = 1) { initialStrategy.execute() }

        val newStrategy = spyk<DragonSlayingStrategy>()
        dragonSlayer.changeStrategy(newStrategy)

        dragonSlayer.goToBattle()

        verify(exactly = 1) { newStrategy.execute() }
        confirmVerified(initialStrategy, newStrategy)
    }
}
