package com.yonatankarp.builder

/**
 * Represents a role-playing game character constructed via
 * the [Builder] pattern, with required [profession] and
 * [name] and optional appearance and equipment attributes.
 */
internal data class Hero(
    val profession: Profession,
    val name: String,
    val hairType: HairType?,
    val hairColor: HairColor?,
    val armor: Armor?,
    val weapon: Weapon?,
) {
    private constructor(builder: Builder) : this(
        builder.profession,
        builder.name,
        builder.hairType,
        builder.hairColor,
        builder.armor,
        builder.weapon
    )

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

    /**
     * Accumulates optional [Hero] attributes and produces a
     * fully constructed [Hero] instance via [build].
     */
    internal class Builder(profession: Profession?, name: String?) {
        val profession: Profession = requireNotNull(profession) { "profession can not be null" }
        val name: String = requireNotNull(name) { "name can not be null" }
        var hairType: HairType? = null
        var hairColor: HairColor? = null
        var armor: Armor? = null
        var weapon: Weapon? = null

        fun withHairType(hairType: HairType?): Builder = apply {
            this.hairType = hairType
        }

        fun withHairColor(hairColor: HairColor?): Builder = apply {
            this.hairColor = hairColor
        }

        fun withArmor(armor: Armor?): Builder = apply {
            this.armor = armor
        }

        fun withWeapon(weapon: Weapon?): Builder = apply {
            this.weapon = weapon
        }

        fun build() = Hero(this)
    }
}
