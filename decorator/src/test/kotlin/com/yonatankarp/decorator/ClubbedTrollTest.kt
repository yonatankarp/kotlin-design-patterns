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
        // Given
        val simpleTroll = spyk<SimpleTroll>()
        val clubbed = ClubbedTroll(simpleTroll)

        // When / Then — attack power is combined
        assertEquals(20, clubbed.attackPower)
        verify(exactly = 1) { simpleTroll.attackPower }

        // When / Then — actions are delegated
        clubbed.attack()
        verify(exactly = 1) { simpleTroll.attack() }
        clubbed.fleeBattle()
        verify(exactly = 1) { simpleTroll.fleeBattle() }

        confirmVerified(simpleTroll)
    }
}
