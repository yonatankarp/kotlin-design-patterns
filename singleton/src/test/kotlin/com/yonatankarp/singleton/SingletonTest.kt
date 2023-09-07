package com.yonatankarp.singleton

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeout
import java.time.Duration.ofMillis
import java.util.concurrent.Callable
import java.util.concurrent.Executors

/**
 * This class provides several test case that test singleton construction.
 *
 * The first proves that multiple calls to the singleton instance object are the
 * same when called in the SAME thread. The second proves that multiple calls to
 * the singleton instance object are the same when called in the DIFFERENT
 * thread.
 *
 * @param <S> Supplier method generating singletons
 * @author yonatankarp
 */
internal interface SingletonTest<S> {
    /**
     * The singleton's getInstance method.
     */
    val singletonInstanceMethod: () -> S

    /**
     * Test the singleton in a non-concurrent setting.
     */
    @Test
    fun `test multiple calls return the same object in the same thread`() {
        // Create several instances in the same calling thread
        val instance1 = singletonInstanceMethod()
        val instance2 = singletonInstanceMethod()
        val instance3 = singletonInstanceMethod()
        // now check they are equal
        assertSame(instance1, instance2)
        assertSame(instance1, instance3)
        assertSame(instance2, instance3)
    }

    /**
     * Test singleton instance in a concurrent setting.
     */
    @Test
    fun `test multiple calls return the same object in different threads`() {
        assertTimeout(ofMillis(10000)) {
            // Create 10,000 tasks and inside each callable instantiate the
            // singleton class
            val tasks =
                (0..10_000)
                    .map { Callable { singletonInstanceMethod() } }
                    .toList()

            // Use up to 8 concurrent threads to handle the tasks
            val executorService = Executors.newFixedThreadPool(8)
            val results = executorService.invokeAll(tasks)

            // wait for all the threads to complete
            val expectedInstance = singletonInstanceMethod()
            results.forEach { result ->
                val instance = result.get()
                assertNotNull(instance)
                assertSame(expectedInstance, instance)
            }

            // tidy up the executor
            executorService.shutdown()
        }
    }
}
