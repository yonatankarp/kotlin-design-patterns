package com.yonatankarp.interpreter

/**
 * Represents an expression in the interpreter grammar.
 *
 * Each expression can be [interpret]ed to produce an integer result.
 * Implementations include terminal expressions like [NumberExpression]
 * and non-terminal expressions like [PlusExpression], [MinusExpression],
 * and [MultiplyExpression].
 */
internal sealed interface Expression {
    /**
     * Evaluates this expression and returns the result.
     *
     * @return the integer result of interpreting this expression
     */
    fun interpret(): Int
}
