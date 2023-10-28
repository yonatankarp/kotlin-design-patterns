package com.yonatankarp.bridge

import org.slf4j.LoggerFactory

/**
 * Composition over inheritance. The Bridge pattern can also be thought of as
 * two layers of abstraction. With Bridge, you can decouple an abstraction from
 * its implementation so that the two can vary independently.
 *
 * In Bridge pattern both abstraction ({@link Weapon}) and implementation
 * ({@link Enchantment}) have their own class hierarchies. The interface of the
 * implementations can be changed without affecting the clients.
 *
 * In this example we have two class hierarchies. One of weapons and another one
 * of enchantments. We can easily combine any weapon with any enchantment using
 * composition instead of creating deep class hierarchy.
 */

internal val logger = LoggerFactory.getLogger("com.yonatankarp.bridge")

fun main() {
    logger.info("The knight receives an enchanted sword.")
    val enchantedSword = Sword(SoulEatingEnchantment())
    enchantedSword.wield()
    enchantedSword.swing()
    enchantedSword.unwield()

    logger.info("The valkyrie receives an enchanted hammer.")
    val hammer = Hammer(FlyingEnchantment())
    hammer.wield()
    hammer.swing()
    hammer.unwield()
}
