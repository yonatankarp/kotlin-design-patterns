package com.yonatankarp.facade

/**
 * DwarvenCartOperator is one of the goldmine subsystems.
 */
internal class DwarvenCartOperator : DwarvenMineWorker() {
    override val name: String
        get() = "Dwarf cart operator"
    override fun work() =
        logger.info("$name moves gold chunks out of the mine.")
}
