package com.yonatankarp.command

/**
 * The Command pattern is a behavioral design pattern in which an
 * object is used to encapsulate all information needed to perform
 * an action or trigger an event at a later time.
 *
 * Four terms always associated with the command pattern are
 * command, receiver, invoker and client. A command object (spell)
 * knows about the receiver (target) and invokes a method of the
 * receiver. An invoker object ([Wizard]) receives a reference to
 * the command to be executed and optionally does bookkeeping about
 * the command execution. The client decides which commands to
 * execute at which points.
 *
 * In this example the wizard casts spells on the goblin. The
 * wizard keeps track of the previous spells cast, so it is easy
 * to undo them. In addition, the wizard keeps track of the spells
 * undone, so they can be redone.
 */
fun main() {
    val wizard = Wizard()
    val goblin = Goblin()

    goblin.printStatus()

    wizard.castSpell(goblin::changeSize)
    goblin.printStatus()

    wizard.castSpell(goblin::changeVisibility)
    goblin.printStatus()

    wizard.undoLastSpell()
    goblin.printStatus()

    wizard.undoLastSpell()
    goblin.printStatus()

    wizard.redoLastSpell()
    goblin.printStatus()

    wizard.redoLastSpell()
    goblin.printStatus()
}
