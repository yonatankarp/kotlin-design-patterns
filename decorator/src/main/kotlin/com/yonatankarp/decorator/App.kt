package com.yonatankarp.decorator

import org.slf4j.LoggerFactory

/**
 * The Decorator pattern is a more flexible alternative to subclassing. The
 * Decorator class implements the same interface as the target and uses
 * composition to "decorate" calls to the target. Using the Decorator pattern
 * it is possible to change the behavior of the class during runtime.
 *
 * In this example we show how the simple [SimpleTroll] first attacks and then
 * flees the battle. Then we decorate the [SimpleTroll] with a [ClubbedTroll]
 * and perform the attack again. You can see how the behavior changes after the
 * decoration.
 */
fun main() {
    val logger = LoggerFactory.getLogger("com.yonatankarp.decorator")

    // simple troll
    logger.info("A simple looking troll approaches.")
    val troll = SimpleTroll()
    troll.attack()
    troll.fleeBattle()
    logger.info("Simple troll power: ${troll.attackPower}.\n")

    // change the behavior of the simple troll by adding a decorator
    logger.info("A troll with huge club surprises you.")
    val clubbedTroll = ClubbedTroll(troll)
    clubbedTroll.attack()
    clubbedTroll.fleeBattle()
    logger.info("Clubbed troll power: ${clubbedTroll.attackPower}.\n")
}
