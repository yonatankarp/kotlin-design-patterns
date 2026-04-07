package com.yonatankarp.visitor

import org.slf4j.LoggerFactory

/**
 * A [UnitVisitor] that only interacts with [Commander] units.
 *
 * [Soldier] and [Sergeant] visits are no-ops.
 */
internal class CommanderVisitor : UnitVisitor {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun visit(soldier: Soldier) {
        // Do nothing
    }

    override fun visit(sergeant: Sergeant) {
        // Do nothing
    }

    override fun visit(commander: Commander) {
        logger.info("Good to see you $commander")
    }
}
