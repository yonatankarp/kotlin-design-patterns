package com.yonatankarp.visitor

/**
 * Represents a commander in the army hierarchy.
 *
 * A [Commander] sits at the top of the chain and may have
 * subordinate [Unit] nodes.
 *
 * @param children subordinate units under this commander
 */
internal class Commander(
    children: List<Unit> = emptyList(),
) : Unit(children) {
    /**
     * Accepts a [UnitVisitor], visiting this commander first
     * before delegating to child units.
     *
     * @param visitor the [UnitVisitor] to accept
     */
    override fun accept(visitor: UnitVisitor) {
        visitor.visit(this)
        super.accept(visitor)
    }

    override fun toString() = "commander"
}
