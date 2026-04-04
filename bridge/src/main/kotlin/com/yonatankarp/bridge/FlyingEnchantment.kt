package com.yonatankarp.bridge

/**
 * An [Enchantment] that makes the [Weapon] fly and strike.
 */
internal class FlyingEnchantment : Enchantment {
    override fun onActivate() {
        logger.info("The item begins to glow faintly.")
    }

    override fun apply() {
        logger.info("The item flies and strikes the enemies finally returning to owner's hand.")
    }

    override fun onDeactivate() {
        logger.info("The item's glow fades.")
    }
}
