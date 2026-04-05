package com.yonatankarp.mediator

/**
 * Enumerates the actions that a [PartyMember] can perform.
 *
 * Each action has a [title] shown when the member acts and a
 * [description] shown when other members react.
 */
enum class Action(
    private val title: String,
    val description: String,
) {
    ENEMY("spotted enemies", "runs for cover"),
    GOLD("found gold", "takes his share of the gold"),
    HUNT("hunted a rabbit", "arrives for dinner"),
    NONE("", ""),
    TALE("tells a tale", "comes to listen"),
    ;

    override fun toString(): String = title
}
