package com.yonatankarp.facade

/**
 * DwarvenGoldDigger is one of the goldmine subsystems.
 */
internal class DwarvenGoldDigger : DwarvenMineWorker() {
    override val name: String
        get() = "Dwarf gold digger"
    override fun work() = logger.info("$name digs for gold.")
}
