package com.yonatankarp.staticfactory.method

class Money private constructor(
    val amount: Int,
    val currency: String,
) {
    override fun toString() = "$amount $currency"

    companion object {
        fun dollars(amount: Int) = Money(amount, "USD")
        fun euros(amount: Int) = Money(amount, "EUR")
    }
}
