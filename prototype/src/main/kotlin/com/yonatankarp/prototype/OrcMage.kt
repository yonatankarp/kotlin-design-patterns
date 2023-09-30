package com.yonatankarp.prototype

/**
 * OrcMage.
 */
data class OrcMage(private val weapon: String) : Mage() {
    override fun clone() = copy()

    override fun toString() = "Orcish mage attacks with $weapon"
}
