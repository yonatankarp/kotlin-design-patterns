package com.yonatankarp.prototype

/**
 * An elven [Warlord] that can be cloned via [copy].
 */
data class ElfWarlord(private val helpType: String) : Warlord() {
    override fun clone() = copy()

    override fun toString() = "Elven warlord helps in $helpType"
}
