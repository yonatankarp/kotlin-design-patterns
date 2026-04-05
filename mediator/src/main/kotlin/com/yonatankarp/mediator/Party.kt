package com.yonatankarp.mediator

/**
 * The mediator interface that coordinates interactions between
 * [PartyMember] instances.
 *
 * When a member performs an action the party notifies every other
 * member, decoupling the members from one another.
 */
interface Party {
    /**
     * Adds a [member] to this party.
     */
    fun addMember(member: PartyMember)

    /**
     * Broadcasts the [action] performed by [actor] to every other
     * party member.
     */
    fun act(actor: PartyMember, action: Action)
}
