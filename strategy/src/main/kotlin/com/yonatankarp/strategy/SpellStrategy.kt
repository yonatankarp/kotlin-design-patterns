package com.yonatankarp.strategy

/**
 * Spell strategy.
 */
internal class SpellStrategy : DragonSlayingStrategy {
    override fun execute() {
        logger.info("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!")
    }

    override fun toString() = "Spell Strategy"
}
