package com.yonatankarp.strategy

/**
 * Enum strategy pattern.
 */
internal class EnumStrategy {
    /**
     * Enum to demonstrate strategy pattern.
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
