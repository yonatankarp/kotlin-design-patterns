package com.yonatankarp.decorator

import org.slf4j.LoggerFactory

/**
 * Decorator that adds a club for the troll.
 */
class ClubbedTroll(private val decorated: Troll) : Troll {
    override val attackPower: Int
        get() = decorated.attackPower + CLUB_ATTACK_POWER

    override fun attack() {
        decorated.attack()
        logger.info("The troll swings at you with a club!")
    }

    override fun fleeBattle() {
        decorated.fleeBattle()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ClubbedTroll::class.java)
        private const val CLUB_ATTACK_POWER = 10
    }
}
