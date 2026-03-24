package com.yonatankarp.interpreter

/**
 * A non-terminal expression that adds two sub-expressions.
 *
 * @property leftExpression the left operand
 * @property rightExpression the right operand
 */
internal data class PlusExpression(
    val leftExpression: Expression,
    val rightExpression: Expression,
) : Expression {
    override fun interpret() = leftExpression.interpret() + rightExpression.interpret()

    override fun toString() = "+"
}
