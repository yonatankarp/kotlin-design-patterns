package com.yonatankarp.prototype

/**
 * An orcish [Warlord] that can be cloned via [copy].
 */
data class OrcWarlord(private val weapon: String) : Warlord() {
    override fun clone() = copy()

    override fun toString() = "Orcish warlord attacks with $weapon"
}
