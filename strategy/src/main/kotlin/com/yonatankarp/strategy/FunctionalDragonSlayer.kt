package com.yonatankarp.strategy

internal typealias Strategy = () -> Unit

/**
 * FunctionalDragonSlayer uses different strategies to slay the dragon that are
 * based on lambdas
 */
internal class FunctionalDragonSlayer(private var strategy: Strategy) {
    fun changeStrategy(strategy: Strategy) {
        this.strategy = strategy
    }

    fun goToBattle() {
        strategy()
    }
}
