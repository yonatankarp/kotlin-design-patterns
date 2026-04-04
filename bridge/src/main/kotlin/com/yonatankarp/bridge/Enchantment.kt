package com.yonatankarp.bridge

/**
 * Implementation interface in the Bridge pattern for [Weapon] behaviors.
 */
internal interface Enchantment {
    fun onActivate()
    fun apply()
    fun onDeactivate()
}
