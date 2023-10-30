package com.yonatankarp.flyweight

/**
 * StrengthPotion.
 */
class StrengthPotion : Potion {
    override fun drink() =
        logger.info("You feel strong. (Potion=${hashCode()})")
}
