package com.yonatankarp.chain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class OrcKingTest {
    @ParameterizedTest
    @MethodSource("requests")
    fun `should handle all request types`(request: Request) {
        // Given
        val king = OrcKing()

        // When
        king.makeRequest(request)

        // Then
        assertTrue(request.isHandled) {
            "Expected request \"$request\" to be handled"
        }
    }

    companion object {
        @JvmStatic
        fun requests() = listOf(
            Request(
                RequestType.DEFEND_CASTLE,
                "Don't let the barbarians enter my castle!!",
            ),
            Request(
                RequestType.TORTURE_PRISONER,
                "Don't just stand there, tickle him!",
            ),
            Request(
                RequestType.COLLECT_TAX,
                "Don't steal, the King hates competition ...",
            ),
        )
    }
}
