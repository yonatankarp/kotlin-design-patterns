package com.yonatankarp.flyweight

/**
 * PoisonPotion.
 */
class PoisonPotion : Potion {
    override fun drink() =
        logger.info("Urgh! This is poisonous. (Potion=${hashCode()})")
}
