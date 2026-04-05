package com.yonatankarp.command

/**
 * A goblin is the target of the wizard's spells.
 */
internal class Goblin : Target(
    size = Size.NORMAL,
    visibility = Visibility.VISIBLE,
) {
    override fun toString() = "Goblin"
}
