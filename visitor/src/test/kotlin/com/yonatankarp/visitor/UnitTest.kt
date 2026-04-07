package com.yonatankarp.visitor

import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test

/**
 * Tests for the [Unit] hierarchy ensuring that each concrete unit
 * correctly delegates to the visitor and propagates to children.
 */
internal class UnitTest {
    @Test
    fun `commander should visit itself then children`() {
        // Given
        val visitor = mockk<UnitVisitor>(relaxed = true)
        val soldier = Soldier()
        val sergeant = Sergeant(listOf(soldier))
        val commander = Commander(listOf(sergeant))

        // When
        commander.accept(visitor)

        // Then
        verifyOrder {
            visitor.visit(commander)
            visitor.visit(sergeant)
            visitor.visit(soldier)
        }
    }

    @Test
    fun `sergeant should visit itself then children`() {
        // Given
        val visitor = mockk<UnitVisitor>(relaxed = true)
        val soldier1 = Soldier()
        val soldier2 = Soldier()
        val sergeant = Sergeant(listOf(soldier1, soldier2))

        // When
        sergeant.accept(visitor)

        // Then
        verifyOrder {
            visitor.visit(sergeant)
            visitor.visit(soldier1)
            visitor.visit(soldier2)
        }
    }

    @Test
    fun `soldier should visit only itself`() {
        val visitor = mockk<UnitVisitor>(relaxed = true)
        val soldier = Soldier()

        soldier.accept(visitor)

        verify(exactly = 1) { visitor.visit(soldier) }
    }

    @Test
    fun `commander toString should return commander`() {
        assert(Commander().toString() == "commander")
    }

    @Test
    fun `sergeant toString should return sergeant`() {
        assert(Sergeant().toString() == "sergeant")
    }

    @Test
    fun `soldier toString should return soldier`() {
        assert(Soldier().toString() == "soldier")
    }
}
