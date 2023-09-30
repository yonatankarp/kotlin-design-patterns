package com.yonatankarp.prototype

/**
 * ElfWarlord.
 */
data class ElfWarlord(private val helpType: String) : Warlord() {
    override fun clone() = copy()

    override fun toString() = "Elven warlord helps in $helpType"
}
