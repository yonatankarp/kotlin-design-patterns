package com.yonatankarp.facade

/**
 * A [DwarvenMineWorker] that digs for gold in the mine.
 */
internal class DwarvenGoldDigger : DwarvenMineWorker() {
    override val name: String
        get() = "Dwarf gold digger"
    override fun work() = logger.info("$name digs for gold.")
}
