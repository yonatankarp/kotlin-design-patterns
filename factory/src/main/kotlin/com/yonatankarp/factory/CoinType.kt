package com.yonatankarp.factory

/**
 * Enumeration for different types of coins.
 */
internal enum class CoinType(val constructor: () -> Coin) {
    COPPER({ CopperCoin() }),
    GOLD({ GoldCoin() }),
;
}
