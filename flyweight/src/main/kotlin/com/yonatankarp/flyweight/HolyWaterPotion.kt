package com.yonatankarp.flyweight

/**
 * A holy water [Potion] shared via [PotionFactory].
 */
internal class HolyWaterPotion : Potion {
    override fun drink() =
        logger.info("You feel blessed. (Potion=${hashCode()})")
}
