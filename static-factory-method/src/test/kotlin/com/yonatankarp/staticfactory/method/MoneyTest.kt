package com.yonatankarp.staticfactory.method

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    fun `should create dollar object`() {
        val dollars = Money.dollars(5)
        assertEquals(dollars.currency, "USD")
        assertEquals(dollars.amount, 5)
    }

    @Test
    fun `should create euro object`() {
        val dollars = Money.euros(5)
        assertEquals(dollars.currency, "EUR")
        assertEquals(dollars.amount, 5)
    }
}
