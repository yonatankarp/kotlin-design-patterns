package com.yonatankarp.mediator

/**
 * The Mediator pattern defines an object that encapsulates how a set
 * of objects interact. This pattern is considered to be a behavioral
 * pattern due to the way it can alter the program's running behavior.
 *
 * With the Mediator pattern, communication between objects is
 * encapsulated within a mediator object. Objects no longer communicate
 * directly with each other, but instead communicate through the
 * mediator. This reduces the dependencies between communicating
 * objects, thereby lowering the coupling.
 *
 * In this example the mediator encapsulates how a set of objects
 * ([PartyMember]) interact. Instead of referring to each other
 * directly they use the mediator ([Party]) interface.
 */

/**
 * Program entry point.
 */
fun main() {
    // create party and members
    val party: Party = AdventuringParty()
    val hobbit = Hobbit()
    val wizard = Wizard()
    val rogue = Rogue()
    val hunter = Hunter()

    // add party members
    party.addMember(hobbit)
    party.addMember(wizard)
    party.addMember(rogue)
    party.addMember(hunter)

    // perform actions -> the other party members
    // are notified by the party
    hobbit.act(Action.ENEMY)
    wizard.act(Action.TALE)
    rogue.act(Action.GOLD)
    hunter.act(Action.HUNT)
}
