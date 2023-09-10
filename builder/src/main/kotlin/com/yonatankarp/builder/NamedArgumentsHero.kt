package com.yonatankarp.builder

/**
 * Hero builder based on the constructor named arguments.
 */
internal data class NamedArgumentsHero(
    val profession: Profession,
    val name: String,
    val hairType: HairType? = null,
    val hairColor: HairColor? = null,
    val armor: Armor? = null,
    val weapon: Weapon? = null,
) {
    override fun toString(): String {
        val sb = StringBuilder("This is a $profession named $name")
        if (hairColor != null || hairType != null) {
            sb.append(" with ")
            hairColor?.let { sb.append("$it ") }
            hairType?.let { sb.append("$it ") }
            sb.append(if (hairType !== HairType.BALD) "hair" else "head")
        }
        armor?.let { sb.append(" wearing $it") }
        weapon?.let { sb.append(" and wielding a $it") }
        sb.append('.')
        return sb.toString()
    }
}
