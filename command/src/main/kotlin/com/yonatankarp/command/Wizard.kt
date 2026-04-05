package com.yonatankarp.command

import java.util.ArrayDeque

/**
 * The wizard is the invoker of the commands.
 *
 * Commands are represented as simple [() -> Unit][Function0] lambdas
 * (equivalent to Java's [Runnable]). The wizard keeps an undo stack
 * and a redo stack so that spells can be reversed and replayed.
 */
internal class Wizard {
    private val undoStack = ArrayDeque<() -> Unit>()
    private val redoStack = ArrayDeque<() -> Unit>()

    /**
     * Casts the given [spell] and pushes it onto the undo stack.
     */
    fun castSpell(spell: () -> Unit) {
        spell()
        undoStack.addLast(spell)
    }

    /**
     * Undoes the last spell by re-executing it (toggle behaviour)
     * and moves it to the redo stack.
     */
    fun undoLastSpell() {
        if (undoStack.isNotEmpty()) {
            val previousSpell = undoStack.removeLast()
            redoStack.addLast(previousSpell)
            previousSpell()
        }
    }

    /**
     * Redoes the last undone spell and moves it back to the
     * undo stack.
     */
    fun redoLastSpell() {
        if (redoStack.isNotEmpty()) {
            val previousSpell = redoStack.removeLast()
            undoStack.addLast(previousSpell)
            previousSpell()
        }
    }

    override fun toString() = "Wizard"
}
