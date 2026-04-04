package com.yonatankarp.factorymethod

/**
 * A [Blacksmith] that manufactures elven [Weapon] instances.
 */
internal class ElfBlacksmith : Blacksmith {
    override fun manufactureWeapon(weaponType: WeaponType): Weapon =
        ELF_ARSENAL.getOrElse(weaponType) {
            throw IllegalArgumentException("Weapon type $weaponType is not supported by elf blacksmith.")
        }

    override fun toString() = "The elf blacksmith"

    companion object {
        private val ELF_ARSENAL =
            WeaponType.entries.associateWith { type -> ElfWeapon(type) }
    }
}
