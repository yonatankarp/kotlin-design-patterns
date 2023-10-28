package com.yonatankarp.composite

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class MessengerTest {
    /**
     * The buffer used to capture every write to [System.out]
     */
    private val stdOutBuffer = ByteArrayOutputStream()

    /**
     * Keep the original std-out, so it can be restored after the test
     */
    private val realStdOut = System.out

    @BeforeEach
    fun setUp() {
        stdOutBuffer.reset()
        System.setOut(PrintStream(stdOutBuffer))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(realStdOut)
    }

    @ParameterizedTest(name = "test message for {0}")
    @MethodSource("messages")
    fun `test message`(
        type: String,
        composedMessage: LetterComposite,
        message: String,
    ) {
        // Test is the composed message has the correct number of words
        val words = message.split(" ")
        assertNotNull(composedMessage)
        assertEquals(words.size, composedMessage.count())

        // Print the message to the mocked stdOut
        composedMessage.print()

        // and verify if the message matches with the expected one0
        assertEquals(message, String(stdOutBuffer.toByteArray()).trim())
    }

    companion object {
        @JvmStatic
        fun messages(): List<Array<Any>> {
            val messenger = Messenger()
            return listOf(
                arrayOf(
                    "orcs",
                    messenger.messageFromOrcs(),
                    "Where there is a whip there is a way."
                ),
                arrayOf(
                    "elves",
                    messenger.messageFromElves(),
                    "Much wind pours from your mouth."
                )
            )
        }
    }
}
