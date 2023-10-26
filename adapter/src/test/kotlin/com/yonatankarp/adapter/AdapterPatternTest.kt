package com.yonatankarp.adapter

import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test

/**
 * Tests for the adapter pattern.
 */
internal class AdapterPatternTest {
    @Test
    fun `test class adapter`() {
        val adapter = spyk(FishingBoatAdapter(FishingBoat()))
        testWithAdapter(adapter)
    }

    @Test
    fun `test extension method adapter`() {
        val adapter = spyk(FishingBoat().toRowingBoat())
        testWithAdapter(adapter)
    }

    private fun testWithAdapter(adapter: RowingBoat) {
        val captain = Captain(adapter)
        captain.row()
        verify { adapter.row() }
    }
}
