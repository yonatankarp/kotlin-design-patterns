package com.yonatankarp.flyweight

/**
 * A healing [Potion] shared via [PotionFactory].
 */
internal class HealingPotion : Potion {
    override fun drink() =
        logger.info("You feel healed. (Potion=${hashCode()})")
}
