package com.yonatankarp.factory

import com.yonatankarp.factory.CoinFactory.getCoin
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class CoinFactoryTest {
    @Test
    fun `should return gold coin instance`() {
        val goldCoin = getCoin(CoinType.GOLD)
        assertTrue(goldCoin is GoldCoin)
    }

    @Test
    fun `should return copper coin instance`() {
        val copperCoin = getCoin(CoinType.COPPER)
        assertTrue(copperCoin is CopperCoin)
    }
}
