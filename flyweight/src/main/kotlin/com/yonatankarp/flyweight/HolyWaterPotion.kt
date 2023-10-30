package com.yonatankarp.flyweight

/**
 * HolyWaterPotion.
 */
internal class HolyWaterPotion : Potion {
    override fun drink() =
        logger.info("You feel blessed. (Potion=${hashCode()})")
}
