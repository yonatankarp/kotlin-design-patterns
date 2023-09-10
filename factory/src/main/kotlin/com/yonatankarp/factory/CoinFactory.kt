package com.yonatankarp.factory

/**
 * Factory of coins.
 */
internal object CoinFactory {
    /**
     * Factory method takes as a parameter the coin type and calls the
     * appropriate class.
     */
    fun getCoin(type: CoinType): Coin = type.constructor()
}
