package com.yonatankarp.flyweight

/**
 * A poison [Potion] shared via [PotionFactory].
 */
internal class PoisonPotion : Potion {
    override fun drink() =
        logger.info("Urgh! This is poisonous. (Potion=${hashCode()})")
}
