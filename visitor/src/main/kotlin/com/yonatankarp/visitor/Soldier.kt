package com.yonatankarp.visitor

/**
 * Represents a soldier in the army hierarchy.
 *
 * A [Soldier] is a leaf node with no subordinates.
 *
 * @param children subordinate units (typically empty for a soldier)
 */
internal class Soldier(
    children: List<Unit> = emptyList(),
) : Unit(children) {
    /**
     * Accepts a [UnitVisitor], visiting this soldier first
     * before delegating to child units.
     *
     * @param visitor the [UnitVisitor] to accept
     */
    override fun accept(visitor: UnitVisitor) {
        visitor.visit(this)
        super.accept(visitor)
    }

    override fun toString() = "soldier"
}
