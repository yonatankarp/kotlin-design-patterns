package com.yonatankarp.flyweight

/**
 * InvisibilityPotion.
 */
internal class InvisibilityPotion : Potion {
    override fun drink() =
        logger.info("You become invisible. (Potion=${hashCode()})")
}
