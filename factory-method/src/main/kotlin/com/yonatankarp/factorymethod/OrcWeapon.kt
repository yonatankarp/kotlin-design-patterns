package com.yonatankarp.factorymethod

internal class OrcWeapon(override val weaponType: WeaponType) : Weapon {
    override fun toString() = "an orcish $weaponType"
}
