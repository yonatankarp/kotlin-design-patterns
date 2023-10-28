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
 * Fortunately, Kotlin comes with a built-in implementation for Singletons using
 * the `object` keyword.
 */
internal val logger: Logger = LoggerFactory.getLogger("com.yonatankarp.singleton")

/**
 * Program main entry point.
 */
fun main() {
    val ivoryTower1 = IvoryTower
    val ivoryTower2 = IvoryTower
    logger.info("ivoryTower1={}", ivoryTower1)
    logger.info("ivoryTower2={}", ivoryTower2)
}
