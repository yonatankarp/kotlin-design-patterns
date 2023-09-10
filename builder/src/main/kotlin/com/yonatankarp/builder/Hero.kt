package com.yonatankarp.builder

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

    /**
     * The builder class.
     */
    internal class Builder(profession: Profession?, name: String?) {
        val profession: Profession
        val name: String
        var hairType: HairType? = null
        var hairColor: HairColor? = null
        var armor: Armor? = null
        var weapon: Weapon? = null

        /**
         * Constructor.
         */
        init {
            require(!(profession == null || name == null)) { "profession and name can not be null" }
            this.profession = profession
            this.name = name
        }

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
