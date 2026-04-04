package com.yonatankarp.factorymethod

/**
 * Enumerates the types of weapons a [Blacksmith] can manufacture.
 */
internal enum class WeaponType(val title: String) {
    AXE("axe"),
    SHORT_SWORD("short sword"),
    SPEAR("spear"),
    UNDEFINED(""),
;
}
