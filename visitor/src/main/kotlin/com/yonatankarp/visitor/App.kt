package com.yonatankarp.visitor

import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("com.yonatankarp.visitor")

/**
 * The Visitor pattern defines a mechanism to apply operations on
 * nodes in a hierarchy. New operations can be added without
 * altering the node interface.
 *
 * In this example there is a unit hierarchy beginning from
 * [Commander]. This hierarchy is traversed by visitors.
 * [SoldierVisitor] applies its operation on [Soldier]s,
 * [SergeantVisitor] on [Sergeant]s and so on.
 */
fun main() {
    val commander = Commander(
        listOf(
            Sergeant(listOf(Soldier(), Soldier(), Soldier())),
            Sergeant(listOf(Soldier(), Soldier(), Soldier())),
        ),
    )

    commander.accept(SoldierVisitor())
    commander.accept(SergeantVisitor())
    commander.accept(CommanderVisitor())
}
