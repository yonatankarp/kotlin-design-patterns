package com.yonatankarp.flyweight

import com.yonatankarp.flyweight.PotionType.HEALING
import com.yonatankarp.flyweight.PotionType.HOLY_WATER
import com.yonatankarp.flyweight.PotionType.INVISIBILITY
import com.yonatankarp.flyweight.PotionType.POISON
import com.yonatankarp.flyweight.PotionType.STRENGTH
import java.util.EnumMap

/**
 * PotionFactory is the Flyweight in this example. It minimizes memory use by
 * sharing object instances. It holds a map of potion instances and new potions
 * are created only when none of the type already exists.
 */
internal class PotionFactory {
    private val potions: MutableMap<PotionType, Potion> =
        EnumMap(PotionType::class.java)

    fun createPotion(type: PotionType): Potion =
        potions[type]
            ?: when (type) {
                HEALING -> HealingPotion()
                HOLY_WATER -> HolyWaterPotion()
                INVISIBILITY -> InvisibilityPotion()
                POISON -> PoisonPotion()
                STRENGTH -> StrengthPotion()
            }
                .also { potions[type] = it }
}
