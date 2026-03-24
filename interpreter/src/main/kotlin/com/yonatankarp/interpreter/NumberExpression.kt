package com.yonatankarp.interpreter

/**
 * A terminal expression that holds a single numeric value.
 *
 * @property number the integer value this expression represents
 */
internal data class NumberExpression(val number: Int) : Expression {
    /**
     * Creates a [NumberExpression] by parsing a string as an integer.
     *
     * @param s the string representation of the number
     */
    constructor(s: String) : this(s.toInt())

    override fun interpret() = number

    override fun toString() = "number"
}
