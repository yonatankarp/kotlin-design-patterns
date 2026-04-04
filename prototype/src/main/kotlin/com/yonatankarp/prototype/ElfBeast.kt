package com.yonatankarp.prototype

/**
 * An elven [Beast] that can be cloned via [copy].
 */
data class ElfBeast(private val helpType: String) : Beast() {
    override fun clone() = copy()

    override fun toString() = "Elven eagle helps in $helpType"
}
