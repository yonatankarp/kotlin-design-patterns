package com.yonatankarp.factory.method

import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("com.yonatankarp.factory.method")

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
