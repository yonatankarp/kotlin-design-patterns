package com.yonatankarp.visitor

/**
 * Represents a sergeant in the army hierarchy.
 *
 * A [Sergeant] reports to a [Commander] and may have
 * subordinate [Unit] nodes such as [Soldier]s.
 *
 * @param children subordinate units under this sergeant
 */
internal class Sergeant(
    children: List<Unit> = emptyList(),
) : Unit(children) {
    /**
     * Accepts a [UnitVisitor], visiting this sergeant first
     * before delegating to child units.
     *
     * @param visitor the [UnitVisitor] to accept
     */
    override fun accept(visitor: UnitVisitor) {
        visitor.visit(this)
        super.accept(visitor)
    }

    override fun toString() = "sergeant"
}
