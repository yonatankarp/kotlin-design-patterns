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
    override fun toString(): String = buildString {
        append("This is a $profession named $name")
        if (hairColor != null || hairType != null) {
            append(" with ")
            hairColor?.let { append("$it ") }
            hairType?.let { append("$it ") }
            append(if (hairType !== HairType.BALD) "hair" else "head")
        }
        armor?.let { append(" wearing $it") }
        weapon?.let { append(" and wielding a $it") }
        append('.')
    }
}
