package com.yonatankarp.builder

import org.slf4j.LoggerFactory

/**
 * Builder pattern separate the construction of a complex object from its
 * representation so that the same construction process can create different
 * representations.
 *
 * There are many ways to implement the Builder in Kotlin. The first one is
 * with the [Hero.Builder] helper class that holds the context until the
 * [Hero] is ready.
 *
 * The second option is to use the [NamedArgumentsHero] class that
 * implements the builder by using the constructor named arguments, and
 * default values for unset arguments
 */

internal val logger = LoggerFactory.getLogger("com.yonatankarp.builder")

/**
 * Demonstrates the Builder pattern by constructing [Hero]
 * instances using both a traditional [Hero.Builder] and
 * Kotlin's named arguments via [NamedArgumentsHero].
 */
fun main() {
    // Helper builder class implementation

    val mage = Hero.Builder(Profession.MAGE, "Riobard")
        .withHairColor(HairColor.BLACK)
        .withWeapon(Weapon.DAGGER)
        .build()
    logger.info(mage.toString())

    val warrior = Hero.Builder(Profession.WARRIOR, "Amberjill")
        .withHairColor(HairColor.BLOND)
        .withHairType(HairType.LONG_CURLY)
        .withArmor(Armor.CHAIN_MAIL)
        .withWeapon(Weapon.SWORD)
        .build()
    logger.info(warrior.toString())

    val thief = Hero.Builder(Profession.THIEF, "Desmond")
        .withHairType(HairType.BALD)
        .withWeapon(Weapon.BOW)
        .build()
    logger.info(thief.toString())

    // Named arguments implementation

    val naMage = NamedArgumentsHero(
        profession = Profession.MAGE,
        name = "Aurelius",
        hairColor = HairColor.BLACK,
        weapon = Weapon.DAGGER
    )
    logger.info(naMage.toString())

    val naWarrior = NamedArgumentsHero(
        profession = Profession.WARRIOR,
        name = "Seraphina",
        hairType = HairType.LONG_CURLY,
        armor = Armor.CHAIN_MAIL,
        weapon = Weapon.SWORD
    )
    logger.info(naWarrior.toString())

    val naThief = NamedArgumentsHero(
        profession = Profession.THIEF,
        name = "Shadowbane",
        hairType = HairType.BALD,
        weapon = Weapon.BOW
    )
    logger.info(naThief.toString())
}
