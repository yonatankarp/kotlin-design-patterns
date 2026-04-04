package com.yonatankarp.factory

/**
 * Enumerates the types of [Coin] the [CoinFactory] can produce.
 */
internal enum class CoinType(val constructor: () -> Coin) {
    COPPER({ CopperCoin() }),
    GOLD({ GoldCoin() }),
;
}
