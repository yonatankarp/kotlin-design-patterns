package com.yonatankarp.flyweight

/**
 * A strength [Potion] shared via [PotionFactory].
 */
internal class StrengthPotion : Potion {
    override fun drink() =
        logger.info("You feel strong. (Potion=${hashCode()})")
}
