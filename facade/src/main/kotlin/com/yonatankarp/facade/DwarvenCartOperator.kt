package com.yonatankarp.facade

/**
 * A [DwarvenMineWorker] that moves gold chunks out of the mine.
 */
internal class DwarvenCartOperator : DwarvenMineWorker() {
    override val name: String
        get() = "Dwarf cart operator"
    override fun work() =
        logger.info("$name moves gold chunks out of the mine.")
}
