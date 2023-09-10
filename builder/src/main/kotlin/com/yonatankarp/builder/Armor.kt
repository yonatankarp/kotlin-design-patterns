package com.yonatankarp.builder

/**
 * Armor enumeration.
 */
internal enum class Armor(private val title: String) {
    CHAIN_MAIL("chain mail"),
    CLOTHES("clothes"),
    LEATHER("leather"),
    PLATE_MAIL("plate mail"),
    ;

    override fun toString() = title
}
