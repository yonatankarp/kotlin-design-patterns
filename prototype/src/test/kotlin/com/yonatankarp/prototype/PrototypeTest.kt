package com.yonatankarp.prototype

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

/**
 * Verifies that each [Prototype] implementation correctly
 * clones itself as a distinct but equal instance.
 */
internal class PrototypeTest<P : Prototype<P>> {
    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `test prototype`(testedPrototype: P, expectedToString: String) {
        // Given
        assertEquals(expectedToString, testedPrototype.toString())

        // When
        val clone = testedPrototype.clone()

        // Then
        assertNotSame(clone, testedPrototype)
        assertSame(testedPrototype::class.java, clone::class.java)
        assertEquals(clone, testedPrototype)
    }

    companion object {
        @JvmStatic
        fun dataProvider() =
            listOf(
                arrayOf(
                    OrcBeast("axe"),
                    "Orcish wolf attacks with axe"
                ),
                arrayOf(OrcMage("sword"), "Orcish mage attacks with sword"),
                arrayOf(
                    OrcWarlord("laser"),
                    "Orcish warlord attacks with laser"
                ),
                arrayOf(ElfBeast("cooking"), "Elven eagle helps in cooking"),
                arrayOf(ElfMage("cleaning"), "Elven mage helps in cleaning"),
                arrayOf(
                    ElfWarlord("protecting"),
                    "Elven warlord helps in protecting"
                )
            )
    }
}
