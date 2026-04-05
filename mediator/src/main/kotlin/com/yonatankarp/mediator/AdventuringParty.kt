package com.yonatankarp.mediator

/**
 * Concrete [Party] mediator that keeps track of its members and
 * relays actions to every member except the one who performed it.
 */
internal class AdventuringParty : Party {
    private val members = mutableListOf<PartyMember>()

    override fun addMember(member: PartyMember) {
        members.add(member)
        member.joinedParty(this)
    }

    override fun act(actor: PartyMember, action: Action) {
        members
            .filter { it != actor }
            .forEach { it.partyAction(action) }
    }
}
