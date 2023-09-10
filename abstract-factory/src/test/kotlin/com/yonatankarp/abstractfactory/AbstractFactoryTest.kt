package com.yonatankarp.abstractfactory

import com.yonatankarp.abstractfactory.Kingdom.FactoryMaker.KingdomType.ELF
import com.yonatankarp.abstractfactory.Kingdom.FactoryMaker.KingdomType.ORC
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Tests for abstract factory.
 */
internal class AbstractFactoryTest {
    @Test
    fun `verify king creation`() {
        val elfKingdom = Kingdom.FactoryMaker.makeFactory(ELF)
        val elfKing = elfKingdom.createKing()
        assertTrue(elfKing is ElfKing)
        assertEquals("This is the elven king!", elfKing.description)

        val orcKingdom = Kingdom.FactoryMaker.makeFactory(ORC)
        val orcKing = orcKingdom.createKing()
        assertTrue(orcKing is OrcKing)
        assertEquals("This is the orc king!", orcKing.description)
    }

    @Test
    fun `verify castle creation`() {
        val elfKingdom = Kingdom.FactoryMaker.makeFactory(ELF)
        val elfCastle = elfKingdom.createCastle()
        assertTrue(elfCastle is ElfCastle)
        assertEquals("This is the elven castle!", elfCastle.description)

        val orcKingdom = Kingdom.FactoryMaker.makeFactory(ORC)
        val orcCastle = orcKingdom.createCastle()
        assertTrue(orcCastle is OrcCastle)
        assertEquals("This is the orc castle!", orcCastle.description)
    }

    @Test
    fun `verify army creation`() {
        val elfKingdom = Kingdom.FactoryMaker.makeFactory(ELF)
        val elfArmy = elfKingdom.createArmy()
        assertTrue(elfArmy is ElfArmy)
        assertEquals("This is the elven army!", elfArmy.description)

        val orcKingdom = Kingdom.FactoryMaker.makeFactory(ORC)
        val orcArmy = orcKingdom.createArmy()
        assertTrue(orcArmy is OrcArmy)
        assertEquals("This is the orc army!", orcArmy.description)
    }

    @Test
    fun `verify elf kingdom creation`() {
        val kingdom = Kingdom.FactoryMaker.makeFactory(ELF)

        val king = kingdom.createKing()
        val castle = kingdom.createCastle()
        val army = kingdom.createArmy()

        assertTrue(king is ElfKing)
        assertEquals("This is the elven king!", king.description)
        assertTrue(castle is ElfCastle)
        assertEquals("This is the elven castle!", castle.description)
        assertTrue(army is ElfArmy)
        assertEquals("This is the elven army!", army.description)
    }

    @Test
    fun `verify orc kingdom creation`() {
        val kingdom = Kingdom.FactoryMaker.makeFactory(ORC)

        val king = kingdom.createKing()
        val castle = kingdom.createCastle()
        val army = kingdom.createArmy()

        assertTrue(king is OrcKing)
        assertEquals("This is the orc king!", king.description)
        assertTrue(castle is OrcCastle)
        assertEquals("This is the orc castle!", castle.description)
        assertTrue(army is OrcArmy)
        assertEquals("This is the orc army!", army.description)
    }
}
