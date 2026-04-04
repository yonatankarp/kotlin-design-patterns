package com.yonatankarp.bridge

/**
 * An [Enchantment] that spreads bloodlust and devours souls.
 */
internal class SoulEatingEnchantment : Enchantment {
    override fun onActivate() {
        logger.info("The item spreads bloodlust.")
    }

    override fun apply() {
        logger.info("The item eats the soul of enemies.")
    }

    override fun onDeactivate() {
        logger.info("Bloodlust slowly disappears.")
    }
}
