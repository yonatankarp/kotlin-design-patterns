package com.yonatankarp.factory.method

/**
 * ElfWeapon.
 */
internal class ElfWeapon(override val weaponType: WeaponType) : Weapon {
    override fun toString() = "an elven $weaponType"
}
