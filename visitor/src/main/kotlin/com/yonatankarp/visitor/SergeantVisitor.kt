package com.yonatankarp.visitor

import org.slf4j.LoggerFactory

/**
 * A [UnitVisitor] that only interacts with [Sergeant] units.
 *
 * [Soldier] and [Commander] visits are no-ops.
 */
internal class SergeantVisitor : UnitVisitor {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun visit(soldier: Soldier) {
        // Do nothing
    }

    override fun visit(sergeant: Sergeant) {
        logger.info("Hello $sergeant")
    }

    override fun visit(commander: Commander) {
        // Do nothing
    }
}
