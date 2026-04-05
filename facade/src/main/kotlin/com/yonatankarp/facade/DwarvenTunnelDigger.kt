package com.yonatankarp.facade

/**
 * A [DwarvenMineWorker] that digs tunnels in the mine.
 */
internal class DwarvenTunnelDigger : DwarvenMineWorker() {
    override val name: String
        get() = "Dwarven tunnel digger"
    override fun work() = logger.info("$name creates another promising tunnel.")
}
