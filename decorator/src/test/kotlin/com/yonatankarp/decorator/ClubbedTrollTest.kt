package com.yonatankarp.decorator

import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Tests for [ClubbedTroll]
 */
internal class ClubbedTrollTest {
    @Test
    fun `test clubbed troll`() {
        // Create a normal troll first, but make sure we can spy on it later on.
        val simpleTroll = spyk<SimpleTroll>()

        // Now we want to decorate the troll to make it stronger ...
        val clubbed = ClubbedTroll(simpleTroll)
        assertEquals(20, clubbed.attackPower)
        verify(exactly = 1) { simpleTroll.attackPower }

        // Check if the clubbed troll actions are delegated to the decorated troll
        clubbed.attack()
        verify(exactly = 1) { simpleTroll.attack() }
        clubbed.fleeBattle()
        verify(exactly = 1) { simpleTroll.fleeBattle() }

        confirmVerified(simpleTroll)
    }
}
