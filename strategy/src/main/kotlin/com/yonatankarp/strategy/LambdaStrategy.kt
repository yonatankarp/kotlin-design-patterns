package com.yonatankarp.strategy

object LambdaStrategy {
    fun meleeStrategy() =
        logger.info("With your Excalibur you sever the dragon's head!")

    fun projectileStrategy() =
        logger.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!")

    fun spellStrategy() =
        logger.info("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!")
}
