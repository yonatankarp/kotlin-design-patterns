package com.yonatankarp.singleton

/**
 * [IvoryTower] is a singleton implemented via Kotlin's `object`
 * keyword, which guarantees a single, thread-safe instance without
 * the boilerplate required in Java (private constructor, static
 * field, double-checked locking, etc.).
 */
data object IvoryTower {
    init {
        logger.info("Initializing Ivory Tower...")
    }

    override fun toString() = this::class.java.name + "@" + hashCode()
}
