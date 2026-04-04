package com.yonatankarp.prototype

/**
 * An elven [Mage] that can be cloned via [copy].
 */
data class ElfMage(private val helpType: String) : Mage() {
    override fun clone() = copy()

    override fun toString() = "Elven mage helps in $helpType"
}
