package com.yonatankarp.factorymethod

/**
 * The interface containing method for producing objects.
 */
internal interface Blacksmith {
    fun manufactureWeapon(weaponType: WeaponType): Weapon
}
