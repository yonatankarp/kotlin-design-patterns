package com.yonatankarp.bridge

import io.mockk.spyk
import org.junit.jupiter.api.Test

/**
 * Tests for sword
 */
internal class SwordTest : WeaponTest() {
    /**
     * Invoke all possible actions on the weapon and check if the actions are
     * executed on the actual underlying weapon implementation.
     */
    @Test
    fun `test sword`() {
        val sword = Sword(spyk<FlyingEnchantment>())
        assertBasicWeaponActions(sword)
    }
}
