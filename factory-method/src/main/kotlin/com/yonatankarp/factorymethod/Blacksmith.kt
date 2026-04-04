package com.yonatankarp.factorymethod

/**
 * Interface for manufacturing [Weapon] instances.
 */
internal interface Blacksmith {
    fun manufactureWeapon(weaponType: WeaponType): Weapon
}
