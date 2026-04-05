package com.yonatankarp.command

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Verifies that the [Wizard] can cast, undo, and redo spells
 * on a [Goblin] target.
 */
internal class CommandTest {
    @Test
    fun `should cast spell and change goblin size`() {
        // Given
        val wizard = Wizard()
        val goblin = Goblin()

        // When
        wizard.castSpell(goblin::changeSize)

        // Then
        verifyGoblin(goblin, "Goblin", Size.SMALL, Visibility.VISIBLE)
    }

    @Test
    fun `should cast spell and change goblin visibility`() {
        // Given
        val wizard = Wizard()
        val goblin = Goblin()
        wizard.castSpell(goblin::changeSize)

        // When
        wizard.castSpell(goblin::changeVisibility)

        // Then
        verifyGoblin(goblin, "Goblin", Size.SMALL, Visibility.INVISIBLE)
    }

    @Test
    fun `should undo last spell`() {
        // Given
        val wizard = Wizard()
        val goblin = Goblin()
        wizard.castSpell(goblin::changeSize)
        wizard.castSpell(goblin::changeVisibility)

        // When
        wizard.undoLastSpell()

        // Then
        verifyGoblin(goblin, "Goblin", Size.SMALL, Visibility.VISIBLE)
    }

    @Test
    fun `should undo all spells`() {
        // Given
        val wizard = Wizard()
        val goblin = Goblin()
        wizard.castSpell(goblin::changeSize)
        wizard.castSpell(goblin::changeVisibility)

        // When
        wizard.undoLastSpell()
        wizard.undoLastSpell()

        // Then
        verifyGoblin(goblin, "Goblin", Size.NORMAL, Visibility.VISIBLE)
    }

    @Test
    fun `should redo last spell`() {
        // Given
        val wizard = Wizard()
        val goblin = Goblin()
        wizard.castSpell(goblin::changeSize)
        wizard.castSpell(goblin::changeVisibility)
        wizard.undoLastSpell()
        wizard.undoLastSpell()

        // When
        wizard.redoLastSpell()

        // Then
        verifyGoblin(goblin, "Goblin", Size.SMALL, Visibility.VISIBLE)
    }

    @Test
    fun `should redo all spells`() {
        // Given
        val wizard = Wizard()
        val goblin = Goblin()
        wizard.castSpell(goblin::changeSize)
        wizard.castSpell(goblin::changeVisibility)
        wizard.undoLastSpell()
        wizard.undoLastSpell()

        // When
        wizard.redoLastSpell()
        wizard.redoLastSpell()

        // Then
        verifyGoblin(goblin, "Goblin", Size.SMALL, Visibility.INVISIBLE)
    }

    @Test
    fun `should do nothing when undoing with no spells cast`() {
        // Given
        val wizard = Wizard()
        val goblin = Goblin()

        // When
        wizard.undoLastSpell()

        // Then
        verifyGoblin(goblin, "Goblin", Size.NORMAL, Visibility.VISIBLE)
    }

    @Test
    fun `should do nothing when redoing with no spells undone`() {
        // Given
        val wizard = Wizard()
        val goblin = Goblin()

        // When
        wizard.redoLastSpell()

        // Then
        verifyGoblin(goblin, "Goblin", Size.NORMAL, Visibility.VISIBLE)
    }

    private fun verifyGoblin(
        goblin: Goblin,
        expectedName: String,
        expectedSize: Size,
        expectedVisibility: Visibility,
    ) {
        assertEquals(expectedName, goblin.toString())
        assertEquals(expectedSize, goblin.size)
        assertEquals(expectedVisibility, goblin.visibility)
    }
}
