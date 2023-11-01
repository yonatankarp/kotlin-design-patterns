package com.yonatankarp.strategy

/**
 * Strategy interface.
 */
// TODO: make internal once this issue is fixed in Spotless: https://github.com/diffplug/spotless/issues/1865
fun interface DragonSlayingStrategy {
    fun execute()
}
