package com.yonatankarp.interpreter

import org.slf4j.LoggerFactory
import java.util.ArrayDeque

internal val logger = LoggerFactory.getLogger("com.yonatankarp.interpreter")

private val OPERATORS = setOf("+", "-", "*")

/**
 * Demonstrates the Interpreter pattern by parsing and evaluating
 * a postfix arithmetic expression.
 *
 * The expression `"4 3 2 - 1 + *"` is tokenized and evaluated
 * using a stack-based approach, producing the result `8`.
 */
fun main() {
    val tokenString = "4 3 2 - 1 + *"
    val stack = ArrayDeque<Expression>()

    tokenString.split(" ").forEach { token ->
        if (isOperator(token)) {
            val right = stack.pop()
            val left = stack.pop()
            logger.info(
                "popped from stack left: {} right: {}",
                left.interpret(),
                right.interpret(),
            )
            val operator = getOperatorInstance(token, left, right)
            logger.info("operator: {}", operator)
            val result = operator.interpret()
            val resultExpression = NumberExpression(result)
            stack.push(resultExpression)
            logger.info("push result to stack: {}", resultExpression.interpret())
        } else {
            val expression = NumberExpression(token)
            stack.push(expression)
            logger.info("push to stack: {}", expression.interpret())
        }
    }

    logger.info("result: {}", stack.pop().interpret())
}

/**
 * Checks whether the given token is a supported operator.
 *
 * @param s the token to check
 * @return true if the token is an operator
 */
internal fun isOperator(s: String) = s in OPERATORS

/**
 * Creates the appropriate operator [Expression] for the given token.
 *
 * @param s the operator token
 * @param left the left operand expression
 * @param right the right operand expression
 * @return the corresponding [Expression]
 */
internal fun getOperatorInstance(
    s: String,
    left: Expression,
    right: Expression,
): Expression =
    when (s) {
        "+" -> PlusExpression(left, right)
        "-" -> MinusExpression(left, right)
        else -> MultiplyExpression(left, right)
    }
