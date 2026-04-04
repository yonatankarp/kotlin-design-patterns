package com.yonatankarp.builder

/**
 * Represents the type of armor a [Hero] can wear.
 */
internal enum class Armor(private val title: String) {
    CHAIN_MAIL("chain mail"),
    CLOTHES("clothes"),
    LEATHER("leather"),
    PLATE_MAIL("plate mail"),
    ;

    override fun toString() = title
}
