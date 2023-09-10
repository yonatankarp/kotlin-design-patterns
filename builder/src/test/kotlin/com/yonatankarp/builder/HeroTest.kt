package com.yonatankarp.builder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class HeroTest {
    @Test
    fun `test missing profession`() {
        assertThrows(IllegalArgumentException::class.java) {
            Hero.Builder(null, "Sir without a job")
        }
    }

    @Test
    fun `test missing name`() {
        assertThrows(IllegalArgumentException::class.java) {
            Hero.Builder(Profession.THIEF, null)
        }
    }

    @Test
    fun `test build default hero`() {
        val hero = Hero.Builder(Profession.WARRIOR, "Sir Lancelot").build()

        assertNotNull(hero)
        assertNotNull(hero.toString())
        assertEquals(Profession.WARRIOR, hero.profession)
        assertEquals("Sir Lancelot", hero.name)
        assertNull(hero.armor)
        assertNull(hero.weapon)
        assertNull(hero.hairType)
        assertNull(hero.hairColor)
    }

    @Test
    fun `test build hero`() {
        val heroName = "Sir Lancelot"
        val hero = Hero.Builder(Profession.WARRIOR, heroName)
            .withArmor(Armor.CHAIN_MAIL)
            .withWeapon(Weapon.SWORD)
            .withHairType(HairType.LONG_CURLY)
            .withHairColor(HairColor.BLOND)
            .build()

        assertNotNull(hero)
        assertNotNull(hero.toString())
        assertEquals(Profession.WARRIOR, hero.profession)
        assertEquals(heroName, hero.name)
        assertEquals(Armor.CHAIN_MAIL, hero.armor)
        assertEquals(Weapon.SWORD, hero.weapon)
        assertEquals(HairType.LONG_CURLY, hero.hairType)
        assertEquals(HairColor.BLOND, hero.hairColor)
    }
}
