package com.yonatankarp.mediator

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

/**
 * Verifies that [AdventuringParty] correctly relays actions
 * between members through the mediator.
 */
internal class AdventuringPartyTest {
    @Test
    fun `should notify other members but not the actor`() {
        // Given
        val member1 = mockk<PartyMember>(relaxed = true)
        val member2 = mockk<PartyMember>(relaxed = true)
        val party = AdventuringParty()

        // When
        party.addMember(member1)
        party.addMember(member2)

        // Then
        verify { member1.joinedParty(party) }
        verify { member2.joinedParty(party) }

        // When
        party.act(member1, Action.GOLD)

        // Then
        verify(exactly = 0) { member1.partyAction(any()) }
        verify { member2.partyAction(Action.GOLD) }
    }
}
