package com.yonatankarp.interpreter

import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream

/**
 * Tests for [MultiplyExpression].
 */
internal class MultiplyExpressionTest : ExpressionTest<MultiplyExpression>(
    expectedToString = "*",
    factory = ::MultiplyExpression,
) {
    override fun expressionProvider(): Stream<Arguments> =
        prepareParameters { first, second -> first * second }
}
