package com.yonatankarp.mediator

/**
 * Interface for party members that interact through a [Party]
 * mediator.
 */
interface PartyMember {
    /**
     * Called when this member joins the given [party].
     */
    fun joinedParty(party: Party)

    /**
     * Called by the [Party] to notify this member of another
     * member's [action].
     */
    fun partyAction(action: Action)

    /**
     * Performs the given [action] and notifies the party.
     */
    fun act(action: Action)
}
