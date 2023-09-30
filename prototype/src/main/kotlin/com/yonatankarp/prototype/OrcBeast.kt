package com.yonatankarp.prototype

/**
 * OrcBeast.
 */
data class OrcBeast(private val weapon: String) : Beast() {
    override fun clone() = copy()

    override fun toString() = "Orcish wolf attacks with $weapon"
}
