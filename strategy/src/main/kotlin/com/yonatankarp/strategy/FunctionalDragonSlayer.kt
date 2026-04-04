package com.yonatankarp.strategy

internal typealias Strategy = () -> Unit

/**
 * Context that delegates dragon-slaying to a lambda [Strategy].
 */
internal class FunctionalDragonSlayer(private var strategy: Strategy) {
    fun changeStrategy(strategy: Strategy) {
        this.strategy = strategy
    }

    fun goToBattle() {
        strategy()
    }
}
