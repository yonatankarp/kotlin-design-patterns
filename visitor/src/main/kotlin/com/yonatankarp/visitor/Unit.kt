package com.yonatankarp.visitor

/**
 * Base class for nodes in the army hierarchy.
 *
 * Each [Unit] may have child units that are visited after the
 * unit itself when a [UnitVisitor] is accepted.
 *
 * @property children the subordinate units of this node
 */
internal sealed class Unit(val children: List<Unit> = emptyList()) {
    /**
     * Accepts a [UnitVisitor] by first visiting this node and
     * then delegating to all [children].
     *
     * @param visitor the [UnitVisitor] to accept
     */
    open fun accept(visitor: UnitVisitor) {
        children.forEach { it.accept(visitor) }
    }
}
