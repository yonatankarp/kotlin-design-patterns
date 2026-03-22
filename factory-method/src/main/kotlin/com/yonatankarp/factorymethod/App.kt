package com.yonatankarp.factorymethod

import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal val logger: Logger = LoggerFactory.getLogger("com.yonatankarp.factorymethod")

/**
 * Program entry point.
 */
fun main() {
    val orcBlacksmith = OrcBlacksmith()
    manufactureWeapon(orcBlacksmith, WeaponType.SPEAR)
    manufactureWeapon(orcBlacksmith, WeaponType.AXE)

    val elfBlacksmith = ElfBlacksmith()
    manufactureWeapon(elfBlacksmith, WeaponType.SPEAR)
    manufactureWeapon(elfBlacksmith, WeaponType.AXE)
}

private fun manufactureWeapon(blacksmith: Blacksmith, weaponType: WeaponType) {
    val weapon = blacksmith.manufactureWeapon(weaponType)
    logger.info("$blacksmith manufactured ${weapon.weaponType.title}")
}
