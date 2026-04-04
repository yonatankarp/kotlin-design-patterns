package com.yonatankarp.factorymethod

/**
 * A [Weapon] crafted by elven blacksmiths.
 */
internal class ElfWeapon(override val weaponType: WeaponType) : Weapon {
    override fun toString() = "an elven $weaponType"
}
