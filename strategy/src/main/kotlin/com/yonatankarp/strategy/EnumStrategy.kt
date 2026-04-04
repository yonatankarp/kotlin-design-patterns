package com.yonatankarp.strategy

/**
 * Demonstrates the strategy pattern using an enum that
 * delegates to [DragonSlayingStrategy] instances.
 */
internal class EnumStrategy {
    /**
     * Enum entries that each delegate to a
     * [DragonSlayingStrategy] lambda.
     */
    internal enum class Strategy(private val dragonSlayingStrategy: DragonSlayingStrategy) :
        DragonSlayingStrategy {
        MELEE_STRATEGY(
            DragonSlayingStrategy {
                logger.info(
                    "With your Excalibur you sever the dragon's head!"
                )
            }
        ),
        PROJECTILE_STRATEGY(
            DragonSlayingStrategy {
                logger.info(
                    "You shoot the dragon with the magical crossbow and it falls dead on the ground!"
                )
            }
        ),
        SPELL_STRATEGY(
            DragonSlayingStrategy {
                logger.info(
                    "You cast the spell of disintegration and the dragon vaporizes in a pile of dust!"
                )
            }
        ),
        ;

        override fun execute() {
            dragonSlayingStrategy.execute()
        }
    }
}
