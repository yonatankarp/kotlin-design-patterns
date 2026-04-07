package com.yonatankarp.visitor

import org.slf4j.LoggerFactory

/**
 * A [UnitVisitor] that only interacts with [Soldier] units.
 *
 * [Sergeant] and [Commander] visits are no-ops.
 */
internal class SoldierVisitor : UnitVisitor {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun visit(soldier: Soldier) {
        logger.info("Greetings $soldier")
    }

    override fun visit(sergeant: Sergeant) {
        // Do nothing
    }

    override fun visit(commander: Commander) {
        // Do nothing
    }
}
