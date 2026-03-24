package com.yonatankarp.interpreter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

/**
 * Tests for [NumberExpression].
 */
internal class NumberExpressionTest : ExpressionTest<NumberExpression>(
    expectedToString = "number",
    factory = { first, _ -> first },
) {
    override fun expressionProvider(): Stream<Arguments> =
        prepareParameters { first, _ -> first }

    @ParameterizedTest
    @MethodSource("expressionProvider")
    fun `should create number expression from string`(first: NumberExpression) {
        // Given
        val expectedValue = first.interpret()
        val stringValue = expectedValue.toString()

        // When
        val expression = NumberExpression(stringValue)

        // Then
        assertEquals(expectedValue, expression.interpret())
    }
}
