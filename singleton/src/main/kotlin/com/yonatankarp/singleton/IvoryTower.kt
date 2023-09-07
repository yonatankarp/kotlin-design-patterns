package com.yonatankarp.singleton

/**
 * Singleton class. Eagerly initialized static instance guarantees thread safety.
 *
 * @author yonatankarp
 */
object IvoryTower {
    val instance: IvoryTower = this
}
