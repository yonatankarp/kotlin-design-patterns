package com.yonatankarp.singleton

import kotlin.concurrent.Volatile

/**
 * Double check locking.
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 */
class ThreadSafeDoubleCheckLocking private constructor() {
    /**
     * private constructor to prevent client from instantiating.
     */
    init {
        // to prevent instantiating by Reflection call
        check(instance == null) { "Already initialized." }
    }

    companion object {
        @Volatile
        private var instance: ThreadSafeDoubleCheckLocking? = null

        fun getInstance(): ThreadSafeDoubleCheckLocking {
            // local variable increases performance by 25 percent
            // Joshua Bloch "Effective Java, Second Edition", p. 283-284
            var result = instance

            // Check if singleton instance is initialized.
            // If it is initialized then we can return the instance.
            if (result == null) {
                // It is not initialized, but we cannot be sure because some
                // other thread might have  initialized it in the meanwhile.
                // So to make sure we need to lock on an object to get mutual
                // exclusion.
                synchronized(ThreadSafeDoubleCheckLocking::class.java) {
                    // Again assign the instance to local variable to check if
                    // it was initialized by some other thread while current
                    // thread was blocked to enter the locked zone.
                    // If it was initialized then we can return the previously
                    // created instance just like the previous null check.
                    result = instance
                    if (result == null) {
                        // The instance is still not initialized, so we can
                        // safely (no other thread can enter this zone) create
                        // an instance and make it our singleton instance.
                        result = ThreadSafeDoubleCheckLocking()
                        instance = result
                    }
                }
            }
            return result!!
        }
    }
}
