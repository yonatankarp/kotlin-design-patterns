package com.yonatankarp.bridge

import io.mockk.confirmVerified
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertNotNull

/**
 * Base class for weapon tests
 */
internal open class WeaponTest {
    /**
     * Invoke the basic actions of the given weapon, and test if the underlying
     * enchantment implementation is invoked
     */
    fun assertBasicWeaponActions(weapon: Weapon) {
        assertNotNull(weapon)
        val enchantment = weapon.enchantment
        assertNotNull(enchantment)

        weapon.swing()
        verify { enchantment.apply() }
        confirmVerified(enchantment)

        weapon.wield()
        verify { enchantment.onActivate() }
        confirmVerified(enchantment)

        weapon.unwield()
        verify { enchantment.onDeactivate() }
        confirmVerified(enchantment)
    }
}
