package com.yonatankarp.prototype

/**
 * OrcWarlord.
 */
data class OrcWarlord(private val weapon: String) : Warlord() {
    override fun clone() = copy()

    override fun toString() = "Orcish warlord attacks with $weapon"
}
