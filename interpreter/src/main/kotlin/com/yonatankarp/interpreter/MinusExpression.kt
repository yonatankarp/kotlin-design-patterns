package com.yonatankarp.interpreter

/**
 * A non-terminal expression that subtracts the right sub-expression
 * from the left.
 *
 * @property leftExpression the left operand
 * @property rightExpression the right operand
 */
internal data class MinusExpression(
    val leftExpression: Expression,
    val rightExpression: Expression,
) : Expression {
    override fun interpret() = leftExpression.interpret() - rightExpression.interpret()

    override fun toString() = "-"
}
