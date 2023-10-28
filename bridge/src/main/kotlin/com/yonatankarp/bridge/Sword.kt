package com.yonatankarp.bridge

/**
 * Sword.
 */
internal class Sword(override val enchantment: Enchantment) : Weapon {
    override fun wield() {
        logger.info("The sword is wielded.")
        enchantment.onActivate()
    }

    override fun swing() {
        logger.info("The sword is swung.")
        enchantment.apply()
    }

    override fun unwield() {
        logger.info("The sword is unwielded.")
        enchantment.onDeactivate()
    }
}
