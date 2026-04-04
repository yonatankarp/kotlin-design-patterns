package com.yonatankarp.strategy

/**
 * Context that delegates dragon-slaying to a [DragonSlayingStrategy].
 */
internal class DragonSlayer(private var strategy: DragonSlayingStrategy) {
    fun changeStrategy(strategy: DragonSlayingStrategy) {
        this.strategy = strategy
    }

    fun goToBattle() {
        strategy.execute()
    }
}
