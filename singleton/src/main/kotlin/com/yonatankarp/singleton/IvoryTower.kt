package com.yonatankarp.singleton

/**
 * Singleton class. Eagerly initialized static instance guarantees thread safety.
 *
 * @author yonatankarp
 */
data object IvoryTower {
    init {
        logger.info("Initializing Ivory Tower...")
    }

    override fun toString() = this::class.java.name + "@" + hashCode()
}
