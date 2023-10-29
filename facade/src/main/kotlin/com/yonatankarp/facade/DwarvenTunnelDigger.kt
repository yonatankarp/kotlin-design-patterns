package com.yonatankarp.facade

/**
 * DwarvenTunnelDigger is one of the goldmine subsystems.
 */
internal class DwarvenTunnelDigger : DwarvenMineWorker() {
    override val name: String
        get() = "Dwarven tunnel digger"
    override fun work() = logger.info("$name creates another promising tunnel.")
}
