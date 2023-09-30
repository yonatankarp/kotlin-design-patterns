package com.yonatankarp.prototype

/**
 * ElfBeast.
 */
data class ElfBeast(private val helpType: String) : Beast() {
    override fun clone() = copy()

    override fun toString() = "Elven eagle helps in $helpType"
}
