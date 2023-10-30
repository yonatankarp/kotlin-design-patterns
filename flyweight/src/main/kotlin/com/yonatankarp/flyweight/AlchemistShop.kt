package com.yonatankarp.flyweight

import com.yonatankarp.flyweight.PotionType.HEALING
import com.yonatankarp.flyweight.PotionType.HOLY_WATER
import com.yonatankarp.flyweight.PotionType.INVISIBILITY
import com.yonatankarp.flyweight.PotionType.POISON
import com.yonatankarp.flyweight.PotionType.STRENGTH

/**
 * AlchemistShop holds potions on its shelves. It uses PotionFactory to provide
 * the potions.
 */
internal class AlchemistShop {
    val topShelf: List<Potion> = run {
        val factory = PotionFactory()
        listOf(
            factory.createPotion(INVISIBILITY),
            factory.createPotion(INVISIBILITY),
            factory.createPotion(STRENGTH),
            factory.createPotion(HEALING),
            factory.createPotion(INVISIBILITY),
            factory.createPotion(STRENGTH),
            factory.createPotion(HEALING),
            factory.createPotion(HEALING)
        )
    }

    val bottomShelf: List<Potion> = run {
        val factory = PotionFactory()
        listOf(
            factory.createPotion(POISON),
            factory.createPotion(POISON),
            factory.createPotion(POISON),
            factory.createPotion(HOLY_WATER),
            factory.createPotion(HOLY_WATER)
        )
    }

    /**
     * Drink all the potions.
     */
    fun drinkPotions() {
        logger.info("Drinking top shelf potions")
        topShelf.forEach(Potion::drink)
        logger.info("Drinking bottom shelf potions")
        bottomShelf.forEach(Potion::drink)
    }
}
