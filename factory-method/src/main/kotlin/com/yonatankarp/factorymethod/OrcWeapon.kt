package com.yonatankarp.factorymethod

/**
 * A [Weapon] crafted by orc blacksmiths.
 */
internal class OrcWeapon(override val weaponType: WeaponType) : Weapon {
    override fun toString() = "an orcish $weaponType"
}
