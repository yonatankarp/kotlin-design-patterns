package com.yonatankarp.interpreter

import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream

/**
 * Tests for [MinusExpression].
 */
internal class MinusExpressionTest : ExpressionTest<MinusExpression>(
    expectedToString = "-",
    factory = ::MinusExpression,
) {
    override fun expressionProvider(): Stream<Arguments> =
        prepareParameters { first, second -> first - second }
}
