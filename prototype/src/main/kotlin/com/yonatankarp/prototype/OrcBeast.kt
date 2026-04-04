package com.yonatankarp.prototype

/**
 * An orcish [Beast] that can be cloned via [copy].
 */
data class OrcBeast(private val weapon: String) : Beast() {
    override fun clone() = copy()

    override fun toString() = "Orcish wolf attacks with $weapon"
}
