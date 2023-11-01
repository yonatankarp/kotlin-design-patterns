package com.yonatankarp.strategy

/**
 * Melee strategy.
 */
internal class MeleeStrategy : DragonSlayingStrategy {
    override fun execute() {
        logger.info("With your Excalibur you sever the dragon's head!")
    }

    override fun toString() = "Melee Strategy"
}
