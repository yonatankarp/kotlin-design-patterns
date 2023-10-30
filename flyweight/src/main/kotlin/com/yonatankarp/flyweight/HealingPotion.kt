package com.yonatankarp.flyweight

/**
 * HealingPotion.
 */
internal class HealingPotion : Potion {
    override fun drink() =
        logger.info("You feel healed. (Potion=${hashCode()})")
}
