package com.yonatankarp.prototype

/**
 * ElfMage
 */
data class ElfMage(private val helpType: String) : Mage() {
    override fun clone() = copy()

    override fun toString() = "Elven mage helps in $helpType"
}
