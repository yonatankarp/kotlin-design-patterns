package com.yonatankarp.flyweight

/**
 * An invisibility [Potion] shared via [PotionFactory].
 */
internal class InvisibilityPotion : Potion {
    override fun drink() =
        logger.info("You become invisible. (Potion=${hashCode()})")
}
