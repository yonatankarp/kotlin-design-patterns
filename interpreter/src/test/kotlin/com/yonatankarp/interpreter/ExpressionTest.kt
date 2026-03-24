package com.yonatankarp.interpreter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

/**
 * Base test class for [Expression] implementations.
 *
 * Generates parameterized test data for pairs of integers from -10 to 9
 * and validates both [Expression.interpret] results and [Expression.toString] values.
 *
 * @param E the concrete expression type under test
 * @property expectedToString the expected [toString] value for the expression
 * @property factory creates an expression instance from two [NumberExpression] operands
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class ExpressionTest<E : Expression>(
    private val expectedToString: String,
    private val factory: (NumberExpression, NumberExpression) -> E,
) {
    /**
     * Provides the parameterized test data for this expression type.
     *
     * @return a stream of [Arguments] with left operand, right operand, and expected result
     */
    abstract fun expressionProvider(): Stream<Arguments>

    @ParameterizedTest
    @MethodSource("expressionProvider")
    fun `should interpret expression correctly`(
        first: NumberExpression,
        second: NumberExpression,
        result: Int,
    ) {
        // Given
        val expression = factory(first, second)

        // Then
        assertNotNull(expression)
        assertEquals(result, expression.interpret())
    }

    @ParameterizedTest
    @MethodSource("expressionProvider")
    fun `should have correct toString representation`(
        first: NumberExpression,
        second: NumberExpression,
    ) {
        // Given
        val expression = factory(first, second)

        // Then
        assertNotNull(expression)
        assertEquals(expectedToString, expression.toString())
    }
    companion object {
        private const val RANGE_END = 10
        private const val RANGE_START = -10

        /**
         * Generates test parameters for all combinations of integers in [-10, 10).
         *
         * @param resultCalc computes the expected result from two operands
         * @return a stream of [Arguments] containing left, right, and expected result
         */
        @JvmStatic
        fun prepareParameters(resultCalc: (Int, Int) -> Int): Stream<Arguments> =
            (RANGE_START until RANGE_END).flatMap { i ->
                (RANGE_START until RANGE_END).map { j ->
                    Arguments.of(NumberExpression(i), NumberExpression(j), resultCalc(i, j))
                }
            }.stream()
    }
}
