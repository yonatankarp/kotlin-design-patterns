package com.yonatankarp.mediator

import org.slf4j.LoggerFactory

/**
 * Abstract base class for [PartyMember] implementations.
 *
 * Subclasses only need to provide a human-readable [toString]
 * representation; all mediator interaction logic is handled here.
 */
sealed class PartyMemberBase : PartyMember {
    private val logger = LoggerFactory.getLogger(javaClass)

    private var party: Party? = null

    override fun joinedParty(party: Party) {
        logger.info("$this joins the party")
        this.party = party
    }

    override fun partyAction(action: Action) {
        logger.info("$this ${action.description}")
    }

    override fun act(action: Action) {
        party?.let {
            logger.info("$this $action")
            it.act(this, action)
        }
    }

    abstract override fun toString(): String
}
