package com.yonatankarp.strategy

/**
 * Projectile strategy.
 */
internal class ProjectileStrategy : DragonSlayingStrategy {
    override fun execute() {
        logger.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!")
    }

    override fun toString() = "Projectile Strategy"
}
