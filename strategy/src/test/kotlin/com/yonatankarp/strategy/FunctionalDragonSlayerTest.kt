package com.yonatankarp.strategy

import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class FunctionalDragonSlayerTest {
    @Test
    fun `test go to battle`() {
        // Given
        val strategy = spyk<Strategy>()
        val dragonSlayer = FunctionalDragonSlayer(strategy)

        // When
        dragonSlayer.goToBattle()

        // Then
        verify(exactly = 1) { strategy.invoke() }
        confirmVerified(strategy)
    }

    @Test
    fun `test change strategy`() {
        val initialStrategy = spyk<Strategy>()
        val dragonSlayer = DragonSlayer(initialStrategy)

        dragonSlayer.goToBattle()

        verify(exactly = 1) { initialStrategy.invoke() }

        val newStrategy = spyk<Strategy>()
        dragonSlayer.changeStrategy(newStrategy)

        dragonSlayer.goToBattle()

        verify(exactly = 1) { newStrategy.invoke() }
        confirmVerified(initialStrategy, newStrategy)
    }
}
