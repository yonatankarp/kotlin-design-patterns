package com.yonatankarp.bridge

/**
 * Enchantment.
 */
internal interface Enchantment {
    fun onActivate()
    fun apply()
    fun onDeactivate()
}
