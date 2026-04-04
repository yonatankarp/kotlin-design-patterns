package com.yonatankarp.bridge

/**
 * Abstraction in the Bridge pattern, delegating to an [Enchantment].
 */
internal interface Weapon {
    val enchantment: Enchantment
    fun wield()
    fun swing()
    fun unwield()
}
