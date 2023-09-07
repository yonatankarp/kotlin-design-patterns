package com.yonatankarp.singleton

/**
 * Create a new singleton test instance using the given 'getInstance' method.
 */
internal class EnumIvoryTowerTest : SingletonTest<EnumIvoryTower> {
    override val singletonInstanceMethod: () -> EnumIvoryTower =
        { EnumIvoryTower.INSTANCE }
}
