package com.yonatankarp.prototype

/**
 * Factory that creates new creatures by cloning prototype
 * [Mage], [Warlord], and [Beast] instances.
 */
class HeroFactory(
    private val mage: Mage,
    private val warlord: Warlord,
    private val beast: Beast,
) {
    /**
     * Returns a clone of the prototype [Mage].
     */
    fun createMage() = mage.clone()

    /**
     * Returns a clone of the prototype [Warlord].
     */
    fun createWarlord() = warlord.clone()

    /**
     * Returns a clone of the prototype [Beast].
     */
    fun createBeast() = beast.clone()
}
