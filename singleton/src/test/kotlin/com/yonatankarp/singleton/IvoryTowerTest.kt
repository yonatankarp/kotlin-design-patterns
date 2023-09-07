package com.yonatankarp.singleton

/**
 * Create a new singleton test instance using the given 'getInstance' method.
 */
internal class IvoryTowerTest : SingletonTest<IvoryTower> {
    override val singletonInstanceMethod: () -> IvoryTower =
        { IvoryTower.instance }
}
