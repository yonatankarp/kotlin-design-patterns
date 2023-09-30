package com.yonatankarp.prototype

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

/**
 * Date: 12/28/15 - 8:45 PM
 *
 * @param <P> Prototype
 * @author Jeroen Meulemeester
</P> */
internal class PrototypeTest<P : Prototype<P>> {
    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `test prototype`(testedPrototype: P, expectedToString: String) {
        assertEquals(expectedToString, testedPrototype.toString())

        val clone = testedPrototype.clone()

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
