package com.yonatankarp.singleton

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Singleton pattern ensures that the class can have only one existing instance
 * per JVM classloader instance and provides global access to it.
 *
 * One of the risks of this pattern is that bugs resulting from setting a
 * singleton up in a distributed environment can be tricky to debug since it
 * will work fine if you debug with a single classloader. Additionally, these
 * problems can crop up a while after the implementation of a singleton, since
 * they may start synchronous and only become async with time, so it may
 * not be clear why you are seeing certain changes in behavior.
 *
 * There are many ways to implement the Singleton. The first one is the eagerly
 * initialized instance in [IvoryTower]. Eager initialization implies that the
 * implementation is thread safe. If you can afford to give up control of the
 * instantiation moment, then this implementation will suit you fine.
 *
 * The other option to implement eagerly initialized Singleton is enum-based
 * Singleton. The example is found in [EnumIvoryTower]. At first glance, the
 * code looks short and simple. However, you should be aware of the downsides
 * including committing to implementation strategy, extending the enum class,
 * serializability, and restrictions to coding. These are extensively discussed
 * in Stack Overflow: http://programmers.stackexchange.com/questions/179386/what-are-the-downsides-of-implementing-a-singleton-with-javas-enum
 *
 * [ThreadSafeLazyLoadedIvoryTower] is a Singleton implementation that is
 * initialized on demand. The downside is that it is very slow to access since
 * the whole access method is synchronized.
 *
 * Another Singleton implementation that is initialized on demand is found in
 * [ThreadSafeDoubleCheckLocking]. It is somewhat faster than
 * [ThreadSafeLazyLoadedIvoryTower] since it doesn't synchronize the whole
 * access method but only the method internals on specific conditions.
 *
 * Yet another way to implement thread-safe lazily initialized Singleton can be
 * found in [InitializingOnDemandHolderIdiom]. Which relies on Kotlin's lazy
 * initialization language feature.
 *
 * @author: yonatankarp
 */
val logger: Logger = LoggerFactory.getLogger("Singlton")

fun main() {
    // eagerly initialized singleton
    val ivoryTower1 = IvoryTower.instance
    val ivoryTower2 = IvoryTower.instance
    logger.info("ivoryTower1={}", ivoryTower1)
    logger.info("ivoryTower2={}", ivoryTower2)

    // lazily initialized singleton
    val threadSafeIvoryTower1 = ThreadSafeLazyLoadedIvoryTower.getInstance()
    val threadSafeIvoryTower2 = ThreadSafeLazyLoadedIvoryTower.getInstance()
    logger.info("threadSafeIvoryTower1={}", threadSafeIvoryTower1)
    logger.info("threadSafeIvoryTower2={}", threadSafeIvoryTower2)

    // enum singleton
    val enumIvoryTower1 = EnumIvoryTower.INSTANCE
    val enumIvoryTower2 = EnumIvoryTower.INSTANCE
    logger.info("enumIvoryTower1={}", enumIvoryTower1)
    logger.info("enumIvoryTower2={}", enumIvoryTower2)

    // double-checked locking
    val dcl1 = ThreadSafeDoubleCheckLocking.getInstance()
    logger.info(dcl1.toString())
    val dcl2 = ThreadSafeDoubleCheckLocking.getInstance()
    logger.info(dcl2.toString())

    // initialize on demand holder idiom
    val demandHolderIdiom = InitializingOnDemandHolderIdiom.instance
    logger.info(demandHolderIdiom.toString())
    val demandHolderIdiom2 = InitializingOnDemandHolderIdiom.instance
    logger.info(demandHolderIdiom2.toString())
}
