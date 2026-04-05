package com.yonatankarp.memento

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StarTest {
    @Test
    fun `should evolve through all lifecycle stages`() {
        // Given
        val star = Star(StarType.SUN, 1, 2)

        // When / Then
        assertEquals("sun age: 1 years mass: 2 tons", star.toString())

        star.timePasses()
        assertEquals(
            "red giant age: 2 years mass: 16 tons",
            star.toString(),
        )

        star.timePasses()
        assertEquals(
            "white dwarf age: 4 years mass: 128 tons",
            star.toString(),
        )

        star.timePasses()
        assertEquals(
            "supernova age: 8 years mass: 1024 tons",
            star.toString(),
        )

        star.timePasses()
        assertEquals(
            "dead star age: 16 years mass: 8192 tons",
            star.toString(),
        )

        star.timePasses()
        assertEquals(
            "dead star age: 64 years mass: 0 tons",
            star.toString(),
        )

        star.timePasses()
        assertEquals(
            "dead star age: 256 years mass: 0 tons",
            star.toString(),
        )
    }

    @Test
    fun `should restore previous state from memento`() {
        // Given
        val star = Star(StarType.SUN, 1, 2)
        val firstMemento = star.getMemento()
        assertEquals("sun age: 1 years mass: 2 tons", star.toString())

        star.timePasses()
        val secondMemento = star.getMemento()
        assertEquals(
            "red giant age: 2 years mass: 16 tons",
            star.toString(),
        )

        star.timePasses()
        val thirdMemento = star.getMemento()
        assertEquals(
            "white dwarf age: 4 years mass: 128 tons",
            star.toString(),
        )

        // When
        star.timePasses()
        assertEquals(
            "supernova age: 8 years mass: 1024 tons",
            star.toString(),
        )

        // Then - restoring to third memento
        star.setMemento(thirdMemento)
        assertEquals(
            "white dwarf age: 4 years mass: 128 tons",
            star.toString(),
        )

        star.timePasses()
        assertEquals(
            "supernova age: 8 years mass: 1024 tons",
            star.toString(),
        )

        star.setMemento(secondMemento)
        assertEquals(
            "red giant age: 2 years mass: 16 tons",
            star.toString(),
        )

        star.setMemento(firstMemento)
        assertEquals("sun age: 1 years mass: 2 tons", star.toString())
    }
}
