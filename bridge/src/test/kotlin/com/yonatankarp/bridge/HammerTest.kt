package com.yonatankarp.bridge

import io.mockk.spyk
import org.junit.jupiter.api.Test

/**
 * Tests for hammer
 */
internal class HammerTest : WeaponTest() {
    /**
     * Invoke all possible actions on the weapon and check if the actions are
     * executed on the actual underlying weapon implementation.
     */
    @Test
    fun `test hammer`() {
        val hammer = Hammer(spyk<FlyingEnchantment>())
        assertBasicWeaponActions(hammer)
    }
}
