package com.yonatankarp.bridge

/**
 * Weapon.
 */
internal interface Weapon {
    val enchantment: Enchantment
    fun wield()
    fun swing()
    fun unwield()
}
