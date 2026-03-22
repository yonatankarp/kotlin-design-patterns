package com.yonatankarp.factorymethod

/**
 * ElfWeapon.
 */
internal class ElfWeapon(override val weaponType: WeaponType) : Weapon {
    override fun toString() = "an elven $weaponType"
}
