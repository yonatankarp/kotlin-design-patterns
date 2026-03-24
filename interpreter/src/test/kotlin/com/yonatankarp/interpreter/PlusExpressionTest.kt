package com.yonatankarp.interpreter

import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream

/**
 * Tests for [PlusExpression].
 */
internal class PlusExpressionTest : ExpressionTest<PlusExpression>(
    expectedToString = "+",
    factory = ::PlusExpression,
) {
    override fun expressionProvider(): Stream<Arguments> =
        prepareParameters { first, second -> first + second }
}
