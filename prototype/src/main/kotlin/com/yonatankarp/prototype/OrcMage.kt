package com.yonatankarp.prototype

/**
 * An orcish [Mage] that can be cloned via [copy].
 */
data class OrcMage(private val weapon: String) : Mage() {
    override fun clone() = copy()

    override fun toString() = "Orcish mage attacks with $weapon"
}
