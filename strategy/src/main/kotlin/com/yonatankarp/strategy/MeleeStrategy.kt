package com.yonatankarp.strategy

/**
 * A [DragonSlayingStrategy] using close-combat melee attacks.
 */
internal class MeleeStrategy : DragonSlayingStrategy {
    override fun execute() {
        logger.info("With your Excalibur you sever the dragon's head!")
    }

    override fun toString() = "Melee Strategy"
}
