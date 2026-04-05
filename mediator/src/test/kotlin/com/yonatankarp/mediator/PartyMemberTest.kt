package com.yonatankarp.mediator

import com.yonatankarp.kotlin.junit.tools.logger.InMemoryLoggerAppender
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

/**
 * Verifies logging and mediator interaction for all
 * [PartyMemberBase] subclasses.
 */
internal class PartyMemberTest {
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
    @MethodSource("memberProvider")
    fun `should log reaction for each party action`(
        member: PartyMember,
    ) {
        Action.entries.forEach { action ->
            member.partyAction(action)
            assertTrue(
                appender.logContains("$member ${action.description}"),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("memberProvider")
    fun `should delegate action to party when joined`(
        member: PartyMember,
    ) {
        // Given
        val party = mockk<Party>(relaxed = true)

        // When — join a party
        member.joinedParty(party)

        // Then
        assertTrue(appender.logContains("$member joins the party"))

        // When — act after joining
        member.act(Action.GOLD)

        // Then
        assertTrue(appender.logContains("$member ${Action.GOLD}"))
        verify { party.act(member, Action.GOLD) }
    }

    @ParameterizedTest
    @MethodSource("memberProvider")
    fun `should have class name as toString`(member: PartyMember) =
        assertTrue(member.toString() == member.javaClass.simpleName)

    companion object {
        @JvmStatic
        fun memberProvider(): List<PartyMember> =
            listOf(Hobbit(), Hunter(), Rogue(), Wizard())
    }
}
