package com.yonatankarp.singleton

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.lang.reflect.InvocationTargetException

/**
 * Create a new singleton test instance using the given 'getInstance' method.
 */
internal class ThreadSafeDoubleCheckLockingTest :
    SingletonTest<ThreadSafeDoubleCheckLocking> {
    override val singletonInstanceMethod: () -> ThreadSafeDoubleCheckLocking =
        { ThreadSafeDoubleCheckLocking.getInstance() }

    @Test
    fun `test creating new instance by refection`() {
        // Create first instance
        ThreadSafeDoubleCheckLocking.getInstance()

        // Access constructor via reflection
        val constructor =
            ThreadSafeDoubleCheckLocking::class.java.getDeclaredConstructor()
        constructor.setAccessible(true)

        // Try to invoke a 2nd instance via the constructor we just accessed

        assertThrows(InvocationTargetException::class.java) {
            constructor.newInstance()
        }
    }
}
