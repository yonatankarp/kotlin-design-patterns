package com.yonatankarp.factory.method

/**
 * Concrete subclass for creating new objects.
 */
internal class OrcBlacksmith : Blacksmith {
    override fun manufactureWeapon(weaponType: WeaponType): Weapon =
        ORC_ARSENAL.getOrElse(weaponType) {
            throw IllegalArgumentException("Weapon type $weaponType is not supported by the orc blacksmith.")
        }

    override fun toString() = "The orc blacksmith"

    companion object {
        private val ORC_ARSENAL =
            WeaponType.entries.associateWith { OrcWeapon(it) }
    }
}
