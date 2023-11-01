package com.yonatankarp.strategy

import com.yonatankarp.strategy.EnumStrategy.Strategy.MELEE_STRATEGY
import com.yonatankarp.strategy.EnumStrategy.Strategy.PROJECTILE_STRATEGY
import com.yonatankarp.strategy.EnumStrategy.Strategy.SPELL_STRATEGY
import org.slf4j.LoggerFactory

private const val RED_DRAGON_EMERGES = "Red dragon emerges."
private const val GREEN_DRAGON_SPOTTED = "Green dragon spotted ahead!"
private const val BLACK_DRAGON_LANDS = "Black dragon lands before you."

/**
 * The Strategy pattern (also known as the policy pattern) is a software design
 * pattern that enables an algorithm's behavior to be selected at runtime.
 *
 * With Kotlin, it is easy to pass behavior with method references and lambdas
 * making the code shorter and more readable.
 *
 * In this example ({@link DragonSlayingStrategy}) encapsulates an algorithm.
 * The containing object ({@link DragonSlayer}) can alter its behavior by
 * changing its strategy.
 */

internal val logger = LoggerFactory.getLogger("com.yonatankarp.strategy")

/**
 * Program entry point.
 */
fun main() {
    // GoF Strategy pattern
    logger.info(GREEN_DRAGON_SPOTTED)
    val gofDragonSlayer = DragonSlayer(MeleeStrategy())
    gofDragonSlayer.goToBattle()

    logger.info(RED_DRAGON_EMERGES)
    gofDragonSlayer.changeStrategy(ProjectileStrategy())
    gofDragonSlayer.goToBattle()

    logger.info(BLACK_DRAGON_LANDS)
    gofDragonSlayer.changeStrategy(SpellStrategy())
    gofDragonSlayer.goToBattle()

    // functional interface implementation Strategy pattern
    logger.info(GREEN_DRAGON_SPOTTED)
    val functionalDragonSlayer = DragonSlayer { logger.info("With your Excalibur you severe the dragon's head!") }
    functionalDragonSlayer.goToBattle()

    logger.info(RED_DRAGON_EMERGES)
    functionalDragonSlayer.changeStrategy { logger.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!") }
    functionalDragonSlayer.goToBattle()

    logger.info(BLACK_DRAGON_LANDS)
    functionalDragonSlayer.changeStrategy { logger.info("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!") }
    functionalDragonSlayer.goToBattle()

    // enum Strategy pattern
    logger.info(GREEN_DRAGON_SPOTTED)
    val enumDragonSlayer = DragonSlayer(MELEE_STRATEGY)
    enumDragonSlayer.goToBattle()

    logger.info(RED_DRAGON_EMERGES)
    enumDragonSlayer.changeStrategy(PROJECTILE_STRATEGY)
    enumDragonSlayer.goToBattle()

    logger.info(BLACK_DRAGON_LANDS)
    enumDragonSlayer.changeStrategy(SPELL_STRATEGY)
    enumDragonSlayer.goToBattle()

    // Functional lambda implementation Strategy pattern
    logger.info(GREEN_DRAGON_SPOTTED)
    val lambdaDragonSlayer = FunctionalDragonSlayer(LambdaStrategy::meleeStrategy)
    lambdaDragonSlayer.goToBattle()

    logger.info(RED_DRAGON_EMERGES)
    lambdaDragonSlayer.changeStrategy(LambdaStrategy::projectileStrategy)
    lambdaDragonSlayer.goToBattle()

    logger.info(BLACK_DRAGON_LANDS)
    lambdaDragonSlayer.changeStrategy(LambdaStrategy::spellStrategy)
    lambdaDragonSlayer.goToBattle()
}
