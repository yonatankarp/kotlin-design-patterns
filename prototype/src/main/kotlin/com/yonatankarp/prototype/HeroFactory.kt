package com.yonatankarp.prototype

class HeroFactory(
    private val mage: Mage,
    private val warlord: Warlord,
    private val beast: Beast,
) {
    /**
     * Create Mage.
     */
    fun createMage() = mage.clone()

    /**
     * Create Warlord.
     */
    fun createWarlord() = warlord.clone()

    /**
     * Create Beast.
     */
    fun createBeast() = beast.clone()
}
