package com.yonatankarp.singleton

import kotlin.concurrent.Volatile

/**
 * Thread-safe Singleton class. The instance is lazily initialized and thus needs synchronization
 * mechanism.
 *
 * @author yonatankarp
 */
class ThreadSafeLazyLoadedIvoryTower private constructor() {
    init {
        // Protect against instantiation via reflection
        check(instance == null) { "Already initialized." }
    }

    companion object {
        @Volatile
        private var instance: ThreadSafeLazyLoadedIvoryTower? = null

        /**
         * The instance doesn't get created until the method is called for the first time.
         */
        @Synchronized
        fun getInstance(): ThreadSafeLazyLoadedIvoryTower {
            if (instance == null) {
                synchronized(ThreadSafeLazyLoadedIvoryTower::class.java) {
                    if (instance == null) {
                        instance = ThreadSafeLazyLoadedIvoryTower()
                    }
                }
            }

            return instance!!
        }
    }
}
