package com.yonatankarp.decorator

import org.slf4j.LoggerFactory

/**
 * SimpleTroll implements [Troll] interface directly.
 */
class SimpleTroll : Troll {
    override val attackPower: Int
        get() = ATTACK_POWER
    override fun attack() {
        logger.info("The troll tries to grab you!")
    }

    override fun fleeBattle() {
        logger.info("The troll shrieks in horror and runs away!")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SimpleTroll::class.java)
        private const val ATTACK_POWER = 10
    }
}
