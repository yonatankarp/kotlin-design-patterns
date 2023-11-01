package com.yonatankarp.strategy

/**
 * DragonSlayer uses different strategies to slay the dragon.
 */
internal class DragonSlayer(private var strategy: DragonSlayingStrategy) {
    fun changeStrategy(strategy: DragonSlayingStrategy) {
        this.strategy = strategy
    }

    fun goToBattle() {
        strategy.execute()
    }
}
