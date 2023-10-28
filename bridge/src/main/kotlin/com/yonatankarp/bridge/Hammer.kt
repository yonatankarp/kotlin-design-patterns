package com.yonatankarp.bridge

/**
 * Hammer.
 */
internal class Hammer(override val enchantment: Enchantment) : Weapon {
    override fun wield() {
        logger.info("The hammer is wielded.")
        enchantment.onActivate()
    }

    override fun swing() {
        logger.info("The hammer is swung.")
        enchantment.apply()
    }

    override fun unwield() {
        logger.info("The hammer is unwielded.")
        enchantment.onDeactivate()
    }
}
