package com.yonatankarp.factory.method

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.reflect.KClass

/**
 * The Factory Method is a creational design pattern which uses factory methods
 * to deal with the problem of creating objects without specifying the exact
 * class of object that will be created. This is done by creating objects via
 * calling a factory method either specified in an interface and implemented by
 * child classes, or implemented in a base class and optionally overridden by
 * derived classes—rather than by calling a constructor.
 *
 * Factory produces the object of its liking.
 * The weapon [Weapon] manufactured by the blacksmith depends on the kind of
 * factory implementation it is referring to.
 */
internal class FactoryMethodTest {
    @ParameterizedTest(name = "{0} blacksmith {2} should be {0} weapon instance")
    @MethodSource("testCases")
    fun `blacksmith weapon should match weapon type`(
        type: String,
        blacksmith: Blacksmith,
        expectedWeaponType: WeaponType,
        clazz: KClass<*>,
    ) {
        val weapon = blacksmith.manufactureWeapon(expectedWeaponType)
        verifyWeapon(weapon, expectedWeaponType, clazz)
    }

    /**
     * This method asserts that the weapon object that is passed is an instance of the clazz and the
     * weapon is of type expectedWeaponType.
     *
     * @param weapon weapon object which is to be verified
     * @param expectedWeaponType expected WeaponType of the weapon
     * @param clazz expected class of the weapon
     */
    private fun verifyWeapon(
        weapon: Weapon,
        expectedWeaponType: WeaponType,
        clazz: KClass<*>,
    ) {
        assertTrue(
            clazz.isInstance(weapon),
            "Weapon must be an object of: ${clazz.simpleName}"
        )
        assertEquals(
            expectedWeaponType,
            weapon.weaponType,
            "Weapon must be of weaponType: $expectedWeaponType"
        )
    }

    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(
                "Orc",
                OrcBlacksmith(),
                WeaponType.AXE,
                OrcWeapon::class
            ),
            Arguments.of(
                "Orc",
                OrcBlacksmith(),
                WeaponType.SPEAR,
                OrcWeapon::class
            ),
            Arguments.of(
                "Elf",
                ElfBlacksmith(),
                WeaponType.SHORT_SWORD,
                ElfWeapon::class
            ),
            Arguments.of(
                "Elf",
                ElfBlacksmith(),
                WeaponType.SPEAR,
                ElfWeapon::class
            )
        )
    }
}
