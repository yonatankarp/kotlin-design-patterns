package com.yonatankarp.singleton

/**
 * Create a new singleton test instance using the given 'getInstance' method.
 */
internal class ThreadSafeLazyLoadedIvoryTowerTest :
    SingletonTest<ThreadSafeLazyLoadedIvoryTower> {
    override val singletonInstanceMethod: () -> ThreadSafeLazyLoadedIvoryTower =
        { ThreadSafeLazyLoadedIvoryTower.getInstance() }
}
